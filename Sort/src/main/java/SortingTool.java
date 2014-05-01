import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Фирюза on 19.04.14.
 */
public class SortingTool {
    public static void sort(String inputFileName, String outputFileName) throws FileNotFoundException {
        HumanLinkedList[] lists = new HumanLinkedList[100];
        for (int i = 0; i < 100; i++) {
            lists[i] = new HumanLinkedList();
        }
        File inputFile = new File(inputFileName);
        Scanner scanner = new Scanner(inputFile);
        String name;
        int age;
        while(scanner.hasNext()) {
            scanner.useDelimiter("\t");
            name = scanner.next();
            scanner.skip("\t");
            scanner.useDelimiter("\n");
            age = scanner.nextInt();
            scanner.skip("\n");
            Human human = new Human(name, age);
            lists[age].add(human);
        }
        HumanLinkedList resultList = lists[0];
        for (int i = 0; i < 100; i++) {
            resultList.append(lists[i]);
        }
        PrintWriter outputFile = new PrintWriter(outputFileName);
        while(!resultList.endOfList()) {
            outputFile.print(resultList.getCurrent());
        }
        scanner.close();
        outputFile.close();
    }
}
