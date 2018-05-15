import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

public class Game implements Serializable{
    ArrayList<Food> foods = new ArrayList<>();
    SecureRandom rand = new SecureRandom();
    static int food_width=10;

    int counter;
    HashMap<String,Integer> players = new HashMap<>();
    ArrayList<Snake> snakeList = new ArrayList<>();


    void addUser(Player player){
        if (players.containsKey(player.getIp())){
            int id=players.get(player.getIp());
            snakeList.get(id).player=player;
        }else{
            players.put(player.getIp(),counter++);
            snakeList.add(new Snake(30,player));
        }
    }

    Game(){
        for (int i=0;i<1000;i++) {
            create_food();
            //todo: yemleri haritaya göre yerleştir
            //todo: yem oluşturma için method yaz
        }
    }
    void create_food(){
        int sign=(rand.nextInt(2)==0)?-1:1;
        int point=rand.nextInt(3)+1;
        foods.add(new Food(
                        rand.nextInt(3000),
                        rand.nextInt(3000),
                        point*sign,
                        point*food_width
                )
        );
    }

    void move_snakes(){
        for (Snake snake: snakeList) {
            snake.move();
        }
    }
}
