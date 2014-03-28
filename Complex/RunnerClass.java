/**
 * Created by Фирюза on 15.03.14.
 */
import ru.kpfu.npp.math.MatrixArrayImpl;
import myjava.npp.homework.march2314.ComplexNumber;

public class RunnerClass {
    public static void main(String args[]) {
       /*
        MatrixArrayImpl matrix;
        matrix = new MatrixArrayImpl();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30 ; j++) {
                matrix.setValue(i, j, i + j);
            }
        }
        System.out.println(matrix);*/
        ComplexNumber complex1 = new ComplexNumber(3,-2);
        ComplexNumber complex2 = new ComplexNumber(7,9);
        complex1.add(complex2);
        System.out.println("complex1 = " + complex1.toString());
        complex2.subtract(complex1);
        System.out.println("complex2 = " + complex2.toString());
        complex1.conjugate();
        System.out.println("complex1 = " + complex1.toString());
        double atng = complex2.getArg();
        System.out.println(atng);
        double module = complex1.getModule();
        System.out.println(module);
    }
 }
