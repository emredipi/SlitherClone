import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;
public class Player implements Serializable {
    private String Name;
    private boolean PowerUp;
    private double Degree;
    private String ip;

    Player(String name) {
        setName(name);
        try {
            setIp(InetAddress.getLocalHost().getHostAddress());
        }catch (UnknownHostException e){
            System.err.println("Unknown Host Exception: "+e.getMessage());
        }
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
