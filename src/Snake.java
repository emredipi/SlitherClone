import java.awt.*;
import java.util.ArrayList;

public class Snake {
    MainPanel panel;
    int point=0;
    int initial_length=10;
    static ArrayList<Snake> snakes = new ArrayList<Snake>();


    ArrayList<Oval> positions = new ArrayList<Oval>();
    int ovalWidth;
    int speed;

    Snake(int ovalWidth,MainPanel panel){
        this.panel=panel;
        snakes.add(this);
        this.ovalWidth=ovalWidth;
        for (int i=0;i<initial_length;i++){
            positions.add(
                    new Oval(
                            (panel.getWidth()/2)+i*10,
                            (panel.getHeight()/2)+i*10
                    )
            );
        }
    }

    public void update_length(){
        int newsize=point/3;
        if(newsize+initial_length>positions.size()){
            positions.add(new Oval(-9999,-9999));
        }else{
            positions.remove(positions.size()-1);
        }
        //todo: son yeme gelince oyun bitmesi lazım hata veriyor
        //todo: yemi sil
    }

}
