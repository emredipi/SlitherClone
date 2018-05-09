import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Food extends Ellipse2D.Double {
    int point;

    static Color FoodColors[] ={
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.WHITE,
            Color.BLUE,
            Color.GREEN,
    };

    static ArrayList<Food> foods = new ArrayList<Food>();

    Food(double x,double y,int point,double length){
        this.x=x;
        this.y=y;
        this.height=length;
        this.width=length;
        this.point=point;
        foods.add(this);
    }

    Color getColor(){
        return FoodColors[(point<0)?(point+3):(point+2)];
    }
    void decrement(double x,double y){
        this.x-=x;
        this.y-=y;
    }
}
