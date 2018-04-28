import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

public class MainPanel extends JPanel {
    int ovalWidth=30;
    Snake snake = new Snake(ovalWidth,this);
    MainPanel(){
        SecureRandom rand = new SecureRandom();
        for (int i=0;i<1000;i++)
            Food.foods.add(new Food(
                    rand.nextInt(3000),
                    rand.nextInt(3000),
                    rand.nextInt(4)
            )
        );
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int borderX=-3000;
        int borderY=-3000;
        g.drawRect(-borderX,borderY,6000,6000);
        /*
        Graphics2D g2 = (Graphics2D)g;
        Point p = MouseInfo.getPointerInfo().getLocation();
        Rectangle2D.Float r = new Rectangle2D.Float(10,20,50,60);
        g2.draw(r);
        Ellipse2D.Float r2 = new Ellipse2D.Float(this.getWidth()/2,this.getHeight()/2,10,10);
        g2.draw(r2);
        */
        //todo: nesleri 2Dye çevir

        g.setColor(Color.red);
        g.fillOval( getWidth()/2,getHeight()/2,10,10);
        int i=0;
        for (Oval oval: snake.positions) {
            g.setColor((i%10==1||i%10==0)?Color.black:new Color(255,0,0));
            i++;
            g.fillOval(oval.getX(),oval.getY(),ovalWidth,ovalWidth);
        }

        Color FoodColors[] ={
                Color.BLACK,
                Color.ORANGE,
                Color.BLUE,
                Color.pink,
                Color.GREEN
        };
        for(Food food:Food.foods){
            g.setColor(FoodColors[food.width]);
            g.fillOval(food.x,food.y,food.width*6,food.width*6);
        }


    }




}
