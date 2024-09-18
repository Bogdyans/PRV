package Sorters.soloSorters;

import Sorters.SoloSorter;
import Sorters.Sorter;

import java.util.AbstractList;
import java.util.Arrays;

public class QuickSorter extends SoloSorter {

    @Override
    public AbstractList<Integer> sort() {
        qSort(0, array.size()-1);
        Arrays.sort(array.toArray());
        return array;
    }

    private void qSort(int low, int high) {
        ifs++;
        if (low < high) {
            int pivot = partition(low, high);
            qSort(low, pivot-1);
            qSort(pivot+1, high);
        }

    }

    private int partition(int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            ifs++;
            if (array.get(j) <= pivot) {
                i++;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                changes += 2;
            }
        }

        int temp = array.get(i+1);
        array.set(i+1, array.get(high));
        array.set(high, temp);
        changes += 2;
        return i+1;
    }
}
