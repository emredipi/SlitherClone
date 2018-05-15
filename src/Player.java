import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;
import java.security.SecureRandom;

public class Player implements Serializable {
    private String Name;
    private boolean PowerUp;
    private double Degree;
    private String ip;
    private Color color;

    Player(String name) {
        SecureRandom rand = new SecureRandom();
        setName(name);
        try {
            setIp(InetAddress.getLocalHost().getHostAddress());
        }catch (UnknownHostException e){
            System.err.println("Unknown Host Exception: "+e.getMessage());
        }
        color=new Color(rand.nextInt(250),rand.nextInt(250),rand.nextInt(250));

    }
    public Color getColor() {
        return color;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isPowerUp() {
        return PowerUp;
    }

    public void setPowerUp(boolean powerUp) {
        PowerUp = powerUp;
    }

    public double getDegree() {
        return Degree;
    }

    public void setDegree(double degree) {
        Degree = degree;
    }
}
