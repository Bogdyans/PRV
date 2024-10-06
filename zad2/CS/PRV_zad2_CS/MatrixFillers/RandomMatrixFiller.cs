using PRV2;

namespace MatrixFillers;

public class RandomMatrixFiller : IMatrixFiller<int>
{
    private Random _random;
    private Func<int> _valueGenerator;

    public RandomMatrixFiller(Func<int> valueGenerator)
    {
            _random = new Random();
            _valueGenerator = valueGenerator;
    }
    public void Fill(Matrix matrix)
    {
        for (int i = 0; i < matrix.Size; i++)
        {
            for (int j = 0; j < matrix.Size; j++)
            {
                matrix[i, j] = _valueGenerator();
            }
        }
    }
}