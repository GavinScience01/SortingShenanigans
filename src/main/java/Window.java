import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        setSize(817, 840);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sowting Algowidums");
        setResizable(false);

        Panel p = new Panel();
        add(p);

        setVisible(true);
    }

}
