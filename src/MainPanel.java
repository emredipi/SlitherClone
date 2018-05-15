import java.awt.Image;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    Image bg;
    double x = 0;
    double y = 0;
    static Player MyPlayer;
    static Snake MySnake;
    MainPanel(Player player){
        MyPlayer=player;
        MySnake=Frame.game.snakeList.get(Frame.game.players.get(player.getIp()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int bg_width=20;


        Snake mysnake=MainPanel.MySnake;
        Oval head=mysnake.positions.get(0);
        double DifX=head.getCenterX()-Frame.panel.getWidth()/2;
        double DifY=head.getCenterY()-Frame.panel.getHeight()/2;

        head.x=Frame.panel.getWidth()/2;
        Frame.panel.x=DifX;
        Frame.panel.y=DifY;

        int i=0;
        for (Oval oval: MySnake.positions) {
            g2.setColor((i%10==1||i%10==0)?Color.black:new Color(255,254,102));
            g2.fill(oval);
            i++;
        }

        for ( i=-1*bg_width;i<bg_width;i++){
            for (int j=-1*bg_width;j<bg_width;j++){
                g2.drawImage(bg,(int)x+j*250,(int)y+i*250,Color.BLACK,this);
            }
        }


        for(Food food:Frame.game.foods){
            g2.setColor(food.getColor());
            g2.fill(food);
        }

        for (Snake snake:Frame.game.snakeList){
            for (Oval oval: snake.positions) {
                g2.setColor((i%10==1||i%10==0)?Color.black:snake.color);
                g2.fill(oval);
                i++;
            }
        }

        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.3f));

        g2.setColor(Color.BLACK);
        g2.fillRect(0,getHeight()-100,150,100);
        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 1));

        g2.setColor(Color.WHITE);
        g2.drawString("Score:    "+MySnake.point,20,getHeight()-80);
        g2.drawString("Length:   "+MySnake.positions.size(),20,getHeight()-60);
        g2.drawString("Speed:    "+MySnake.speed,20,getHeight()-40);
        g2.drawString("Time:     "+StepHandler.getTime() ,20,getHeight()-20);
    }




}
