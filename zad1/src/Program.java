import Sorters.Enviroment;
import Sorters.Sorter;
import Sorters.parallelSorters.ParallelQuickSorter;
import Sorters.parallelSorters.ParallelShellSorter;
import Sorters.parallelSorters.SleepSorter;
import Sorters.soloSorters.QuickSorter;
import Sorters.soloSorters.ShellSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;

public class Program {
    private static Program program = null;

    private Sorter sorter;
    private AbstractList<Integer> arr;
    private boolean parallel = false;

    private Program(){}
    public static Program get(){
        if (program == null){
            program = new Program();
        }
        return program;
    }

    public void start(){
        initialize();
        printArray();
        double time = System.nanoTime();
        try {
            arr = sorter.sort();
        } catch (Exception e){ e.printStackTrace(); }
        time = (System.nanoTime() - time)/1e9d;

        printArray();
        System.out.println("Changes: " + sorter.getChanges() + "  Ifs: " + sorter.getIfs() + "  Time in s: " + time);
    }

    private void initialize(){
        int N = 10;
        try {
            System.out.print("Input an array size: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(reader.readLine());

            System.out.print("Parallel it:\ny or n: ");
            while (getParallel());

            System.out.print("Choose an option:\nh for shell sort\nq for quicksort\ns for sleepsort\nOption:  ");
            while (getSorter());
        } catch (IOException e){
            System.out.println("Something went wrong");
        }



        //fillRandomArray(N);
        arr = ArrayWriter.read("array.txt");

        Enviroment.setThreads(1000);
        this.sorter.initialize(this.arr);
    }

    private void fillRandomArray(int N){

        try {
            ArrayWriter.write(N);
        } catch (IOException e){
            System.out.println("Something went wrong");
        }
    }

    private void printArray(){
        System.out.print("\nArray: [");
        for (int i = 0; i < arr.size()-1; i++){
            System.out.print(arr.get(i) + ", ");
        }
        System.out.println(arr.getLast()+"];");
    }

    private boolean getSorter() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c = reader.readLine().charAt(0);
        if (c == 'h'){
            this.sorter = (this.parallel)? new ParallelShellSorter() : new ShellSorter();
        } else if (c == 'q'){
            this.sorter = (this.parallel)? new ParallelQuickSorter() : new QuickSorter();
        } else if (c == 's'){
            this.sorter = new SleepSorter();
        } else return true;
        return false;
    }

    private boolean getParallel() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c = reader.readLine().charAt(0);
        if (c == 'y'){
            this.parallel = true;
        } else if (c == 'n'){
            this.parallel = false;
        } else return true;
        return false;
    }
}
