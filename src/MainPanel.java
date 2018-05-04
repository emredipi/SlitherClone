import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

public class MainPanel extends JPanel {
    int ovalWidth=30;
    int food_width=10;
    Snake snake = new Snake(ovalWidth,this);
    Image bg = Toolkit.getDefaultToolkit().getImage("images/bg1.png");
    double x = 0;
    double y = 0;

    MainPanel(){
        SecureRandom rand = new SecureRandom();
        for (int i=0;i<1000;i++) {
            int sign=(rand.nextInt(2)==0)?-1:1;
            int point=rand.nextInt(3)+1;
            Food.foods.add(new Food(
                            rand.nextInt(3000),
                            rand.nextInt(3000),
                            point*sign,
                            point*food_width
                    )
            );
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int bg_width=20;
        for (int i=-1*bg_width;i<bg_width;i++){
            for (int j=-1*bg_width;j<bg_width;j++){

                g2.drawImage(bg,(int)x+j*250,(int)y+i*250,Color.BLACK,this);
            }
        }

        int i=0;
        for (Oval oval: snake.positions) {
            g2.setColor((i%10==1||i%10==0)?Color.black:new Color(255,252,78));
            g2.fill(oval);
            i++;
        }


        for(Food food:Food.foods){
            g2.setColor(food.getColor());
            g2.fill(food);
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
