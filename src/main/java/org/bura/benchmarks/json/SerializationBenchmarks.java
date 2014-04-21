package org.bura.benchmarks.json;

import groovy.json.JsonOutput;
import groovy.json.JsonSlurper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.boon.json.serializers.impl.JsonSimpleSerializerImpl;
import org.bura.benchmarks.json.domain.CityInfo;
import org.bura.benchmarks.json.domain.Repo;
import org.bura.benchmarks.json.domain.Request;
import org.bura.benchmarks.json.domain.UserProfile;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SerializationBenchmarks {

    private static final String RESOURCE_CITYS = "citys";
    private static final String RESOURCE_REPOS = "repos";
    private static final String RESOURCE_USER = "user";
    private static final String RESOURCE_REQUEST = "request";

    private static final String DATA_STYLE_POJO = "pojo";
    private static final String DATA_STYLE_MAPLIST = "maplist";

    @Param({ RESOURCE_CITYS, RESOURCE_REPOS, RESOURCE_USER, RESOURCE_REQUEST })
    private String resourceName;
    @Param({ DATA_STYLE_POJO, DATA_STYLE_MAPLIST })
    private String dataStyle;
    private Object data;

    @Setup(Level.Iteration)
    public void setup() throws JsonParseException, JsonMappingException, IOException {
        String resource = Helper.getResource(resourceName + ".json");
        if (dataStyle == DATA_STYLE_POJO) {
            switch (resourceName) {
            case RESOURCE_CITYS:
                data = jacksonMapper.readValue(resource, CityInfo[].class);

                break;
            case RESOURCE_REPOS:
                data = jacksonMapper.readValue(resource, Repo[].class);

                break;
            case RESOURCE_USER:
                data = jacksonMapper.readValue(resource, UserProfile.class);

                break;
            case RESOURCE_REQUEST:
                data = jacksonMapper.readValue(resource, Request.class);

                break;
            }
            needCastToMap = false;
        } else {
            data = new JsonSlurper().parseText(resource);
            needCastToMap = Arrays.asList(RESOURCE_USER, RESOURCE_REQUEST).contains(resourceName);
        }
    }

    private ObjectMapper initMapper() {
        ObjectMapper m = new ObjectMapper().enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        m.setDateFormat(formatter);

        return m;
    }

    private final ObjectMapper jacksonMapper = initMapper();

    @GenerateMicroBenchmark
    public void jackson() throws JsonParseException, JsonMappingException, IOException {
        String json = jacksonMapper.writeValueAsString(data);
        json.charAt(0);
    }

    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

    @GenerateMicroBenchmark
    public void gson() {
        String json = gson.toJson(data);
        json.charAt(0);
    }

    private final JsonSimpleSerializerImpl boon = new JsonSimpleSerializerImpl();

    @GenerateMicroBenchmark
    public void boon() {
        String json = boon.serialize(data).toString();
        json.charAt(0);
    }

    /*
     * Workaround for Groovy before 2.3.
     * (http://jira.codehaus.org/browse/GROOVY-6633)
     */
    private boolean needCastToMap;

    @GenerateMicroBenchmark
    public void groovy() {
        String json;
        if (needCastToMap) {
            json = JsonOutput.toJson((Map<?, ?>) data);
        } else {
            json = JsonOutput.toJson(data);
        }
        json.charAt(0);
    }
}
