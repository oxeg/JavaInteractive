package dev.oxeg.intsorter.oxeg;

import dev.oxeg.intsorter.IntSorter;

import java.util.Arrays;

public class OxegImplementation implements IntSorter {
    @Override
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }
}
