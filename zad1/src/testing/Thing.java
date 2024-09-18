package testing;

public class Thing implements Runnable {
    private boolean doStop = false;
    @Override
    public void run() {
        while (keepRunning()){
            System.out.print("Chnto");
            try {
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private synchronized boolean keepRunning(){
        return !doStop;
    }
    public synchronized void Stop(){
        doStop = true;
    }
}
