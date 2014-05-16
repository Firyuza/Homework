import javax.xml.soap.Text;
import java.io.*;

/**
 * Created by Фирюза on 26.04.14.
 */
public class ParserTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                (new FileInputStream
                        ("input2.txt"))));
        PrintWriter writer = new PrintWriter("out2.txt");
        PrintWriter sortByLexico = new PrintWriter("out2Lexico.txt");
        PrintWriter sortByOccurence = new PrintWriter("out2Occurence.txt");
        //long begin = System.currentTimeMillis();
        TextParser parser = new TextParser(reader, writer);
        parser.run();
        parser.heapSort1(sortByLexico);
        parser.heapSort2(sortByOccurence);
       // long end = System.currentTimeMillis();
        //System.out.println(end - begin);
        reader.close();
    }
}
