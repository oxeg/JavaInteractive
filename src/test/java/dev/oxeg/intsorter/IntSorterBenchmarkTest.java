package dev.oxeg.intsorter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static dev.oxeg.intsorter.IntSorterBenchmark.SAMPLE_ARRAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class IntSorterBenchmarkTest {
    private final IntSorterBenchmark benchmark = new IntSorterBenchmark();

    @Test
    void verifyOxegImplementation() {
        verifyImplementation(benchmark.oxegImplementation);
    }

    private static void verifyImplementation(IntSorter implementation) {
        var sorted = implementation.sort(Arrays.copyOf(SAMPLE_ARRAY, SAMPLE_ARRAY.length));
        verifyArraySortedCorrectly(SAMPLE_ARRAY, sorted);
    }

    @SuppressWarnings("SameParameterValue")
    private static void verifyArraySortedCorrectly(int[] initialArray, int[] sortedArray) {
        assertEquals(
                initialArray.length,
                sortedArray.length,
                "Sorted array length %d differs from initial array length %d".formatted(sortedArray.length, initialArray.length)
        );

        for (int value : initialArray) {
            var index = Arrays.binarySearch(sortedArray, value);
            if (index < 0) {
                fail("Sorted array is missing value %d from initial array".formatted(value));
            }
        }

        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                fail("Sorted array is not sorted in the ascending order");
            }
        }
    }
}