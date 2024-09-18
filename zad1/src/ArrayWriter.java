import java.io.*;
import java.nio.Buffer;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayWriter {
    public static void write(int N) throws IOException {
        AbstractList<Integer> x = fillRandomArray(N);


        BufferedWriter outputWriter = new BufferedWriter(new FileWriter("array.txt"));
        for (int i = 0; i < x.size(); i++) {
            // Maybe:
            outputWriter.write(x.get(i)+" ");
        }
        outputWriter.close();
    }

    public static AbstractList<Integer> read(String path){
        AbstractList<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                for (String value : values) {
                    numbers.add(Integer.parseInt(value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    private static ArrayList<Integer> fillRandomArray(int N){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++){
            arr.add(i, i);
        }

        Collections.shuffle(arr);
        return arr;
    }
}
