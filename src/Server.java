import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    Game game;

    public class ServerListener implements Runnable{

        @Override
        public void run() {
            int port = 9999;
            try {
                while(true) {
                    try{
                        ServerSocket ss = new ServerSocket(port);
                        Socket s = ss.accept();
                        InputStream is = s.getInputStream();
                        ObjectInputStream ois = new ObjectInputStream(is);
                        Player player = (Player) ois.readObject();
                        if (player != null)
                        {
                            game.addUser(player);
                            game.move_snakes();
                        }else {
                            throw new IllegalArgumentException();
                        }
                        OutputStream os = s.getOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(os);
                        oos.writeObject(game);
                        is.close();
                        s.close();
                        ss.close();
                        oos.close();
                        os.close();
                        s.close();
                    }catch (Exception e){

                    }
                }
            }catch(Exception e){
                System.out.println("Hata: "+e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        game=new Game();
        new Thread(new ServerListener()).start();
    }
}
