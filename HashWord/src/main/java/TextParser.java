import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Фирюза on 26.04.14.
 */
public class TextParser {
    BufferedReader reader;
    PrintWriter writer;
    HashMap<String,Integer> dictionary = new HashMap<String, Integer>();
    HeapSort1 hepify1;
    HeapSort2 hepify2;

    public TextParser(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public void run() throws IOException {
        read();
        write();
    }
    private void read() throws IOException {
        String s = reader.readLine();
        while (s != null) {
            parser(s);
            s = reader.readLine();
        }
    }

    private void parser(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        while(tokenizer.hasMoreElements()) {
            add(tokenizer.nextToken());
        }
    }
    private void add(String s) {
        int currentCount = 0;
        if(dictionary.containsKey(s)) {
            currentCount = dictionary.get(s);
        }
        dictionary.put(s,currentCount + 1);
    }
    private void write() {
        for (Map.Entry<String, Integer> token : dictionary.entrySet()) {
            writer.println(token.getKey() + " " + token.getValue());
        }
        writer.close();
    }
    public void heapSort1(PrintWriter writer1) {
        this.sort1();
        this.write1(writer1);
    }
    private void sort1() {
        this.hepify1 = new HeapSort1(this.dictionary.size());
        this.hepify1.sort(this.dictionary);
    }
    private void write1(PrintWriter writer1) {
        this.hepify1.write(writer1);
    }
    public void heapSort2(PrintWriter writer1) {
        this.sort2();
        this.write2(writer1);
    }
    private void sort2() {
        this.hepify2 = new HeapSort2(this.dictionary.size());
        this.hepify2.sort(this.dictionary);
    }
    private void write2(PrintWriter writer1) {
        this.hepify2.write(writer1, this.dictionary);
    }
}
