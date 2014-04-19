/**
 * Created by Фирюза on 18.04.14.
 */
public abstract class Car implements Rideable {
    private String color;
    private int id;

    public Car(String color, int id) {
        this.color = color;
        this.id = id;
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "I'm car and my color is " + this.color + ", my id is " + this.id;
    }
}
