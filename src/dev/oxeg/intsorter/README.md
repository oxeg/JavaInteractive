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
- Array elements can repeat

### Run instructions
```shell
mvn clean install
java -jar target/benchmarks.jar IntSorterBenchmark
```

### Results
```shell
Benchmark                                       Mode  Cnt       Score      Error  Units
IntSorterBenchmark.BerserkZakImplementation     avgt    5  110003.468 ± 6775.643  ns/op
IntSorterBenchmark.javaArraySortImplementation  avgt    5     191.484 ±    3.913  ns/op
IntSorterBenchmark.oxegBubbleImplementation     avgt    5     213.381 ±    0.193  ns/op
```
