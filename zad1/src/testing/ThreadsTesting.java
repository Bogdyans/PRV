package testing;

public class ThreadsTesting {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("thread");
                }
            }

            System.out.println("thread");
        };

        Thread th1 = new Thread(task);
        th1.start();
        Thread.sleep(1000);
        System.out.println("main");
        synchronized (lock) {
            lock.notify();
        }
    }
}
