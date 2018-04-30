import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Dimension screenSize;
    double width;
    double height;
    static MainPanel panel;

    Frame(){
        panel = new MainPanel();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();
        setSize((int)width,(int)height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
        StepHandler handler = new StepHandler();
        addMouseMotionListener(handler);
        addKeyListener(handler);
        Timer timer = new Timer(1000/24,handler);
        timer.start();
    }
}
