import java.awt.*;
import java.util.ArrayList;

public class Snake {
    MainPanel panel;
    static ArrayList<Snake> snakes = new ArrayList<Snake>();


    ArrayList<Oval> positions = new ArrayList<Oval>();
    int ovalWidth;
    int speed;

    Snake(int ovalWidth,MainPanel panel){
        this.panel=panel;
        snakes.add(this);
        this.ovalWidth=ovalWidth;
        for (int i=0;i<10;i++){
            positions.add(
                    new Oval(
                            (panel.getWidth()/2)+i*10,
                            (panel.getHeight()/2)+i*10
                    )
            );
        }


    }

}
