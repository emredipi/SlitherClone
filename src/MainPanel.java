import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

public class MainPanel extends JPanel {
    int ovalWidth=30;

    Snake snake = new Snake(ovalWidth,this);
    Image bg = Toolkit.getDefaultToolkit().getImage("images/bg5.png");
    int x = 0;
    int y = 0;



    MainPanel(){
        SecureRandom rand = new SecureRandom();
        for (int i=0;i<1000;i++)
            Food.foods.add(new Food(
                    rand.nextInt(3000),
                    rand.nextInt(3000),
                    rand.nextInt(4)*10
            )
        );
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        int bg_width=10;


        for (int i=-1*bg_width;i<bg_width;i++){
            for (int j=-1*bg_width;j<bg_width;j++){
                g.drawImage(bg,x+i*250,y+j*250,this);
            }
        }



        g.setColor(Color.black);
        /*
        Graphics2D g2 = (Graphics2D)g;
        Point p = MouseInfo.getPointerInfo().getLocation();
        Rectangle2D.Float r = new Rectangle2D.Float(10,20,50,60);
        g2.draw(r);
        Ellipse2D.Float r2 = new Ellipse2D.Float(this.getWidth()/2,this.getHeight()/2,10,10);
        g2.draw(r2);
        */
        //todo: nesleri 2Dye çevir



        int i=0;
        for (Oval oval: snake.positions) {
            g.setColor((i%10==1||i%10==0)?Color.black:new Color(255,252,78));
            i++;
            g.fillOval(oval.getX()-snake.ovalWidth/2,oval.getY()-snake.ovalWidth/2,ovalWidth,ovalWidth);
        }


        Color FoodColors[] ={
                Color.BLACK,
                Color.ORANGE,
                Color.BLUE,
                Color.pink,
                Color.GREEN
        };
        int FWcons=6;
        for(Food food:Food.foods){
            g.setColor(FoodColors[food.width/15]);
            g.fillOval(food.x-(food.width/2),food.y-(food.width/2),food.width,food.width);
        }




    }




}
