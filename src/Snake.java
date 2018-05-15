import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Snake implements Serializable{
    int point=0;
    int initial_length=10;
    static ArrayList<Snake> snakes = new ArrayList<Snake>();
    double directionX;
    double directionY;
    ArrayList<Oval> positions = new ArrayList<Oval>();
    int ovalWidth;
    int speed;
    Player player;
    Color color;

    Snake(int ovalWidth,Player player){
        this.player=player;
        this.ovalWidth=ovalWidth;
        for (int i=0;i<initial_length;i++){
            positions.add(
                    new Oval(
                            ovalWidth+i*10,ovalWidth+i*10,ovalWidth
                    )
            );
        }
        color=player.getColor();
        snakes.add(this);
    }

    void move(){
        directionX = Math.sin(player.getDegree())*5;
        directionY = Math.cos(player.getDegree())*5;

        Oval temp = positions.remove(positions.size()-1);
        Oval first = positions.get(0);

        temp.x=first.getX()+directionX;
        temp.y=first.getY()+directionY;
        positions.add(0,temp);
        Oval head = temp;



        ArrayList<Integer> garbage = new ArrayList<Integer>();
        for (Food food:Food.foods){


            double Rx=head.getCenterX()-food.getCenterX();
            double Ry=head.getCenterY()-food.getCenterY();
            double R = Math.sqrt(Rx*Rx+Ry*Ry);

            if(R<=(food.getWidth()/2)+(head.getWidth()/2)){
                food.x=-9999;
                food.y=-9999;
                point+=food.point;
                if (point<0){
                    point=0;
                }
                update_length();
                //todo: hızı yavaşlat
            }
        }
        for (Integer i:garbage) {
            Food.foods.remove(i);
        }
    }

    public void update_length(){
        int newsize=point/3;
        if(newsize+initial_length>=positions.size()){
            positions.add(new Oval(-9999,-9999,ovalWidth));
        }else{
            positions.remove(positions.size()-1);
        }
        //todo: son yeme gelince oyun bitmesi lazım hata veriyor
        //todo: yemi sil
    }

}
