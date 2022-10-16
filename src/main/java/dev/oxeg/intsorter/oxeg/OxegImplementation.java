package dev.oxeg.intsorter.oxeg;

import dev.oxeg.intsorter.IntSorter;

import java.util.Arrays;

public class OxegImplementation implements IntSorter {
    @Override
    public int[] sort(int[] array) {
        var result = Arrays.copyOf(array, array.length);
        Arrays.sort(result);
        return result;
    }
}
