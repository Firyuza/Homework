import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.*;
import static java.math.BigDecimal.*;

/**
 * Created by Фирюза on 09.05.14.
 */
public class myRandom {
    private HashMap<Integer, Integer> numbers;
    private Random random;
    private int max;
    private int min;
    private double d;

    public myRandom() {
        this.random = new Random();
        this.numbers = new HashMap<Integer, Integer>();
    }
    public void generating(int k) {
        for (int i = 1000; i <= 10000000; i *= 10) {
            this.numbers.clear();
            this.randomize(k, i);
            System.out.println(i + " - " + this.average(i));
        }

    }
    private void randomize(int k, int e) {
        this.min = e;
        this.max = 1;
        for (int i = 1; i <= e; i++) {
            int currentCount = 0;
            int n = this.random.nextInt(k) + 1;
            if(this.numbers.containsKey(n)) {
                currentCount = this.numbers.get(n);
            }
            this.numbers.put(n, currentCount + 1);
            if (this.min > (currentCount + 1)) {
                this.min = currentCount + 1;
            }
            if (this.max < (currentCount + 1)) {
                this.max = currentCount + 1;
            }
        }
    }
    private double average(int n) {
        return (double)(this.max - this.min) / n;
    }

}
