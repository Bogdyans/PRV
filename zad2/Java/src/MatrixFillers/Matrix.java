package MatrixFillers;

import java.util.ArrayList;

public class Matrix {

    private ArrayList<Integer>[] matrix;
    private int size;

    public Matrix(int size) {
        matrix = new ArrayList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            matrix[i] = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                matrix[i].add(0);
            }
        }
    }

    public int get(int i, int j){
        return matrix[i].get(j);
    }
    public void set(int i, int j, int value){
        matrix[i].set(j, value);
    }
    public int size(){
        return size;
    }

    public Matrix clone()
    {
        Matrix m = new Matrix(size);
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                m.set(i, j, matrix[i].get(j));
            }
        }
        return m;
    }

    private void validateIndicies(int row, int col)
    {
        if (row < 0 || col < 0 || row >= size || col >= size)
        {
            throw new IndexOutOfBoundsException("Invalid matrix range.");
        }
    }

    public static Matrix multiply(Matrix m1, Matrix m2){
        if (m1.size != m2.size) throw new IllegalArgumentException("Matrix sizes don't match.");

        Matrix mr = new Matrix(m1.size);

        for (int i = 0; i < m1.size; i++)
        {
            for (int j = 0; j <  m1.size; j++)
            {
                mr.set(i, j, calculateCell(m1, m2, i, j));
            }
        }
        return mr;
    }

    private static int calculateCell(Matrix m1, Matrix m2, int row, int col)
    {
        int res = 0;
        for (int i = 0; i < m1.size; i++)
        {
            res += m1.get(row, i) * m2.get(i, col);
        }

        return res;
    }
}
