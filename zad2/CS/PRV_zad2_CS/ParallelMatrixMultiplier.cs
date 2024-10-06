namespace PRV2;

public static class ParallelMatrixMultiplier
{
    public static Matrix Multiply(Matrix a, Matrix b)
    {
        if (a.Size != b.Size) throw new ArgumentException("Matrix sizes don't match.");

        Matrix result = new Matrix(a.Size);

        Parallel.For(0, a.Size, i =>
        {
            for (int j = 0; j < a.Size; j++)
            {
                result[i, j] = CalculateCell(a, b, i, j);
            }
        });

        return result;
    }

    private static int CalculateCell(Matrix a, Matrix b, int row, int col)
    {
        int sum = 0;
        for (int k = 0; k < a.Size; k++)
        {
            sum += a[row, k] * b[k, col];
        }
        return sum;
    }
}   