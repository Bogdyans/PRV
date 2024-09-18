package Sorters.parallelSorters;

import Sorters.ParallelSorter;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

public class SleepSorter extends ParallelSorter {
    @Override
    public AbstractList<Integer> sort() {
        ArrayList<Integer> sortedList = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(array.size());

        // Создаем потоки для каждого элемента массива
        for (Integer number : array) {
            new Thread(() -> {
                try {
                    // Поток "засыпает" на время, равное значению элемента
                    Thread.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (sortedList) {
                    sortedList.add(number);
                    changes++;  // Увеличиваем количество изменений при каждом добавлении
                }
                latch.countDown();  // Уменьшаем счетчик завершения
            }).start();
        }

        try {
            // Ждем завершения всех потоков
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collections.sort(sortedList);  // На всякий случай сортируем (для безопасности)
        return sortedList;
    }
}
