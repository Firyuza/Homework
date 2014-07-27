import javax.swing.*;
import java.io.*;

/**
 * Created by Фирюза on 24.07.14.
 */
public class Program {
    public static void main(String args[]) throws IOException {
       // FileReader reader = new FileReader("C:\\Users\\Фирюза\\IdeaProjects\\BuildShell\\src\\main\\input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (new FileInputStream
                        ("C:\\\\Users\\\\Фирюза\\\\IdeaProjects\\\\BuildShell\\\\src\\\\main\\\\input.txt")));

        QuickHull hull = new QuickHull(reader);
        hull.runQuickHull();
        hull.show();
        DrawFrame frame = new DrawFrame(hull);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
