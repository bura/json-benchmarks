# JSON serialization benchmarks

## Methodology

Participants:

- [Jackson](http://wiki.fasterxml.com/JacksonRelease20)
- [Gson](https://code.google.com/p/google-gson/)
- [Boon](https://github.com/RichardHightower/boon)
- [Groovy](http://groovy.codehaus.org/)
- [Groovy2.3](http://groovy.codehaus.org/)

For testing were selected data with different structure:

- **[citys](src/main/resources/citys.json)** - A large array (29470 items) of simple objects. The compact json representation takes about 2.5 MB.
- **[repos.json](src/main/resources/repos.json)** - An array of four objects with complex structure. The compact json representation takes about 342.8 kB.
- **[user.json](src/main/resources/user.json)** - one object with a complex structure. The compact json representation takes about 4.2 kB.
- **[response.json](src/main/resources/response.json)** - one object with a simple structure. The compact json representation takes about 425 B. 

Serialization was tested in two versions:

- pojo - Objects were presented as a [POJO](src/main/java/org/bura/benchmarks/json/domain) objects.
- maplist - Objects were presented as [Map](http://docs.oracle.com/javase/7/docs/api/java/util/Map.html)-s.

On deserialization were tested only transformation from [String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html) into [Map](http://docs.oracle.com/javase/7/docs/api/java/util/Map.html)-s.

## Build and Run

```shell
./gradlew clean && ./gradlew shadow -DgroovyVersion="2.2.2" && java -Xmx2048m -jar target/benchmarks.jar ".*Benchmarks.*" -f 1
```

## Results

### Serialization

| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| o.b.b.j.SerializationBenchmarks.jackson | pojo | citys | thrpt | 20 | 27.412 | 0.703 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | pojo | citys | thrpt | 20 | 15.602 | 0.280 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | pojo | citys | thrpt | 20 | 25.119 | 0.519 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | pojo | citys | thrpt | 20 | 1.684 | 0.082 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | pojo | citys | thrpt | 20 | 19.513 | 1.120 | ops/s |
| o.b.b.j.SerializationBenchmarks.jackson | pojo | repos | thrpt | 20 | 641.999 | 14.161 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | pojo | repos | thrpt | 20 | 407.093 | 5.950 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | pojo | repos | thrpt | 20 | 24173.808 | 223.995 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | pojo | repos | thrpt | 20 | 45.302 | 0.301 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | pojo | repos | thrpt | 20 | 643.902 | 10.174 | ops/s |
| o.b.b.j.SerializationBenchmarks.jackson | pojo | user | thrpt | 20 | 52324.635 | 359.331 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | pojo | user | thrpt | 20 | 22010.943 | 208.352 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | pojo | user | thrpt | 20 | 241065.787 | 1764.331 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | pojo | user | thrpt | 20 | 1751.394 | 14.458 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | pojo | user | thrpt | 20 | 47781.079 | 370.971 | ops/s |
| o.b.b.j.SerializationBenchmarks.jackson | pojo | request | thrpt | 20 | 629985.135 | 8049.270 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | pojo | request | thrpt | 20 | 267811.451 | 4064.942 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | pojo | request | thrpt | 20 | 344047.795 | 3447.635 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | pojo | request | thrpt | 20 | 28826.587 | 302.826 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | pojo | request | thrpt | 20 | 649596.700 | 6931.673 | ops/s |
| o.b.b.j.SerializationBenchmarks.jackson | maplist | citys | thrpt | 20 | 27.027 | 0.686 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | maplist | citys | thrpt | 20 | 15.997 | 0.196 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | maplist | citys | thrpt | 20 | 25.057 | 0.371 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | maplist | citys | thrpt | 20 | 1.635 | 0.073 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | maplist | citys | thrpt | 20 | 19.682 | 0.435 | ops/s |
| o.b.b.j.SerializationBenchmarks.jackson | maplist | repos | thrpt | 20 | 644.717 | 9.192 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | maplist | repos | thrpt | 20 | 403.760 | 4.575 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | maplist | repos | thrpt | 20 | 24173.738 | 216.084 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | maplist | repos | thrpt | 20 | 44.343 | 0.253 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | maplist | repos | thrpt | 20 | 653.402 | 9.880 | ops/s |
| o.b.b.j.SerializationBenchmarks.jackson | maplist | user | thrpt | 20 | 51317.860 | 590.524 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | maplist | user | thrpt | 20 | 21844.772 | 246.724 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | maplist | user | thrpt | 20 | 235728.318 | 2876.144 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | maplist | user | thrpt | 20 | 1802.383 | 15.716 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | maplist | user | thrpt | 20 | 47497.203 | 526.286 | ops/s |
| o.b.b.j.SerializationBenchmarks.jackson | maplist | request | thrpt | 20 | 616497.013 | 8990.165 | ops/s |
| o.b.b.j.SerializationBenchmarks.gson | maplist | request | thrpt | 20 | 268005.642 | 2219.178 | ops/s |
| o.b.b.j.SerializationBenchmarks.boon | maplist | request | thrpt | 20 | 353171.065 | 2502.621 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy | maplist | request | thrpt | 20 | 28985.824 | 459.033 | ops/s |
| o.b.b.j.SerializationBenchmarks.groovy-2.3 | maplist | request | thrpt | 20 | 630975.802 | 4892.114 | ops/s |

### Deserialization

| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| o.b.b.j.DeserializationBenchmarks.jackson | N/A | citys | thrpt | 20 | 21.906 | 0.162 | ops/s |
| o.b.b.j.DeserializationBenchmarks.gson | N/A | citys | thrpt | 20 | 23.377 | 0.501 | ops/s |
| o.b.b.j.DeserializationBenchmarks.boon | N/A | citys | thrpt | 20 | 72.543 | 1.054 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy | N/A | citys | thrpt | 20 | 3.182 | 0.034 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy-2.3 | N/A | citys | thrpt | 20 | 52.806 | 0.329 | ops/s |
| o.b.b.j.DeserializationBenchmarks.jackson | N/A | repos | thrpt | 20 | 484.377 | 3.571 | ops/s |
| o.b.b.j.DeserializationBenchmarks.gson | N/A | repos | thrpt | 20 | 412.508 | 6.415 | ops/s |
| o.b.b.j.DeserializationBenchmarks.boon | N/A | repos | thrpt | 20 | 1647.070 | 15.817 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy | N/A | repos | thrpt | 20 | 31.554 | 0.252 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy-2.3 | N/A | repos | thrpt | 20 | 1305.876 | 11.445 | ops/s |
| o.b.b.j.DeserializationBenchmarks.jackson | N/A | user | thrpt | 20 | 25109.072 | 225.116 | ops/s |
| o.b.b.j.DeserializationBenchmarks.gson | N/A | user | thrpt | 20 | 26982.245 | 282.070 | ops/s |
| o.b.b.j.DeserializationBenchmarks.boon | N/A | user | thrpt | 20 | 72529.259 | 687.818 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy | N/A | user | thrpt | 20 | 2338.934 | 19.511 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy-2.3 | N/A | user | thrpt | 20 | 64431.577 | 1037.016 | ops/s |
| o.b.b.j.DeserializationBenchmarks.jackson | N/A | request | thrpt | 20 | 90009.471 | 941.871 | ops/s |
| o.b.b.j.DeserializationBenchmarks.gson | N/A | request | thrpt | 20 | 268988.905 | 2165.099 | ops/s |
| o.b.b.j.DeserializationBenchmarks.boon | N/A | request | thrpt | 20 | 672907.357 | 8514.806 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy | N/A | request | thrpt | 20 | 26497.332 | 196.347 | ops/s |
| o.b.b.j.DeserializationBenchmarks.groovy-2.3 | N/A | request | thrpt | 20 | 762926.213 | 5930.640 | ops/s |

### Testing environment

Intel® Core™ i5-2410M CPU @ 2.30GHz × 4, Ubuntu 14.04 (64-Bit), Oracle Java HotSpot 64-bit 1.7.0_55
