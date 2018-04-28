import java.util.ArrayList;

public class Food {
    int x;
    int y;
    int width;
    static ArrayList<Food> foods = new ArrayList<Food>();
    Food(int x,int y,int width){
        this.x=x;
        this.y=y;
        this.width=width;
        foods.add(this);
    }
}
