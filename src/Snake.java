import java.awt.*;
import java.util.ArrayList;

public class Snake {
    ArrayList<Oval> positions = new ArrayList<Oval>();
    int ovalWidth;
    MainPanel panel;
    static ArrayList<Snake> snakes = new ArrayList<Snake>();
    Snake(int ovalWidth,MainPanel panel){
        this.panel=panel;
        snakes.add(this);
        this.ovalWidth=ovalWidth;

        for (int i=0;i<100;i++){
            positions.add(
                    new Oval(
                            (panel.getWidth()/2)+i*5-ovalWidth,
                            (panel.getHeight()/2)+i*5-ovalWidth
                    )
            );
        }


    }

}
