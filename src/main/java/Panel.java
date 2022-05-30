import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Panel extends JPanel {

    Timer timer;
    Random rand;
    SortHandler handler;

    public Panel() {
        timer = new Timer(25, new TimerListener());
        timer.start();

        setBackground(new Color(0));

        rand = new Random();
        handler = new SortHandler(800, new BubbleSort());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        handler.draw(g);
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }
    }

    public void update() {
        handler.update();
    }

}
