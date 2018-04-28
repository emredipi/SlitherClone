import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StepHandler extends MouseMotionAdapter implements KeyListener,ActionListener{
    double angle;
    static double speed=10;
    MainPanel panel=Main.panel;
    Snake snake=panel.snake;
    ArrayList<Oval> positions = snake.positions;
    double DifX;
    double DifY;

    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
        Main.panel.repaint();
    }

    public void moveSnake(){
        double directionX = Math.sin(angle)*speed;
        double directionY = Math.cos(angle)*speed;

        Oval temp = positions.remove(positions.size()-1);
        Oval first = positions.get(0);
        temp.setX(first.getX()+((int)directionX*2));
        temp.setY(first.getY()+((int)directionY*2));
        positions.add(0,temp);


        double CenterX=Main.panel.getWidth()/2;
        double CenterY=Main.panel.getHeight()/2;
        DifX=positions.get(0).getX()-CenterX;
        DifY=positions.get(0).getY()-CenterY;

        for (Food food:Food.foods){
            food.x-=(int)directionX;
            food.y-=(int)directionY;
        }
        for (Oval oval:
                positions) {
            oval.setX((int) (oval.getX()-DifX));
            oval.setY((int) (oval.getY()-DifY));
        }

    }


    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        double x = p.x-panel.getWidth()/2;
        double y = p.y-panel.getHeight()/2;
        angle=Math.atan2(x,y);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            angle+=9;
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            angle-=9;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
