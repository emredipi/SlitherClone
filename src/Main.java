import javax.swing.*;
import java.awt.*;

public class Main {
    static MainPanel panel;

    public static void main(String ars[]){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        Frame frame = new Frame();
        frame.setSize((int)width,(int)height);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        panel = new MainPanel();

        frame.add(panel);
        frame.setVisible(true);

        StepHandler handler = new StepHandler();

        panel.addMouseMotionListener(handler);
        frame.addKeyListener(handler);
        Timer timer = new Timer(1000/24,handler);
        timer.start();


    }
}
