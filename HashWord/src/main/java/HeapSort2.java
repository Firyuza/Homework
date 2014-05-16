import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Фирюза on 09.05.14.
 */
class HeapSort2 {
    private String array[];

    public HeapSort2(int size) {
        this.array = new String[size];
    }
    public void sort(HashMap<String, Integer> dictionary) {
        int i = 0;
        int N = this.array.length;
        for (Map.Entry<String, Integer> token : dictionary.entrySet()) {
            this.array[i] = token.getKey();
            i++;
        }
        for (i = N / 2 - 1; i >= 0 ; i--) {
            sink(dictionary, i, N - 1);
        }
        for (i = N - 1; i > 0; i--) {
            exch(0, i);
            sink(dictionary, 0, i - 1);
        }
    }
    private void sink(HashMap<String, Integer> dictionary, int i, int j) {
        int child;
        while (2*i < j) {
            child = 2*i + 1;
            if (child < j &&
                    (dictionary.get(this.array[child]) > dictionary.get(this.array[child + 1]) ||
                            (dictionary.get(this.array[child]) == dictionary.get(this.array[child + 1]) &&
                                    this.array[child].compareTo(this.array[child+1]) > 0))){
                child++;
            }
            if (dictionary.get(this.array[i]) < dictionary.get(this.array[child])) {
                break;
            }
            exch(i, child);
            i = child;
        }
    }
    private void exch(int i, int j) {
        String temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }
    public void write(PrintWriter writer,HashMap<String, Integer> dictionary ) {
        for (int i = 0; i < this.array.length; i++) {
            writer.println(this.array[i] + " " + dictionary.get(this.array[i]));
        }
        writer.close();
    }
}
