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
| jackson | pojo | citys | thrpt | 20 | 27.412 | 0.703 | ops/s |
| gson | pojo | citys | thrpt | 20 | 15.602 | 0.280 | ops/s |
| boon | pojo | citys | thrpt | 20 | 25.119 | 0.519 | ops/s |
| groovy | pojo | citys | thrpt | 20 | 1.684 | 0.082 | ops/s |
| groovy-2.3 | pojo | citys | thrpt | 20 | 19.513 | 1.120 | ops/s |

Jackson wins but it is almost a tie between Jackson and Boon.
Groovy 2.3 close on the heels of Boon and Jackson.

 * Jackson 1st
 * Boon 2nd
 * Groovy 2.3 3rd




| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | pojo | repos | thrpt | 20 | 641.999 | 14.161 | ops/s |
| gson | pojo | repos | thrpt | 20 | 407.093 | 5.950 | ops/s |
| boon | pojo | repos | thrpt | 20 | 24173.808 | 223.995 | ops/s |
| groovy | pojo | repos | thrpt | 20 | 45.302 | 0.301 | ops/s |
| groovy-2.3 | pojo | repos | thrpt | 20 | 643.902 | 10.174 | ops/s |

Boon wins by a wide margin.
Groovy 2.3 beats Jackson.

 * Boon 1st
 * Groovy 2.3 2nd
 * Jackson 3rd

| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | pojo | user | thrpt | 20 | 52324.635 | 359.331 | ops/s |
| gson | pojo | user | thrpt | 20 | 22010.943 | 208.352 | ops/s |
| boon | pojo | user | thrpt | 20 | 241065.787 | 1764.331 | ops/s |
| groovy | pojo | user | thrpt | 20 | 1751.394 | 14.458 | ops/s |
| groovy-2.3 | pojo | user | thrpt | 20 | 47781.079 | 370.971 | ops/s |

Boon wins by a wide margin.
Groovy 2.3 very close to Jackson, but Jackson wins.

 * Boon 1st
 * Jackson 2nd
 * Groovy 2.3 3rd


| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | pojo | request | thrpt | 20 | 629985.135 | 8049.270 | ops/s |
| gson | pojo | request | thrpt | 20 | 267811.451 | 4064.942 | ops/s |
| boon | pojo | request | thrpt | 20 | 344047.795 | 3447.635 | ops/s |
| groovy | pojo | request | thrpt | 20 | 28826.587 | 302.826 | ops/s |
| groovy-2.3 | pojo | request | thrpt | 20 | 649596.700 | 6931.673 | ops/s |

Both Jackson and Groovy 2.3 beat Boon by 2x! Groovy 2.3 beats Jackson but almost a tie.

 * Jackson 1st
 * Groovy 2.3 2nd
 * Boon 3rd

| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | maplist | citys | thrpt | 20 | 27.027 | 0.686 | ops/s |
| gson | maplist | citys | thrpt | 20 | 15.997 | 0.196 | ops/s |
| boon | maplist | citys | thrpt | 20 | 25.057 | 0.371 | ops/s |
| groovy | maplist | citys | thrpt | 20 | 1.635 | 0.073 | ops/s |
| groovy-2.3 | maplist | citys | thrpt | 20 | 19.682 | 0.435 | ops/s |

Jackson and Boon are neck and neck, but Jackson wins.
Groovy 2.3 tight on the heels of Jackson and Boon.

 * Jackson 1st
 * Boon 2nd
 * Groovy 2.3 3rd

| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | maplist | repos | thrpt | 20 | 644.717 | 9.192 | ops/s |
| gson | maplist | repos | thrpt | 20 | 403.760 | 4.575 | ops/s |
| boon | maplist | repos | thrpt | 20 | 24173.738 | 216.084 | ops/s |
| groovy | maplist | repos | thrpt | 20 | 44.343 | 0.253 | ops/s |
| groovy-2.3 | maplist | repos | thrpt | 20 | 653.402 | 9.880 | ops/s |

Boon wins by a wide margin. Groovy 2.3 beats Jackson but it is a close race.

 * Boon 1st
 * Groovy 2.3 2nd
 * Jackson 3rd

| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | maplist | user | thrpt | 20 | 51317.860 | 590.524 | ops/s |
| gson | maplist | user | thrpt | 20 | 21844.772 | 246.724 | ops/s |
| boon | maplist | user | thrpt | 20 | 235728.318 | 2876.144 | ops/s |
| groovy | maplist | user | thrpt | 20 | 1802.383 | 15.716 | ops/s |
| groovy-2.3 | maplist | user | thrpt | 20 | 47497.203 | 526.286 | ops/s |

Boon wins by a wide margin. Groovy 2.3 and Jackson are really close, but Jackson wins.


 * Boon 1st
 * Jackson 2nd
 * Groovy 2.3 3rd


| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | maplist | request | thrpt | 20 | 616497.013 | 8990.165 | ops/s |
| gson | maplist | request | thrpt | 20 | 268005.642 | 2219.178 | ops/s |
| boon | maplist | request | thrpt | 20 | 353171.065 | 2502.621 | ops/s |
| groovy | maplist | request | thrpt | 20 | 28985.824 | 459.033 | ops/s |
| groovy-2.3 | maplist | request | thrpt | 20 | 630975.802 | 4892.114 | ops/s |


Jackson and Groovy 2.3 beat Boon by 2x.


 * Groovy 2.3 1st
 * Jackson 2nd
 * Boon 3rd

### Deserialization

| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | N/A | citys | thrpt | 20 | 21.906 | 0.162 | ops/s |
| gson | N/A | citys | thrpt | 20 | 23.377 | 0.501 | ops/s |
| boon | N/A | citys | thrpt | 20 | 72.543 | 1.054 | ops/s |
| groovy | N/A | citys | thrpt | 20 | 3.182 | 0.034 | ops/s |
| groovy-2.3 | N/A | citys | thrpt | 20 | 52.806 | 0.329 | ops/s |


Boon wins. Groovy 2.3 comes in second.

 * Boon 1st
 * Groovy 2nd
 * GSON 3rd


| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | N/A | repos | thrpt | 20 | 484.377 | 3.571 | ops/s |
| gson | N/A | repos | thrpt | 20 | 412.508 | 6.415 | ops/s |
| boon | N/A | repos | thrpt | 20 | 1647.070 | 15.817 | ops/s |
| groovy | N/A | repos | thrpt | 20 | 31.554 | 0.252 | ops/s |
| groovy-2.3 | N/A | repos | thrpt | 20 | 1305.876 | 11.445 | ops/s |


Boon beats Jacskon by over 3x, Groovy 2.3 almost ties Boon.

 * Boon 1st
 * Groovy 2.3 2nd
 * Jackson 3rd


| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | N/A | user | thrpt | 20 | 25109.072 | 225.116 | ops/s |
| gson | N/A | user | thrpt | 20    | 26982.245 | 282.070 | ops/s |
| boon | N/A | user | thrpt | 20    | 72529.259 | 687.818 | ops/s |
| groovy | N/A | user | thrpt | 20  | 2338.934 | 19.511 | ops/s |
| groovy-2.3 | N/A | user | thrpt | 20 | 64431.577 | 1037.016 | ops/s |

Boon beats Jackson by 3x. Groovy 2.3 beats Jackson by 2x.

 * Boon 1st
 * Groovy 2.3 2nd
 * GSON 3rd


| Benchmark | (dataStyle) | (resourceName) | Mode | Samples | Mean | Mean error | Units |
|:---|---:|---:|---:|---:|---:|---:|---:|
| jackson | N/A | request | thrpt | 20 | 90,009.471 | 941.871 | ops/s |
| gson | N/A | request | thrpt | 20    | 268,988.905 | 2165.099 | ops/s |
| boon | N/A | request | thrpt | 20 | 672,907.357 | 8514.806 | ops/s |
| groovy | N/A | request | thrpt | 20 | 26497.332 | 196.347 | ops/s |
| groovy-2.3 | N/A | request | thrpt | 20 | 762,926.213 | 5930.640 | ops/s |

Jackson comes in fourth. Groovy 2.3 comes in 1st. Boon comes in second.

 * Groovy 2.3 1st
 * Boon 2nd
 * GSON 3rd



### Testing environment

Intel® Core™ i5-2410M CPU @ 2.30GHz × 4, Ubuntu 14.04 (64-Bit), Oracle Java HotSpot 64-bit 1.7.0_55
