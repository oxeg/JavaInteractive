package dev.oxeg.intsorter.berserkzak;

import dev.oxeg.intsorter.IntSorter;

public class BerserkZakImplementation implements IntSorter {

    @Override
    public int[] sort(int[] array) {
        for (int i=0; i<array.length; i++) {
            int next = array[i];
            int previous = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j]<next) {
                    next = array[j];
                    previous = j;
                }
            }
            if (i!=previous) {
                int temp = array[i];
                array[i] = array[previous];
                array[previous] = temp;
            }
        }
        return array;
    }
}
