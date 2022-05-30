import java.awt.*;
import java.util.Random;

public class SortHandler {

    public static Rect[] rectangles;
    public Sorter sorter;

    public SortHandler(int size, Sorter sorter) {
        rectangles = new Rect[size];
        for (int i = 0; i < size; i++) {
            rectangles[i] = new Rect((int) ((1.0 / size) * (i+1) * 800));
        }
        scramble();
        this.sorter = sorter;
    }

    public void scramble() {
        Random rand = new Random();
        for (int i = 0; i < rectangles.length; i++) {
            int flip = rand.nextInt(rectangles.length);
            Rect save = rectangles[i];
            rectangles[i] = rectangles[flip];
            rectangles[flip] = save;
        }
    }

    public void update() {
        rectangles = sorter.iterate(rectangles);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < rectangles.length; i++) {
            g.setColor(rectangles[i].color);
            g.fillRect(i * (800 / rectangles.length), 800 - rectangles[i].value, 800 / rectangles.length, rectangles[i].value);
//            g.setColor(new Color(0, 0, 0));
//            g.drawRect(i * (800 / rectangles.length), 800 - rectangles[i].value, 800 / rectangles.length, rectangles[i].value);
        }
    }

    public static void resetColor() {
        for (Rect rectangle : rectangles) {
            rectangle.color = new Color(255, 255, 255);
        }
    }

}
