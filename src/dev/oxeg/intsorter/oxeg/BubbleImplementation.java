package dev.oxeg.intsorter.oxeg;

import dev.oxeg.intsorter.IntSorter;

public class BubbleImplementation implements IntSorter {
    @Override
    public int[] sort(int[] array) {
        boolean swapped = true;
        int buffer;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    swapped = true;
                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                }
            }
        }
        return array;
    }
}
