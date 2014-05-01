import java.io.FileNotFoundException;

/**
 * Created by Фирюза on 19.04.14.
 */
public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            SortingTool.sort("C:\\Фирюза!!!\\ИиП\\ПрогаммированиеJava\\data.csv", "C:\\Фирюза!!!\\ИиП\\ПрогаммированиеJava\\sort.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
