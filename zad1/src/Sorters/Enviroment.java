package Sorters;

public class Enviroment {
    private static int Threads = 0;

    public static void setThreads(int N){
        if (N > 0){
            Threads = N;
        }
        else throw new IllegalArgumentException();
    }
    public static int getThreads(){
        return Threads;
    }
}
