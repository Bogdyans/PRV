package Sorters.parallelSorters;

import Sorters.ParallelSorter;

import java.util.AbstractList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelShellSorter extends ParallelSorter {
    @Override
    public AbstractList<Integer> sort() {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int gap : gaps) {
            for (int i = gap; i < array.size(); i++) {
                int finalI = i;
                executor.submit(() -> {
                    int temp = array.get(finalI);
                    int j;
                    for (j = finalI; j >= gap && array.get(j - gap) > temp; j -= gap) {
                        array.set(j, array.get(j - gap));
                        synchronized (this) {
                            changes++;
                            ifs++;
                        }
                    }
                    array.set(j, temp);
                });
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return array;
    }
}
