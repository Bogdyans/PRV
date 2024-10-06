using PRV2;

namespace MatrixFillers;

public interface IMatrixFiller<T>
{
    void Fill(Matrix matrix);
}