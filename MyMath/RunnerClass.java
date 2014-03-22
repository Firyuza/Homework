/**
 * Created by Фирюза on 15.03.14.
 */
import ru.kpfu.npp.math.MatrixArrayImpl;

public class RunnerClass {
    public static void main(String args[]) {

        MatrixArrayImpl matrix;
        matrix = new MatrixArrayImpl();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30 ; j++) {
                matrix.setValue(i, j, i + j);
            }
        }
        System.out.println(matrix);
    }
 }
