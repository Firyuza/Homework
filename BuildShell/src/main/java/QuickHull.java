import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Фирюза on 22.07.14.
 */

/**
 * Class which contains the the main method to run build hull and recursive method for finding needed Points
 */
public class QuickHull {

    private ArrayList<Point> mainSet;
    private ArrayList<Integer> resultSet = new ArrayList<Integer>();
    private ArrayList<Integer> aboveSet = new ArrayList<Integer>();
    private ArrayList<Integer> underSet = new ArrayList<Integer>();

    public QuickHull(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] buffer = line.split(" ");
        int n = Integer.parseInt(buffer[0]);
        this.mainSet = new ArrayList<Point>(n);
        Point point;
        int x, y;
        for (int i = 1; i < 2 * n; i = i + 2) {
            x = Integer.parseInt(buffer[i]);
            y = Integer.parseInt(buffer[i + 1]);
            point = new Point(x, y);
            this.mainSet.add(point);
        }
    }

    /**
     * Method which finds initial two Point : the most left and the most right.
     * Also it separates the Set on two part, where one of them is the above of the line, another vice versa.
     */
    public void runQuickHull() {
        int L = 0;
        int R = 0;

        for (int i = 1; i < this.mainSet.size(); i++) {
            if (this.mainSet.get(i).getX() < this.mainSet.get(L).getX()) {
                L = i;
            }
            if (this.mainSet.get(i).getX() > this.mainSet.get(R).getX()) {
                R = i;
            }
        }

        this.resultSet.add(L);
        this.resultSet.add(R);

        Line line = new Line(this.mainSet.get(L), this.mainSet.get(R));

        for (int i = 0; i < this.mainSet.size(); i++) {
            if (line.isAbove(this.mainSet.get(i)) && (i != L && i != R)) {
                this.aboveSet.add(i);
            }
            if (line.isUnder(this.mainSet.get(i)) && (i != L && i != R)) {
                this.underSet.add(i);
            }
        }

        this.recurQuickHull(this.aboveSet, L, R, true);
        this.recurQuickHull(this.underSet, L, R, false);
    }

    public ArrayList<Point> getMainSet() {
        return this.mainSet;
    }

    public ArrayList<Integer> getResultSet() {
        return this.resultSet;
    }

    public void show() {
        for (int i = 0; i < this.resultSet.size(); i++) {
            System.out.println(this.mainSet.get(this.resultSet.get(i)).getX() + " " + this.mainSet.get(this.resultSet.get(i)).getY());
        }
    }

    /**
     * Recursive method which find the most distant Point from the Line and
     * relative of this Point creates another set of Points which are above/under the Line(Line also changes one of its coordinates)
     * @param set
     * @param L
     * @param R
     * @param side
     */
    private void recurQuickHull(ArrayList<Integer> set, int L, int R, boolean side) {
        if(set.size() == 0) {
            return;
        }

        Line line = new Line(this.mainSet.get(L), this.mainSet.get(R));
        int Top = 0;
        double dist = line.distance(this.mainSet.get(set.get(Top)));
        double newDist;

        for (int i = 1; i < set.size(); i++) {
            newDist = line.distance(this.mainSet.get(set.get(i)));
            if (dist < newDist) {
                Top = i;
                dist = newDist;
            }
            else {
                if (dist == newDist) {
                    if (this.mainSet.get(set.get(i)).getX() < this.mainSet.get(set.get(Top)).getX()) {
                        Top = i;
                        dist = newDist;
                    }
                }
            }
        }

        this.resultSet.add(set.get(Top));

        ArrayList<Integer> H1 = new ArrayList<Integer>();
        Line lineL = new Line(this.mainSet.get(L), this.mainSet.get(set.get(Top)));
        this.filter(set, H1, lineL, side);

        this.recurQuickHull(H1, L, set.get(Top), side);

        ArrayList<Integer> H2 = new ArrayList<Integer>();
        Line lineR = new Line(this.mainSet.get(set.get(Top)), this.mainSet.get(R));
        this.filter(set, H2, lineR, side);

        this.recurQuickHull(H2, set.get(Top), R, side);
    }

    /**
     * Method separates Set on two part : above/under Line
     * @param set
     * @param list
     * @param line
     * @param side
     */
    private void filter(ArrayList<Integer> set, ArrayList<Integer> list, Line line, boolean side) {
        for (int i = 0; i < set.size(); i++) {
            if (side) {
                if (line.isAbove(this.mainSet.get(set.get(i)))) {
                    list.add(set.get(i));
                }
            }
            else {
                if (line.isUnder(this.mainSet.get(set.get(i)))) {
                    list.add(set.get(i));
                }
            }
        }
    }
}
