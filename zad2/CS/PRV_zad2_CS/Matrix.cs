using System.Numerics;

namespace PRV2;

public class Matrix
{
    private List<List<int>> _matrix;
    public int Size { get; private set; }

    public Matrix(int size)
    {
        Size = size;
        _matrix = new List<List<int>>(size);
        for (int i = 0; i < size; i++)
        {
            _matrix.Add(new List<int>(size));
            for (int j = 0; j < size; j++)
            {
                _matrix[i].Add(0);
            }
        }
    }

    public Matrix Clone()
    {
        Matrix m = new Matrix(Size);
        for (int i = 0; i < Size; i++)
        {
            for (int j = 0; j < Size; j++)
            {
                m[i, j] = _matrix[i][j];
            }
        }
        return m;
    }
    
    private void ValidateIndicies(int row, int col)
    {
        if (row < 0 || col < 0 || row >= Size || col >= Size)
        {
            throw new IndexOutOfRangeException("Invalid matrix range.");
        }
    }

    public Matrix MultiplyWith(Matrix m) 
    {
        if (this.Size != m.Size) throw new ArgumentException("Matrix sizes don't match.");
        
        Matrix mr = new Matrix(this.Size);

        for (int i = 0; i < this.Size; i++)
        {
            for (int j = 0; j < this.Size; j++)
            {
                mr[i, j] = CalculateCell(m, i, j);
            }
        }
        return mr;
    }

    private int CalculateCell(Matrix m2, int row, int col)
    {
        int res = 0;
        for (int i = 0; i < this.Size; i++)
        {
             res += m2[i, col] * this[row, i];
        } 
        
        return res;
    }
    public int this[int row, int col]
    {
        get
        {
            ValidateIndicies(row, col);
            return _matrix[row][col];
        }
        set
        {
            ValidateIndicies(row, col);
            _matrix[row][col] = value;
        }
    }
}