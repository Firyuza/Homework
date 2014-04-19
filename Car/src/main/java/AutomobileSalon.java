import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Фирюза on 18.04.14.
 */
public class AutomobileSalon {
    private ArrayList<Racecar1> racecar1;
    private ArrayList<Racecar2> racecar2;
    private ArrayList<Truck1> truck1;
    private ArrayList<Automobile1> automobile;

    public String[] allCars = {"Racecar1", "Racecar2", "Truck1", "Automobile1", "Automobile1", "Truck1"};

    public AutomobileSalon() throws Exception {
        try {
            creatList(allCars);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Car createCar(String carType) throws Exception {
        Car car;
        Random rnd = new Random();
        int id = Math.abs(rnd.nextInt() % 6);
        if(carType.equals("Racecar1")) {
            car = new Racecar1("White", id, 300);
        }
        else {
            if (carType.equals("Racecar2")) {
                car = new Racecar2("White", id, 400);
            }
            else {
                if (carType.equals("Truck1")) {
                    car = new Truck1("White", id, 50000);
                }
                else {
                    if(carType.equals("Automobile1")) {
                        car = new Automobile1("White", id);
                    }
                    else throw new Exception();
                }
            }
        }
        return car;
    }

    private void creatList(String[] allCars) throws Exception {
        racecar1 = new ArrayList<Racecar1>();
        racecar2 = new ArrayList<Racecar2>();
        truck1 = new ArrayList<Truck1>();
        automobile = new ArrayList<Automobile1>();
        for (int i = 0; i < allCars.length; i++) {
            try {
                Car car = AutomobileSalon.createCar(allCars[i]);
                if (car instanceof Racecar1) {
                    racecar1.add((Racecar1) car);
                }
                else {
                    if (car instanceof Racecar2) {
                        racecar2.add((Racecar2) car);
                    }
                    else {
                        if (car instanceof Truck1) {
                            truck1.add((Truck1) car);
                        }
                        else {
                            if (car instanceof Automobile1) {
                                automobile.add((Automobile1) car);
                            }
                            else throw new Exception();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<Car> findCar(int id) {
        ArrayList<Car> car = new ArrayList<Car>();
        for (Racecar1 obj : racecar1) {
            if(obj.getId() == id) {
                car.add(obj);
            }
        }
        for (Racecar2 obj: racecar2) {
            if (obj.getId() == id) {
                car.add(obj);
            }
        }
        for (Truck1 obj : truck1) {
            if (obj.getId() == id) {
                car.add(obj);
            }
        }
        for (Automobile1 obj : automobile) {
            if (obj.getId() == id) {
                car.add(obj);
            }
        }
        return car;
    }
    public void printCars(ArrayList<Car> list) {
      for (Car obj : list) {
          System.out.println(obj);
      }
    }
}
