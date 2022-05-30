import java.awt.*;

public class BubbleSort implements Sorter {

    int checkIndex = 0;

    @Override
    public Rect[] iterate(Rect[] ints) {
        //cool green effect
        if (checkIndex < ints.length && check(ints)) {
            ints[checkIndex++].color = new Color(0, 255, 0);
        } else {
            SortHandler.resetColor();
        }

        int i = 1;
        while (i < ints.length) {
            if (ints[i-1].value>ints[i].value) {
                ints[i].color = new Color(255, 0, 0);
                ints = swap(ints, i);
            }
            i++;
        }
        return ints;
    }

    private Rect[] swap(Rect[] ints, int start) {
        Rect save = ints[start];
        ints[start] = ints[start-1];
        ints[start-1] = save;
        return ints;
    }

    private boolean check(Rect[] ints) {
        for (int i = 1; i < ints.length; i++) {
            if (ints[i-1].value>ints[i].value) return false;
        }
        return true;
    }
}
