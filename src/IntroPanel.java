import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IntroPanel extends JPanel {
    JButton button;
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
                JTextField text = new JTextField("USERNAME");
                text.setMaximumSize(dimension);
                leftPanel.add(text);
                text.setFont(new Font("Comic Sans", Font.BOLD, 40));
                text.setHorizontalAlignment(JTextField.CENTER);

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
                        Background.setIcon(new ImageIcon("images/bg"+(select.getSelectedIndex()+1)+".png"));
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

                for (int i=0;i<5;i++){
                    JPanel GameItemPanel = new JPanel();
                    GameItemPanel.setMaximumSize(GameListDimension);
                    GameListPanel.add(GameItemPanel);
                    GameItemPanel.setBackground(Color.orange);
                    GameItemPanel.setLayout(new GridLayout(0,2));
                    JLabel GameLabel = new JLabel("Game Name");
                    GameLabel.setFont(GameFont);
                    GameLabel.setHorizontalAlignment(0);
                    JButton JoinButton = new JButton("Join");
                    GameItemPanel.add(GameLabel);
                    GameItemPanel.add(JoinButton);
                }





    }
}
