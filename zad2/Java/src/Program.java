import MatrixFillers.*;

import java.util.Random;

public class Program {

    private static Program program = null;

    private Program() {
    }

    public static Program get() {
        if (program == null) {
            program = new Program();
        }
        return program;
    }

    public void run() {
        Matrix matrix1 = initMatrix();
        Matrix matrix2 = initMatrix();
//        PrintMatrix(matrix1);
//        System.out.println("\n\n");
//        PrintMatrix(matrix2);

        double startTime = System.nanoTime();
        Matrix matrix3 = Matrix.multiply(matrix1, matrix2);
        double time = System.nanoTime() - startTime;
//        PrintMatrix(matrix3);
        System.out.println("Time singleThread: " + time/1000000);

//        ParallelMatrixMultiplier multiplier = new ParallelMatrixMultiplier();
//        startTime = System.nanoTime();
//        matrix3 = multiplier.multiply(matrix1, matrix2);
//        time = System.nanoTime() - startTime;
//        //PrintMatrix(matrix3);
//        System.out.println("Time singleThread: " + time);
    }

    private Matrix initMatrix() {
        int matrixSize = 1000;
        Matrix matrix = new Matrix(matrixSize);

        RandomMatrixFiller filler = new RandomMatrixFiller();
        filler.fill(matrix);
        return matrix;
    }

    private void PrintMatrix(Matrix matrix)
    {
        for (int i = 0; i < matrix.size(); i++)
        {
            for (int j = 0; j < matrix.size(); j++)
            {
                System.out.print(matrix.get(i, j) + ", ");
            }
            System.out.print('\n');
        }
    }
}