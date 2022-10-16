### IntSorter
Implement interface
```java
public interface IntSorter {
    int[] sort(int[] array);
}
```
with next conditions
- Sort an array of integer numbers in ascending order
- Must return new array, original array should not be overwritten
- Integer values are within range [1..1000] (both inclusive)
- Array elements can repeate

### Run instructions
```shell
mvn clean install
java -jar target/benchmarks.jar IntSorterBenchmark
```

### Results
```shell
Benchmark                              Mode  Cnt     Score    Error  Units
IntSorterBenchmark.oxegImplementation  avgt    5  7665.518 ± 65.976  ns/op
```