/**
 * Created by Фирюза on 18.04.14.
 */
public abstract class Racecar extends Car {
    private double speed;

    public Racecar(String color, int id, double speed) {
        super(color, id);
        this.speed = speed;
    }
    public double getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void ride() {
        System.out.println("I can ride faster then others");
    }
}
