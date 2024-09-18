package Sorters.soloSorters;

import Sorters.SoloSorter;
import Sorters.Sorter;

import java.util.AbstractList;

public class ShellSorter extends SoloSorter {
    @Override
    public AbstractList<Integer> sort() {
        int n = array.size();
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.size(); i += 1) {

                int temp = array.get(i);

                int j;
                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    ifs += 2;
                    array.set(j, array.get(j-gap));
                    changes++;
                }

                // put temp (the original a[i]) in its correct location
                array.set(j, temp);
                changes++;
            }
        }

        return array;
    }
}
