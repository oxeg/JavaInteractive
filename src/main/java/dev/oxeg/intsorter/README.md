### IntSorter
Implement interface
```java
public interface IntSorter {
    int[] sort(int[] array);
}
```
with next conditions
- Sort an array of integer numbers in ascending order
- It's allowed to overwrite original array
- Integer values are within range [1..1000] (both inclusive)
- Array elements can repeate

### Run instructions
```shell
mvn clean install
java -jar target/benchmarks.jar IntSorterBenchmark
```

### Results
```shell
Benchmark                                       Mode  Cnt    Score   Error  Units
IntSorterBenchmark.javaArraySortImplementation  avgt    5  190.628 ± 0.131  ns/op
IntSorterBenchmark.oxegBubbleImplementation     avgt    5  212.881 ± 0.177  ns/op
```