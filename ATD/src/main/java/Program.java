/**
 * Created by Фирюза on 05.04.14.
 */
 import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<Integer>();
        for (int i = 0; i < 9; i++) {
            System.out.println("Enter the " + (i+1) + " value");
            stack1.push(scanner.nextInt());
        }
        Stack<Integer> stack2 = new Stack<Integer>(stack1);
        System.out.print("Stack2 = " + stack2.pop() + ' ');
        int size = stack2.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack2.peek() + " ");
            stack1.push(stack2.pop());
        }
        System.out.println();
        System.out.print("Stack1 = ");
        size = stack1.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack1.pop() + " ");
        }
    }
}
