/**
 * Created by Фирюза on 17.05.14.
 */

/**
 * class Line for describing Lina based on two Points
 */
public class Line {

    private double length;
    private Point pointA;
    private Point pointB;
    private double coA;
    private double coB;
    private double coC;

    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.setCoABC();
    }

    /**
     * Define the position of Point relative to the Line, especially Is this  Point above the Line
     * @param point
     * @return
     *
     */
    public boolean isAbove(Point point) {
        return this.coA * point.getX() + this.coB * point.getY() + this.coC < 0;
    }

    /**
     * Define the position of Point relative to the Line, especially Is this Point under the Line
     * @param point
     * @return
     */
    public boolean isUnder(Point point) {
        return this.coA * point.getX() + this.coB * point.getY() + this.coC > 0;
    }

    /**
     * Distance from Point to the Line
     * @param point
     * @return
     */
    public double distance(Point point) {
        double d = Math.abs(this.coA * point.getX() + this.coB * point.getY() + this.coC) / Math.sqrt(this.coA * this.coA + this.coB * this.coB);
        return d;
    }

    /**
     * Define the equation of the Line
     */
    private void setCoABC() {
        this.coA = (double)this.pointB.getY() - this.pointA.getY();
        this.coB = (double)this.pointA.getX() - this.pointB.getX();
        this.coC = - (this.coA * this.pointB.getX() + this.coB * this.pointB.getY());
    }
}

