package dev.oxeg.intsorter;

public interface IntSorter {
    /**
     * Sort an array of integer numbers in ascending order.
     * Integer values are within range [1..1000] (both inclusive).
     * Values can repeate.
     * @param array array of shuffeled integer values
     * @return sorted array
     */
    int[] sort(int[] array);
}
