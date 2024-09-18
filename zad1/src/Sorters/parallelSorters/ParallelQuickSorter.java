package Sorters.parallelSorters;

import Sorters.Enviroment;
import Sorters.ParallelSorter;

import java.util.AbstractList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static javax.swing.text.html.HTML.Attribute.N;

public class ParallelQuickSorter extends ParallelSorter {

    @Override
    public AbstractList<Integer> sort() {

        ForkJoinPool pool = ForkJoinPool.commonPool(); // Получаем общий пул потоков
        pool.invoke(new QuickSortTask(array, 0, array.size() - 1, threads));

        return array;
    }
    private synchronized void ifs(int N){
        ifs += N;
    }

    private class QuickSortTask extends RecursiveAction {
        private final AbstractList<Integer> array;
        private final int low;
        private final int high;
        private final int THRESHOLD;

        public QuickSortTask(AbstractList<Integer> array, int low, int high, int threads) {
            this.array = array;
            this.low = low;
            this.high = high;
            THRESHOLD = threads;
        }

        @Override
        protected void compute() {
            if (low < high) {
                ifs(1);
                if (high - low < THRESHOLD) {
                    // Если количество элементов небольшое, сортируем в текущем потоке
                    quickSort(array, low, high);
                } else {
                    // Иначе создаём параллельные задачи
                    int pivotIndex = partition(array, low, high);
                    QuickSortTask leftTask = new QuickSortTask(array, low, pivotIndex - 1, THRESHOLD);
                    QuickSortTask rightTask = new QuickSortTask(array, pivotIndex + 1, high, THRESHOLD);

                    // Выполняем обе задачи параллельно
                    invokeAll(leftTask, rightTask);
                }
            }
        }
        private void quickSort(AbstractList<Integer> array, int low, int high) {
            ifs(1);
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                quickSort(array, low, pivotIndex - 1);  // Сортировка левой части
                quickSort(array, pivotIndex + 1, high); // Сортировка правой части
            }
        }

        private int partition(AbstractList<Integer> array, int low, int high) {
            int pivot = array.get(high); // Опорный элемент
            int i = low - 1; // Индекс меньшего элемента
            for (int j = low; j < high; j++) {
                ifs(1);
                if (array.get(j) <= pivot) {
                    i++;
                    // Обмен элементов array[i] и array[j]
                    int temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                    changes(2);
                }
            }
            // Обмен pivot и array[i+1]
            int temp = array.get(i+1);
            array.set(i+1, array.get(high));
            array.set(high, temp);
            changes(2);
            return i + 1; // Возвращаем индекс pivot
        }
    }
    private synchronized void changes(int N){
        changes += N;
    }

}
