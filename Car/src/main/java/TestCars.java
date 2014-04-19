import java.util.Scanner;

/**
 * Created by Фирюза on 19.04.14.
 */
public class TestCars {
    public static void main(String[] args) throws Exception {
        AutomobileSalon salon = new AutomobileSalon();
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        salon.printCars(salon.findCar(id));
    }
}
