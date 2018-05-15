import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Executors;

public class StepHandler extends MouseMotionAdapter implements KeyListener,ActionListener{
    double angle;
    Player player;
    Client client;

    StepHandler(Player player){
        this.player=player;
        client = new Client();
        client.sendToServer(player);
    }
    static int second=0;
    static String getTime(){
        return (second/60/24)+" : "+((second/24)%60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        second++;
        client.sendToServer(player);
        Frame.panel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        double x=0;
        double y=0;
        try{
            x = p.x-Frame.panel.getWidth()/2;
            y = p.y-Frame.panel.getHeight()/2;
        }catch (Exception e2){

        }

        angle=Math.atan2(x,y);
        player.setDegree(angle);
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
