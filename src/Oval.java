import java.awt.geom.Ellipse2D;

public class Oval extends Ellipse2D.Double{

    public Oval(int x, int y,int length) {
        this.x=x;
        this.y=y;
        this.height=length;
        this.width=length;
    }

    void incrementPosition(double x,double y){
        this.x+=x;
        this.y+=y;
    }
    void decrement(double x,double y){
        this.x-=x;
        this.y-=y;
    }


}
