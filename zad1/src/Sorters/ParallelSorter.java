package Sorters;

import java.util.AbstractList;

public abstract class ParallelSorter extends AbstractSorter {
    protected int threads = 0;

    @Override
    public Sorter initialize(AbstractList<Integer> arr) {
        this.array = arr;
        this.threads = Enviroment.getThreads();

        if (threads <= 0){
            throw new IllegalStateException("Threads must be greater than 0");
        }
        return this;
    }
}
