/**
 * Created by Фирюза on 18.04.14.
 */
public class Racecar1 extends Racecar{

    public Racecar1(String color, int id, double speed) {
        super(color, id, speed);
    }
    @Override
    public String toString() {
        ride();
        return super.toString();
    }
    @Override
    public void ride() {
        System.out.println("I'm Racecar1 and I can ride faster then others. My speed is " + super.getSpeed());
    }
}
