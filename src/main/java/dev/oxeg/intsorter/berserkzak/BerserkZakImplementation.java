package dev.oxeg.intsorter.berserkzak;

import dev.oxeg.intsorter.IntSorter;

import java.util.Arrays;

public class BerserkZakImplementation implements IntSorter {

    @Override
    public int[] sort(int[] array) {
        int [] Arrays = new int[1000];
        for (int i=0; i<Arrays.length; i++) {
            Arrays[i] = i + 1;
        }
        for (int i=0; i<array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j]<min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i!=min_i) {
                int temp = array[i];
                array[i] = array[min_i];
                array[min_i] = temp;
            }

        }
        return Arrays;
    }
}
