/**
 * Created by Фирюза on 09.05.14.
 */
public class TestRandom {
    public static void main(String[] args) {
        myRandom random = new myRandom();
        for (int k =10; k <= 100; k++) {
            System.out.println("#" + k);
            random.generating(k);
            System.out.println();
        }
    }
}
