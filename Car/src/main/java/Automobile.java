/**
 * Created by Фирюза on 18.04.14.
 */
public abstract class Automobile extends Car {

    public Automobile(String color, int id) {
        super(color, id);
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void ride() {
        System.out.println("I cannot ride faster than racecar and ship the heviest load, but I'm appropriate for all drivers");
    }
}
