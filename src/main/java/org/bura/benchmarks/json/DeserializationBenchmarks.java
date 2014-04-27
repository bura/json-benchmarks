package org.bura.benchmarks.json;

import groovy.json.JsonSlurper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.boon.json.JsonParser;
import org.boon.json.implementation.JsonFastParser;
import org.openjdk.jmh.annotations.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsAppend = {"-Xmx2048m", "-server", "-XX:+AggressiveOpts"})
@Measurement(iterations = 10, time = 3, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 20, time = 3, timeUnit = TimeUnit.SECONDS)
public class DeserializationBenchmarks {

    private static final String RESOURCE_CITYS = "citys";
    private static final String RESOURCE_REPOS = "repos";
    private static final String RESOURCE_USER = "user";
    private static final String RESOURCE_REQUEST = "request";

    @Param({ RESOURCE_CITYS, RESOURCE_REPOS, RESOURCE_USER, RESOURCE_REQUEST })
    private String resourceName;

    private String resource;

    @Setup(Level.Iteration)
    public void setup() {
        resource = Helper.getResource(resourceName + ".json");
        if (Arrays.asList(RESOURCE_CITYS, RESOURCE_REPOS).contains(resourceName)) {
            gsonType = new TypeToken<List<Map<String, Object>>>() {
            }.getType();

            jacksonType = new TypeReference<Set<HashMap<String, Object>>>() {
            };
        } else {
            gsonType = new TypeToken<Map<String, Object>>() {
            }.getType();
            jacksonType = new TypeReference<HashMap<String, Object>>() {
            };
        }
    }

    private final ObjectMapper jacksonMapper = new ObjectMapper();
    private TypeReference<?> jacksonType;

    @GenerateMicroBenchmark
    public Object jackson() throws IOException {
        return jacksonMapper.readValue(resource, jacksonType);
    }

    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
    private java.lang.reflect.Type gsonType;

    @GenerateMicroBenchmark
    public Object gson() {
        return gson.fromJson(resource, gsonType);
    }

    private final JsonParser boon = new JsonFastParser();

    @GenerateMicroBenchmark
    public Object boon() {
        return boon.parse(resource);
    }

    private final JsonSlurper groovy = new JsonSlurper();

    @GenerateMicroBenchmark
    public Object groovy() {
        return groovy.parseText(resource);
    }
}
