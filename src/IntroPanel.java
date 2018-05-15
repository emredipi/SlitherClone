import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.InetAddress;

public class IntroPanel extends JPanel {
    JButton button;
    JButton JoinButton;
    JTextField Name;
    int bg=1;
    IntroPanel(){
        Font font = new Font("Comic Sans MS", Font.BOLD, 40);
        setLayout(new GridLayout(2,0));

        JLabel header = new JLabel(new ImageIcon("images/intro.png"));
        add(header);

        JPanel mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(new GridLayout(1,2));

            JPanel leftPanel = new JPanel();
            mainPanel.add(leftPanel);
            leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.PAGE_AXIS));

                Dimension dimension = new Dimension(500,50);
                Name = new JTextField("USERNAME");
                Name.setMaximumSize(dimension);
                leftPanel.add(Name);
                Name.setFont(new Font("Comic Sans", Font.BOLD, 40));
                Name.setHorizontalAlignment(JTextField.CENTER);

                String background[] ={
                  "Blue", "Cyan", "Orange","Red","Green","Yellow"
                };
                JComboBox<String> select = new JComboBox(background);
                select.setMaximumSize(dimension);
                leftPanel.add(select);


                JPanel bgpanel = new JPanel();
                leftPanel.add(bgpanel);
                ImageIcon image = new ImageIcon("images/bg1.png");
                JLabel Background = new JLabel(image);
                bgpanel.add(Background);
                //Background.setMaximumSize(new Dimension(400,400));


                select.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        int selected =(select.getSelectedIndex()+1);
                        Background.setIcon(new ImageIcon("images/bg"+selected+".png"));
                        bg = selected;
                    }
                });

            JPanel rightPanel = new JPanel();
            mainPanel.add(rightPanel);
            rightPanel.setBackground(Color.yellow);
            rightPanel.setLayout(new BorderLayout());
                JPanel rightTopPanel = new JPanel();
                rightPanel.add(rightTopPanel,BorderLayout.PAGE_START);
                rightTopPanel.setLayout(new GridLayout(0,2));
                    button = new JButton("Create New Game");
                    JLabel gamesText = new JLabel("Games");
                    gamesText.setFont(font);
                    gamesText.setHorizontalAlignment(0);
                    rightTopPanel.add(gamesText);
                    rightTopPanel.add(button);
            JPanel GameListPanel = new JPanel();
            rightPanel.add(GameListPanel,BorderLayout.CENTER);
            GameListPanel.setLayout(new BoxLayout(GameListPanel,BoxLayout.PAGE_AXIS));

                Dimension GameListDimension = new Dimension(10000,30);
                Font GameFont = new Font("Comic Sans MS", Font.BOLD, 20);


                JoinButton = new JButton("Join");
                JTextField serverip = new JTextField();
                JPanel GameItemPanel = new JPanel();
                GameItemPanel.setMaximumSize(GameListDimension);
                GameListPanel.add(GameItemPanel);
                GameItemPanel.setBackground(Color.orange);
                GameItemPanel.setLayout(new GridLayout(0,2));
                try{
                    String ip =InetAddress.getLocalHost().getHostAddress();
                    serverip.setHorizontalAlignment(0);
                    serverip.setText(ip);
                    GameItemPanel.add(serverip);
                    GameItemPanel.add(JoinButton);
                }catch (Exception e){

                }

    }
}
