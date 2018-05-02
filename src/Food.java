import java.awt.*;
import java.util.ArrayList;

public class Food {
    int x;
    int y;
    int point;
    int sign;
    static int Width;

    static Color FoodColors[] ={
            Color.WHITE,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.ORANGE,
            Color.RED
    };

    static ArrayList<Food> foods = new ArrayList<Food>();

    Food(int x,int y,int point,int sign){
        this.x=x;
        this.y=y;
        this.point=point;
        this.sign=sign;
        foods.add(this);
    }

    int getWidth(){
        return point*Width;
    }

    Color getColor(){
        return FoodColors[point-1+(sign==-1?3:0)];
    }
}
