package dev.oxeg.intsorter;

public interface IntSorter {
    /**
     * Sort an array of integer numbers in ascending order.
     * Must return new array, original array should not be overwritten.
     * Integer values are within range [1..1000] (both inclusive).
     * Array elements can repeate.
     * @param array array of shuffeled integer values
     * @return sorted array
     */
    int[] sort(int[] array);
}
