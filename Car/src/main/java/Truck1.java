/**
 * Created by Фирюза on 18.04.14.
 */
public class Truck1 extends Truck {
    public Truck1(String color, int id, double carrying) {
        super(color, id, carrying);
    }
    @Override
    public String toString() {
        ride();
        return super.toString();
    }
    @Override
    public void ride() {
        System.out.println("I'm truck1 and I can ship the haviest load  then others. My carrying is " + super.gerCarrying());
    }
}
