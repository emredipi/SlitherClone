import java.io.*;
import java.net.Socket;
public class Client{

    String serverAddressIP;
    Socket s;
    OutputStream os;
    ObjectOutputStream oos;
    public Client(){

        //todo: obje her seferinde tekrar oluşturulmamalı
    }

    void sendToServer(Object o){
        Game game = Frame.game;
        try{
            s= new Socket(serverAddressIP,9999);
            os = s.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(o);
            InputStream is = s.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Frame.game = (Game) ois.readObject();
            is.close();
            s.close();
            oos.close();
            os.close();
            s.close();
        }catch (Exception e){
            System.out.println("Hata: "+e.getMessage());
        }
    }



}

