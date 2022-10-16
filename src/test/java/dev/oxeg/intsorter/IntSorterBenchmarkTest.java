package dev.oxeg.intsorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntSorterBenchmarkTest {
    private final IntSorterBenchmark benchmark = new IntSorterBenchmark();

    @Test
    void verifyOxegImplementation() {
        var sorted = benchmark.oxegImplementation.sort(IntSorterBenchmark.SAMPLE_ARRAY);
        verifyArraySorted(sorted);
    }

    private static void verifyArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                Assertions.fail("Array is not sorted in the ascending order");
            }
        }
    }
}