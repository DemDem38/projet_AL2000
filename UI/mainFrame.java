package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class mainFrame extends JFrame {

    JPanel cardsPanel;

    mainFrame(){
        
        super("AL2000");

        cardsPanel = new JPanel(new CardLayout());
        add(cardsPanel);

        returnBluRayUI returnBluRayUI = new returnBluRayUI(this);
        cardsPanel.add(returnBluRayUI, "returnBluRayUI");

        homeUI homeUI = new homeUI(this);
        cardsPanel.add(homeUI, "homeUI");

        signUpUI signUI = new signUpUI(this);
        cardsPanel.add(signUI, "signUpUI");

        loginUI loginUI = new loginUI(this);
        cardsPanel.add(loginUI, "loginUI");

        movieUI movieUI = new movieUI(this);
        cardsPanel.add(movieUI, "movieUI");

        catalogUI catalogUI = new catalogUI(this);
        cardsPanel.add(catalogUI, "catalogUI");

        insertBluRayUI insertBluRayUI = new insertBluRayUI(this);
        cardsPanel.add(insertBluRayUI, "insertBluRayUI");

        changeCard("homeUI");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);
    }

    public void changeCard(String card){
        CardLayout cl = (CardLayout)(cardsPanel.getLayout());
        cl.show(cardsPanel, card);
    }
}
