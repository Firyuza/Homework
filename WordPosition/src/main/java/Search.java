import java.io.*;
import java.util.Scanner;

/**
 * Created by Фирюза on 16.05.14.
 */
public class Search {
    private String word;
    private LinkedList list;
    private FileReader reader;

    public Search(String word, FileReader reader) {
        this.word = word;
        this.list = new LinkedList();
        this.reader =  reader;
    }

    /**
     * public method for printing all positions where our word and symbol is entering
     * @throws IOException
     */
    public void search() throws IOException {
        this.run();
        System.out.println(this.list);
    }

    /**
     * private method for runnig through the file and find positions
     * using algorithm of Knuth-Morris-Pratt
     * @throws IOException
     */
    private void run() throws IOException {
        int position = 0;
        int symbol;
        boolean end = false;
        symbol = this.reader.read();
        while (!end) {
            if ((char)symbol == this.word.charAt(0)) {
                boolean match = true;
                int i = 0;
                int neededPos = position;
                while(i < this.word.length() - 1 && !end && match) {
                    symbol = this.reader.read();
                    if (symbol != -1) {
                        position++;
                        i++;
                        if ((char)symbol != this.word.charAt(i)) {
                            match = false;
                        }
                    }
                    else {
                        end = true;
                    }
                }
                if (match && i == this.word.length() - 1) {
                    this.list.push(neededPos);
                    symbol = this.reader.read();
                    position++;
                    if (symbol == -1) {
                        end = true;
                    }
                }
            }
            else {
                symbol = this.reader.read();
                position++;
                if (symbol == -1) {
                    end = true;
                }
            }
        }
    }
}
