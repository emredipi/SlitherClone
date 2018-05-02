import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

public class MainPanel extends JPanel {
    int ovalWidth=30;
    Snake snake = new Snake(ovalWidth,this);
    Image bg = Toolkit.getDefaultToolkit().getImage("images/bg1.png");
    int x = 0;
    int y = 0;

    MainPanel(){
        SecureRandom rand = new SecureRandom();
        for (int i=0;i<1000;i++)
            Food.foods.add(new Food(
                    rand.nextInt(3000),
                    rand.nextInt(3000),
                    rand.nextInt(3)+1,
                    (rand.nextInt(2)==0)?1:-1
            )
        );
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        int bg_width=20;
        for (int i=-1*bg_width;i<bg_width;i++){
            for (int j=-1*bg_width;j<bg_width;j++){
                g.drawImage(bg,x+i*250,y+j*250,this);
            }
        }
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



        for(Food food:Food.foods){
            g.setColor(food.getColor());
            g.fillOval(food.x-(food.getWidth()/2),food.y-(food.getWidth()/2),food.getWidth(),food.getWidth());

            g.setColor(food.sign==1?Color.WHITE:Color.RED);
            g.drawOval(food.x-(food.getWidth()/2),food.y-(food.getWidth()/2),food.getWidth(),food.getWidth());
        }


        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.3f));



        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,getHeight()-100,150,100);
        g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 1));

        g2d.setColor(Color.WHITE);
        g.drawString("Score:    "+snake.point,20,getHeight()-80);
        g.drawString("Length:   "+snake.positions.size(),20,getHeight()-60);
        g.drawString("Speed:    "+snake.speed,20,getHeight()-40);
        g.drawString("Time:     "+StepHandler.getTime() ,20,getHeight()-20);



    }




}
