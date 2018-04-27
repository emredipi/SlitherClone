import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class MainPanel extends JPanel {
    int ovalWidth=30;
    Snake snake = new Snake(ovalWidth,this);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        /*
        Graphics2D g2 = (Graphics2D)g;
        Point p = MouseInfo.getPointerInfo().getLocation();
        Rectangle2D.Float r = new Rectangle2D.Float(10,20,50,60);
        g2.draw(r);
        Ellipse2D.Float r2 = new Ellipse2D.Float(this.getWidth()/2,this.getHeight()/2,10,10);
        g2.draw(r2);
        */


        g.setColor(Color.red);
        g.fillOval( getWidth()/2,getHeight()/2,10,10);
        g.setColor(Color.black);
        for (Oval oval: snake.positions) {
            g.fillOval(oval.getX(),oval.getY(),ovalWidth,ovalWidth);
        }
    }




}
