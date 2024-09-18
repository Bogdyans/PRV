package Sorters.soloSorters;

@Deprecated
public class BubbleSorter  {
//    @Override
//    public void run() {
//
//    }
//
//    private class Swapper implements Runnable {
//        private int id = 0;
//        public boolean changed = false;
//        private boolean even = false;
//        public boolean wait = false;
//        public boolean work = true;
//
//
//        public Swapper(int id) {
//            this.id = id;
//        }
//
//        private synchronized void swap(int i, int j) {
//            int temp = array.get(i);
//            array.set(i, array.get(j));
//            array.set(j, temp);
//            changes += 1;
//        }
//        @Override
//        public void run() {
//            while (work) {
//                int step = (even) ? 1 : 2;
//                for (int i = id * 2 - step; i < array.size()-1; i += threads * 2) {
//                    changed = false;
//                    if (array.get(i) > array.get(i+1)) {
//                        swap(i + 1, i);
//                        changed = true;
//                        //System.out.println(id + " Changed: " + array.get(i+1) + " and " + array.get(i) + ";");
//
//                    }
//                    ifs++;
//
//                }
//                wait = true;
//                waiting++;
//
//                even = !even;
//                while (wait) {
//                    //System.out.println(id + " wait");
//                }
//            }
//        }
//
//
//    }
//    private AbstractList<Integer> array;
//    private int changes = 0;
//    private int ifs = 0;
//    private double time = 0;
//    private int threads = 0;
//    private int waiting = 0;
//
//    private void printArray(){
//        System.out.print("\nArray: [");
//        for (int i = 0; i < array.size()-1; i++){
//            System.out.print(array.get(i) + ", ");
//        }
//        System.out.println(array.getLast()+"];");
//    }
//
//    @Override
//    public void initialize(AbstractList<Integer> arr, int threads) {
//        this.array = arr;
//        this.threads = threads;
//    }
//
//
//    @Override
//    public AbstractList<Integer> sortt() {
//
//        double time = System.nanoTime();
//        for (int j = array.size(); 0 < j; j--) {
//            for (int i = 0; i < j-1; i++) {
//                if (array.get(i) > array.get(i+1)) {
//                    int temp = array.get(i);
//                    array.set(i, array.get(i+1));
//                    array.set(i+1, temp);
//                    changes += 1;
//                }
//                ifs++;
//            }
//        }
//        this.time = (System.nanoTime() - time) * 1e-9;
//        return array;
//    }
//
//    @Override
//    public void sortParalleled() throws InterruptedException {
//        Swapper[] swappers = new Swapper[threads];
//        for (int i = 0; i < threads; i++) {
//            swappers[i] = new Swapper(i+1);
//            (new Thread(swappers[i])).start();
//        }
//        while (!(this.waiting == threads || checkSwappers(swappers))) {
//
//        }
//        int changed = 0;
//
//        while (changed < 2) {
//            boolean changedNow= false;
//            for (int i = 0; i < threads; i++) {
//                if (swappers[i].changed) {
//                    changed++;
//                    changedNow = true;
//                    break;
//                }
//            }
//            if (!changedNow) {
//                changes = 0;
//            }
//
//            //System.out.println(waiting + " " + checkSwappers(swappers));
//            for (int i = 0; i < threads; i++) {
//                swappers[i].wait = false;
//            }
//            waiting = 0;
//            while (!(this.waiting == threads || checkSwappers(swappers))) {
//
//            }
//        }
//        for (int i = 0; i < threads; i++) {
//            swappers[i].work = false;
//        }
//
//    }
//
//    private boolean checkSwappers(Swapper[] swappers) {
//        int count = 0;
//        for (Swapper swapper : swappers) {
//            if (swapper.wait) {
//                count++;
//            }
//        }
//        if (count == swappers.length) return true;
//        return false;
//    }
//
//
//    @Override
//    public double getTime() {
//        return time;
//    }
//
//    @Override
//    public int getChanges() {
//        return changes;
//    }
//
//    @Override
//    public int getIfs() {
//        return ifs;
//    }
}
