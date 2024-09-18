package Sorters;

import java.util.AbstractList;

public interface Sorter {

    Sorter initialize(AbstractList<Integer> arr);
    AbstractList<Integer> sort();
    int getChanges();
    int getIfs();

}
