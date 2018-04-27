import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StepHandler extends MouseMotionAdapter implements KeyListener,ActionListener{
    double angle;
    MainPanel panel=Main.panel;
    Snake snake=panel.snake;


    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        Main.panel.repaint();
    }

    public void move(){
        double directionX = Math.sin(angle)*10;
        double directionY = Math.cos(angle)*10;
        ArrayList<Oval> positions = snake.positions;
        Oval temp = positions.remove(positions.size()-1);
        Oval first = positions.get(0);
        temp.setX(first.getX()+((int)directionX));
        temp.setY(first.getY()+((int)directionY));
        positions.add(0,temp);


        double CenterX=Main.panel.getWidth()/2;
        double CenterY=Main.panel.getHeight()/2;

        double DifX=positions.get(0).getX()-CenterX;
        double DifY=positions.get(0).getY()-CenterY;

        for (Oval oval:
             positions) {
            oval.setX(oval.getX()-(int)DifX);
            oval.setY(oval.getY()-(int)DifY);
        }
        panel.repaint();

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
