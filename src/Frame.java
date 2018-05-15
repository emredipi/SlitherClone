import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    Dimension screenSize;
    double width;
    double height;
    static MainPanel panel;
    Player player;
    static Game game;
    int bg;

    Frame(){
        IntroPanel intro = new IntroPanel();
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

                //todo server yada oyun olustur
                new Thread(new Server()).start();
                System.out.println("Oyun oluşturuldu");

            }
        });


        intro.JoinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player=new Player(intro.Name.getText().toString());
                StepHandler handler = new StepHandler(player);
                panel = new MainPanel(player);
                addMouseMotionListener(handler);
                addKeyListener(handler);
                Timer timer = new Timer(1000/24,handler);
                timer.start();

                bg = intro.bg;

                panel.bg = Toolkit.getDefaultToolkit().getImage("images/bg"+bg+".png");
                remove(intro);
                add(panel);
                invalidate();
                validate();

                /*

                */
            }
        });
    }

}
