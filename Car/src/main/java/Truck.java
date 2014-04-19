/**
 * Created by Фирюза on 18.04.14.
 */
public abstract class Truck extends Car{
    private double carrying;  // how much loads truck can ship

    public Truck(String color,int id, double carrying) {
        super(color,id);
        this.carrying = carrying;
    }
    public double gerCarrying() {
        return this.carrying;
    }
    public void setCarrying(double carrying) {
        this.carrying = carrying;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void ride() {
        System.out.println("I can ship the haviest load  then others");
    }
}
