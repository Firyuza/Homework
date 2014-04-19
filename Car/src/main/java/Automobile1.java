/**
 * Created by Фирюза on 18.04.14.
 */
public class Automobile1 extends Automobile{
    public Automobile1(String color, int id) {
        super(color, id);
    }
    @Override
    public String toString() {
        ride();
        return super.toString();
    }
    @Override
    public void ride() {
        System.out.println("I'm automobile and I cannot ride faster than racecar and ship the heviest load, but I'm appropriate for all drivers");
    }
}
