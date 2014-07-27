import javax.swing.*;

/**
 * Created by Фирюза on 26.07.14.
 */
public class DrawFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    public DrawFrame(QuickHull obj) {
        setTitle("QuickHull");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        DrawPanel panel = new DrawPanel(obj);
        add(panel);
    }
}
