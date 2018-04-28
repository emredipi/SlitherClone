import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

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
        Timer timer = new Timer(50,handler);
        timer.start();
        Scanner scan = new Scanner(System.in);
        while(true){
            StepHandler.speed=scan.nextInt();
        }


    }
}
