import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    Dimension screenSize;
    double width;
    double height;
    static MainPanel panel;

    Frame(){
        IntroPanel intro = new IntroPanel();
        panel = new MainPanel();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();
        setSize((int)width,(int)height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snaker");

        add(intro);
        setVisible(true);

        intro.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StepHandler handler = new StepHandler();
                addMouseMotionListener(handler);
                addKeyListener(handler);
                Timer timer = new Timer(1000/24,handler);
                timer.start();
                remove(intro);
                add(panel);
                invalidate();
                validate();
            }
        });
    }

}
