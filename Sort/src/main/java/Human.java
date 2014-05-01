/**
 * Created by Фирюза on 19.04.14.
 */
public class Human {

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age < 0 && this.age > 101) {
           //TODO: make exception
        }
        else {
           this.age = age;
        }
    }
    @Override
    public String toString() {
        return this.getName() + " " + this.getAge()+ "\n";
    }

}
