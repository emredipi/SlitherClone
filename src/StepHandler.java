import java.awt.*;
import java.awt.event.*;

public class StepHandler extends MouseMotionAdapter implements KeyListener,ActionListener{
    double angle;
    MainPanel panel=Frame.panel;
    Snake snake=panel.snake;



    static int second=0;
    static String getTime(){
        return (second/60/24)+" : "+((second/24)%60);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        second++;
        snake.move(angle);
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
            angle+=0.3;
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            angle-=0.3;
        }

        /*
        else if(e.getKeyCode()==KeyEvent.VK_SPACE){

            moveSnake();
            Main.panel.repaint();
        }
        */
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
