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
    public class GameThread implements Runnable {

        public Game game;
        GameThread(Game game){
            this.game=game;
        }
        @Override
        public void run() {
            new Timer(1000 / 24, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.move_snakes();
                }
            }).start();
        }
    }

    public class ServerListener implements Runnable{

        @Override
        public void run() {
            int port = 9999;
            try {
                while(true) {
                    ServerSocket ss = new ServerSocket(port);
                    Socket s = ss.accept();
                    InputStream is = s.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);
                    Player player = (Player) ois.readObject();
                    if (player != null) {
                        game.addUser(player);
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
                }
            }catch(Exception e){
                System.out.println("Hata: "+e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        game=new Game();
        Thread t2 = new Thread(new ServerListener());
        Thread t1 = new Thread(new GameThread(game));

        t2.start();
        t1.start();

    }
}
