import javafx.scene.shape.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Фирюза on 26.07.14.
 */
public class DrawPanel extends JPanel {

    private QuickHull quickHull;
    private ArrayList<Integer> sortingSet;

    public DrawPanel(QuickHull obj) {
        this.quickHull = obj;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        this.sort();

        int n = this.sortingSet.size();
        int[] xPoints = new int[n];
        int[] yPoints = new int[n];
        for(int i = 0; i < n; i++) {
            xPoints[i] = this.quickHull.getMainSet().get(this.sortingSet.get(i)).getX() * 20;
            yPoints[i] = this.quickHull.getMainSet().get(this.sortingSet.get(i)).getY() * 20;
        }
        Polygon polygon = new Polygon(xPoints, yPoints, n);
        g2.draw(polygon);
    }

    /**
     * Before giving the array of coordinates for Polygon this  Method sorts them for building convex hull
     * otherwise it will create non-convex hull
     */
    private void sort() {
        int n = this.quickHull.getResultSet().size();
        ArrayList<Integer> copySet = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            copySet.add(i, this.quickHull.getResultSet().get(i));
        }

        this.sortingSet = new ArrayList<Integer>(n);
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (this.quickHull.getMainSet().get(copySet.get(i)).getY() < this.quickHull.getMainSet().get(copySet.get(min)).getY()) {
                min = i;
            }
        }
        int x = min;
        min = copySet.get(min);
        this.sortingSet.add(copySet.get(x));
        copySet.remove(x);

        int m = 0;
        for (int i = 0; i < n - 1; i++) {
            if (this.quickHull.getMainSet().get(copySet.get(i)).getX() >= this.quickHull.getMainSet().get(min).getX()) {
                m++;
            }
        }

        int j = 0;
        while(j < m) {
            int cur = -1;
            for (int i = 0; i < copySet.size(); i++) {
                if ( cur != -1) {
                    if (this.quickHull.getMainSet().get(copySet.get(i)).getX() >= this.quickHull.getMainSet().get(min).getX() &&
                            this.quickHull.getMainSet().get(copySet.get(i)).getY() >= this.quickHull.getMainSet().get(min).getY()) {
                        if (this.quickHull.getMainSet().get(copySet.get(i)).getY() < this.quickHull.getMainSet().get(copySet.get(cur)).getY()) {
                            cur = i;
                        }
                    }
                }
                else {
                    if (this.quickHull.getMainSet().get(copySet.get(i)).getX() >= this.quickHull.getMainSet().get(min).getX() &&
                            this.quickHull.getMainSet().get(copySet.get(i)).getY() >= this.quickHull.getMainSet().get(min).getY()) {
                        cur = i;
                    }
                }
            }
            this.sortingSet.add(copySet.get(cur));
            copySet.remove(cur);
            j++;
        }

        while(copySet.size() != 0) {
            int cur = -1;
            for (int i = 0; i < copySet.size(); i++) {
                if ( cur != -1) {
                    if (this.quickHull.getMainSet().get(copySet.get(i)).getX() <= this.quickHull.getMainSet().get(min).getX() &&
                            this.quickHull.getMainSet().get(copySet.get(i)).getY() >= this.quickHull.getMainSet().get(min).getY()) {
                        if (this.quickHull.getMainSet().get(copySet.get(i)).getY() > this.quickHull.getMainSet().get(copySet.get(cur)).getY()) {
                            cur = i;
                        }
                    }
                }
                else {
                    if (this.quickHull.getMainSet().get(copySet.get(i)).getX() <= this.quickHull.getMainSet().get(min).getX() &&
                            this.quickHull.getMainSet().get(copySet.get(i)).getY() >= this.quickHull.getMainSet().get(min).getY()) {
                        cur = i;
                    }
                }
            }
            this.sortingSet.add(copySet.get(cur));
            copySet.remove(cur);
        }
    }
}
