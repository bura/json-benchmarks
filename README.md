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
./gradlew clean && ./gradlew shadow -DgroovyVersion="2.3.0-rc-2" && java -jar target/benchmarks.jar ".*Benchmarks.*"
```

*You can specify Groovy version via JVM argument.*

## Summary

| Participant | Points |
|:---|---:|
| boon | 7 768 |
| groovy-23 | 3 944 |
| jackson | 2 852 |
| gson | 2 041 |
| groovy | 203 |

Where serialization points = throughput / maxPointsInGroup * 500 (500 for pojo and 500 for maplist) and deserialization points = throughput / maxPointsInGroup * 1000.

### Summary chart

![Summary](http://chart.googleapis.com/chart?cht=bvo&chs=300x300&chd=t:2852,2041,7768,203,3944&chds=a&chxt=y&chdl=jackson|gson|boon|groovy|groovy-23&chco=FF5500|FFFF42|00FF00|C6D9FD|4D89F9)

### Improving performance of JSON processing in Groovy

![Improving performance of JSON processing in Groovy](http://chart.googleapis.com/chart?cht=bvg&chs=300x300&chd=t:99,105|1691,2254&chds=a&chxt=x,y&chdl=groovy|groovy-23&chco=C6D9FD,4D89F9&chxl=0:|Seriali...|Deseriali...)

## Results

### Serialization

#### citys / pojo

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 29.583 | 0.712 | 500 |
| gson | 15.868 | 0.242 | 268 |
| boon | 22.968 | 1.859 | 388 |
| groovy | 1.642 | 0.013 | 28 |
| groovy-23 | 21.292 | 0.384 | 360 |

#### repos / pojo

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 588.572 | 34.595 | 12 |
| gson | 405.748 | 5.039 | 8 |
| boon | 25558.668 | 341.950 | 500 |
| groovy | 42.992 | 0.353 | 1 |
| groovy-23 | 631.403 | 8.504 | 12 |

#### user / pojo

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 48749.250 | 638.189 | 60 |
| gson | 21725.097 | 204.432 | 27 |
| boon | 407332.168 | 5543.580 | 500 |
| groovy | 1762.493 | 29.396 | 2 |
| groovy-23 | 48305.928 | 882.721 | 59 |

#### request / pojo

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 616034.890 | 7202.753 | 387 |
| gson | 265142.498 | 3095.460 | 166 |
| boon | 796368.008 | 14511.769 | 500 |
| groovy | 27834.013 | 311.367 | 17 |
| groovy-23 | 650749.020 | 8503.543 | 409 |

#### citys / maplist

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 29.048 | 0.399 | 500 |
| gson | 16.148 | 0.145 | 278 |
| boon | 22.080 | 1.905 | 380 |
| groovy | 1.720 | 0.058 | 30 |
| groovy-23 | 20.925 | 0.292 | 360 |

#### repos / maplist

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 591.235 | 19.898 | 12 |
| gson | 403.107 | 10.142 | 8 |
| boon | 25672.117 | 194.468 | 500 |
| groovy | 44.443 | 0.654 | 1 |
| groovy-23 | 644.195 | 9.908 | 13 |

#### user / maplist

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 48419.297 | 829.933 | 58 |
| gson | 21972.427 | 198.518 | 26 |
| boon | 414694.175 | 5257.666 | 500 |
| groovy | 1724.633 | 18.411 | 2 |
| groovy-23 | 48042.292 | 554.332 | 58 |

#### request / maplist

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 606756.160 | 11580.419 | 390 |
| gson | 267502.003 | 4297.324 | 172 |
| boon | 777778.660 | 12337.304 | 500 |
| groovy | 28090.407 | 241.696 | 18 |
| groovy-23 | 652678.498 | 6681.015 | 420 |

### Deserialization

#### citys

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 22.045 | 0.334 | 274 |
| gson | 23.800 | 0.590 | 296 |
| boon | 80.360 | 2.319 | 1 000 |
| groovy | 2.943 | 0.159 | 37 |
| groovy-23 | 5.045 | 0.116 | 63 |

#### repos

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 472.367 | 4.605 | 277 |
| gson | 416.228 | 3.329 | 244 |
| boon | 1707.610 | 15.906 | 1 000 |
| groovy | 31.215 | 0.276 | 18 |
| groovy-23 | 1326.973 | 9.668 | 777 |

#### user

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 25414.940 | 191.885 | 308 |
| gson | 27015.990 | 469.812 | 328 |
| boon | 82433.377 | 1126.688 | 1 000 |
| groovy | 2270.985 | 19.088 | 28 |
| groovy-23 | 65594.708 | 1165.779 | 796 |

#### request

| Participant | Mean | Mean error | Points |
|:---|---:|---:|---:|
| jackson | 91491.760 | 1458.466 | 74 |
| gson | 270726.032 | 3306.713 | 220 |
| boon | 1228978.262 | 19007.280 | 1 000 |
| groovy | 26556.593 | 243.335 | 22 |
| groovy-23 | 759003.962 | 20395.552 | 618 |

### Pure results

'''
o.b.b.j.DeserializationBenchmarks.boon              N/A          citys  thrpt        10       80.360        2.319    ops/s
o.b.b.j.DeserializationBenchmarks.boon              N/A          repos  thrpt        10     1707.610       15.906    ops/s
o.b.b.j.DeserializationBenchmarks.boon              N/A           user  thrpt        10    82433.377     1126.688    ops/s
o.b.b.j.DeserializationBenchmarks.boon              N/A        request  thrpt        10  1228978.262    19007.280    ops/s
o.b.b.j.DeserializationBenchmarks.groovy            N/A          citys  thrpt        10        2.943        0.159    ops/s
o.b.b.j.DeserializationBenchmarks.groovy            N/A          repos  thrpt        10       31.215        0.276    ops/s
o.b.b.j.DeserializationBenchmarks.groovy            N/A           user  thrpt        10     2270.985       19.088    ops/s
o.b.b.j.DeserializationBenchmarks.groovy            N/A        request  thrpt        10    26556.593      243.335    ops/s
o.b.b.j.DeserializationBenchmarks.groovy-23         N/A          citys  thrpt        10        5.045        0.116    ops/s
o.b.b.j.DeserializationBenchmarks.groovy-23         N/A          repos  thrpt        10     1326.973        9.668    ops/s
o.b.b.j.DeserializationBenchmarks.groovy-23         N/A           user  thrpt        10    65594.708     1165.779    ops/s
o.b.b.j.DeserializationBenchmarks.groovy-23         N/A        request  thrpt        10   759003.962    20395.552    ops/s
o.b.b.j.DeserializationBenchmarks.gson              N/A          citys  thrpt        10       23.800        0.590    ops/s
o.b.b.j.DeserializationBenchmarks.gson              N/A          repos  thrpt        10      416.228        3.329    ops/s
o.b.b.j.DeserializationBenchmarks.gson              N/A           user  thrpt        10    27015.990      469.812    ops/s
o.b.b.j.DeserializationBenchmarks.gson              N/A        request  thrpt        10   270726.032     3306.713    ops/s
o.b.b.j.DeserializationBenchmarks.jackson           N/A          citys  thrpt        10       22.045        0.334    ops/s
o.b.b.j.DeserializationBenchmarks.jackson           N/A          repos  thrpt        10      472.367        4.605    ops/s
o.b.b.j.DeserializationBenchmarks.jackson           N/A           user  thrpt        10    25414.940      191.885    ops/s
o.b.b.j.DeserializationBenchmarks.jackson           N/A        request  thrpt        10    91491.760     1458.466    ops/s
o.b.b.j.SerializationBenchmarks.boon               pojo          citys  thrpt        10       22.968        1.859    ops/s
o.b.b.j.SerializationBenchmarks.boon               pojo          repos  thrpt        10    25558.668      341.950    ops/s
o.b.b.j.SerializationBenchmarks.boon               pojo           user  thrpt        10   407332.168     5543.580    ops/s
o.b.b.j.SerializationBenchmarks.boon               pojo        request  thrpt        10   796368.008    14511.769    ops/s
o.b.b.j.SerializationBenchmarks.boon            maplist          citys  thrpt        10       22.080        1.905    ops/s
o.b.b.j.SerializationBenchmarks.boon            maplist          repos  thrpt        10    25672.117      194.468    ops/s
o.b.b.j.SerializationBenchmarks.boon            maplist           user  thrpt        10   414694.175     5257.666    ops/s
o.b.b.j.SerializationBenchmarks.boon            maplist        request  thrpt        10   777778.660    12337.304    ops/s
o.b.b.j.SerializationBenchmarks.groovy             pojo          citys  thrpt        10        1.642        0.013    ops/s
o.b.b.j.SerializationBenchmarks.groovy             pojo          repos  thrpt        10       42.992        0.353    ops/s
o.b.b.j.SerializationBenchmarks.groovy             pojo           user  thrpt        10     1762.493       29.396    ops/s
o.b.b.j.SerializationBenchmarks.groovy             pojo        request  thrpt        10    27834.013      311.367    ops/s
o.b.b.j.SerializationBenchmarks.groovy          maplist          citys  thrpt        10        1.720        0.058    ops/s
o.b.b.j.SerializationBenchmarks.groovy          maplist          repos  thrpt        10       44.443        0.654    ops/s
o.b.b.j.SerializationBenchmarks.groovy          maplist           user  thrpt        10     1724.633       18.411    ops/s
o.b.b.j.SerializationBenchmarks.groovy          maplist        request  thrpt        10    28090.407      241.696    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23          pojo          citys  thrpt        10       21.292        0.384    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23          pojo          repos  thrpt        10      631.403        8.504    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23          pojo           user  thrpt        10    48305.928      882.721    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23          pojo        request  thrpt        10   650749.020     8503.543    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23       maplist          citys  thrpt        10       20.925        0.292    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23       maplist          repos  thrpt        10      644.195        9.908    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23       maplist           user  thrpt        10    48042.292      554.332    ops/s
o.b.b.j.SerializationBenchmarks.groovy-23       maplist        request  thrpt        10   652678.498     6681.015    ops/s
o.b.b.j.SerializationBenchmarks.gson               pojo          citys  thrpt        10       15.868        0.242    ops/s
o.b.b.j.SerializationBenchmarks.gson               pojo          repos  thrpt        10      405.748        5.039    ops/s
o.b.b.j.SerializationBenchmarks.gson               pojo           user  thrpt        10    21725.097      204.432    ops/s
o.b.b.j.SerializationBenchmarks.gson               pojo        request  thrpt        10   265142.498     3095.460    ops/s
o.b.b.j.SerializationBenchmarks.gson            maplist          citys  thrpt        10       16.148        0.145    ops/s
o.b.b.j.SerializationBenchmarks.gson            maplist          repos  thrpt        10      403.107       10.142    ops/s
o.b.b.j.SerializationBenchmarks.gson            maplist           user  thrpt        10    21972.427      198.518    ops/s
o.b.b.j.SerializationBenchmarks.gson            maplist        request  thrpt        10   267502.003     4297.324    ops/s
o.b.b.j.SerializationBenchmarks.jackson            pojo          citys  thrpt        10       29.583        0.712    ops/s
o.b.b.j.SerializationBenchmarks.jackson            pojo          repos  thrpt        10      588.572       34.595    ops/s
o.b.b.j.SerializationBenchmarks.jackson            pojo           user  thrpt        10    48749.250      638.189    ops/s
o.b.b.j.SerializationBenchmarks.jackson            pojo        request  thrpt        10   616034.890     7202.753    ops/s
o.b.b.j.SerializationBenchmarks.jackson         maplist          citys  thrpt        10       29.048        0.399    ops/s
o.b.b.j.SerializationBenchmarks.jackson         maplist          repos  thrpt        10      591.235       19.898    ops/s
o.b.b.j.SerializationBenchmarks.jackson         maplist           user  thrpt        10    48419.297      829.933    ops/s
o.b.b.j.SerializationBenchmarks.jackson         maplist        request  thrpt        10   606756.160    11580.419    ops/s
'''

### Testing environment

Intel® Core™ i5-2410M CPU @ 2.30GHz × 4, Ubuntu 14.04 (64-Bit), Oracle Java HotSpot 64-bit 1.7.0_55
