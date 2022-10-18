package dev.oxeg.intsorter.java;

import dev.oxeg.intsorter.IntSorter;

import java.util.Arrays;

public class ArraySortImplementation implements IntSorter {
    @Override
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }
}
