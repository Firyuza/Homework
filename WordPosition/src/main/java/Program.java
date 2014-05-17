import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Фирюза on 17.05.14.
 */
public class Program {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("C:\\Users\\Фирюза\\IdeaProjects\\WordPosition\\src\\main\\resources\\input.txt");
        System.out.println("Enter the word or symbol which do you want to find in that text");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        Search finder = new Search(word, file);
        finder.search();
    }
}
