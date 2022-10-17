package dev.oxeg.intsorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class IntSorterBenchmarkTest {
    private final IntSorterBenchmark benchmark = new IntSorterBenchmark();

    @Test
    void verifyOxegImplementation() {
        verifyImplementations(benchmark.oxegImplementation);
    }

    @Test
    void verifyBerserkZakImplementation() {
        verifyImplementations(benchmark.berserkZakImplementation);
    }

    private static void verifyImplementations(IntSorter implementation) {
        var sorted = implementation.sort(IntSorterBenchmark.SAMPLE_ARRAY);
        verifyArraySorted(IntSorterBenchmark.SAMPLE_ARRAY, sorted);
    }

    @SuppressWarnings("SameParameterValue")
    private static void verifyArraySorted(int[] initialArray, int[] sortedArray) {
        Assertions.assertNotSame(initialArray, sortedArray);

        Assertions.assertEquals(
                initialArray.length,
                sortedArray.length,
                "Sorted array length %d differs from initial array length %d".formatted(sortedArray.length, initialArray.length)
        );

        for (int value : initialArray) {
            var index = Arrays.binarySearch(sortedArray, value);
            if (index < 0) {
                Assertions.fail("Sorted array is missing value %d from initial array".formatted(value));
            }
        }

        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                Assertions.fail("Sorted array is not sorted in the ascending order");
            }
        }
    }
}