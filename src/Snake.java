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
        this.ovalWidth=ovalWidth;
        for (int i=0;i<initial_length;i++){
            positions.add(
                    new Oval(
                            ovalWidth+i*10,ovalWidth+i*10,ovalWidth
                    )
            );
        }
        snakes.add(this);
    }

    void move(double angle){
        double directionX = Math.sin(angle)*5;
        double directionY = Math.cos(angle)*5;

        Oval temp = positions.remove(positions.size()-1);
        Oval first = positions.get(0);

        temp.x=first.getX()+directionX*2;
        temp.y=first.getY()+directionY*2;
        positions.add(0,temp);

        Oval head = temp;
        double DifX=head.getCenterX()-panel.getWidth()/2;
        double DifY=head.getCenterY()-panel.getHeight()/2;

        panel.x-=DifX;
        panel.y-=DifY;

        for (Oval oval: positions) {
            oval.decrement(DifX,DifY);
        }

        int foodcounter=0;
        ArrayList<Integer> garbage = new ArrayList<Integer>();
        for (Food food:Food.foods){
            food.x-=directionX;
            food.y-=directionY;

            double Rx=head.getCenterX()-food.getCenterX();
            double Ry=head.getCenterY()-food.getCenterY();
            double R = Math.sqrt(Rx*Rx+Ry*Ry);

            if(R<=(food.getWidth()/2)+(head.getWidth()/2)){
                food.x=-9999;
                food.y=-9999;
                point+=food.point;
                update_length();
                //todo: hızı yavaşlat
            }
            foodcounter++;
        }
        for (Integer i:garbage) {
            Food.foods.remove(i);
        }
    }

    public void update_length(){
        int newsize=point/3;
        if(newsize+initial_length>positions.size()){
            positions.add(new Oval(-9999,-9999,ovalWidth));
        }else{
            positions.remove(positions.size()-1);
        }
        //todo: son yeme gelince oyun bitmesi lazım hata veriyor
        //todo: yemi sil
    }

}
