package Sorters;

import java.util.AbstractList;

public abstract class AbstractSorter implements Sorter{
    protected AbstractList<Integer> array;
    protected int changes = 0;
    protected int ifs = 0;

    @Override
    public Sorter initialize(AbstractList<Integer> arr) {
        this.array = arr;
        return this;
    }

    @Override
    public abstract AbstractList<Integer> sort();


    @Override
    public int getChanges() {
        return changes;
    }

    @Override
    public int getIfs() {
        return ifs;
    }
}
