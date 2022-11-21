package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class mainFrame extends JFrame {

    mainFrame(){
        
        super("AL2000");

        JPanel cardsPanel = new JPanel(new CardLayout());
        add(cardsPanel);

        returnBluRayUI returnPanel = new returnBluRayUI();
        cardsPanel.add(returnPanel, "returnPanel");

        homeUI homeUI = new homeUI();
        cardsPanel.add(homeUI, "homeUI");

        signUpUI signUI = new signUpUI();
        cardsPanel.add(signUI, "signUpUI");

        loginUI loginUI = new loginUI();
        cardsPanel.add(loginUI, "loginUI");

        movieUI movieUI = new movieUI();
        cardsPanel.add(movieUI, "movieUI");

        catalogUI catalogUI = new catalogUI();
        cardsPanel.add(catalogUI, "catalogUI");

        CardLayout cl = (CardLayout)(cardsPanel.getLayout());
        cl.show(cardsPanel, "catalogUI");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);
    }

}
