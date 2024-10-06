package MatrixFillers;

import java.util.Random;

public class RandomMatrixFiller implements MatrixFiller<Integer> {
    @Override
    public void fill(Matrix matrix) {
        Random r = new Random();
        for (int i = 0; i < matrix.size(); i++){
            for (int j = 0; j < matrix.size(); j++){
                matrix.set(i, j, r.nextInt(0, matrix.size() * matrix.size() + 1));
            }
        }
    }
}
