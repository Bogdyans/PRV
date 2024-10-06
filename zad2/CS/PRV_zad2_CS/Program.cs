using MatrixFillers;

namespace PRV2;

public class Program
{
    private static Program? s_program;
    private Matrix _matrix;
    private Matrix _matrix2;

    private Program() {}
    public static Program Get() => s_program ??= new Program();
    

    public void Run()
    {
        InitMatrix();
        _matrix2 = _matrix.Clone();
        //PrintMatrix(_matrix2);
        
        var watch = System.Diagnostics.Stopwatch.StartNew();
        Matrix matrix3 = _matrix.MultiplyWith(_matrix2);
        watch.Stop();
        //PrintMatrix(matrix3);
        var elapsedMs = watch.ElapsedMilliseconds;
        Console.WriteLine($"Elapsed time: {elapsedMs} ms");
        
        watch = System.Diagnostics.Stopwatch.StartNew();
        matrix3 = ParallelMatrixMultiplier.Multiply(_matrix, _matrix2);
        watch.Stop();
        //PrintMatrix(matrix3);
        elapsedMs = watch.ElapsedMilliseconds;
        Console.WriteLine($"Elapsed time: {elapsedMs} ms");
    }

    private void InitMatrix()
    {
        int matrixSize;
        matrixSize = Convert.ToInt32(Console.ReadLine());
        _matrix = new Matrix(matrixSize);
        
        RandomMatrixFiller filler = new(() => new Random().Next(0, matrixSize*matrixSize+1));
        filler.Fill(_matrix);
    }

    private void PrintMatrix(Matrix matrix)
    {
        for (int i = 0; i < matrix.Size; i++)
        {
            for (int j = 0; j < matrix.Size; j++)
            {
                Console.Write(matrix[i, j] + ", ");
            }
            Console.Write('\n');
        }
    }
}