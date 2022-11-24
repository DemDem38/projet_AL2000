package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

    JPanel cardsPanel;

    MainFrame(){
        
        super("AL2000");

        cardsPanel = new JPanel(new CardLayout());
        add(cardsPanel);

        ReturnBluRayUI returnBluRayUI = new ReturnBluRayUI(this);
        cardsPanel.add(returnBluRayUI, "returnBluRayUI");

        HomeUI homeUI = new HomeUI(this);
        cardsPanel.add(homeUI, "homeUI");

        SignUpUI signUI = new SignUpUI(this);
        cardsPanel.add(signUI, "signUpUI");

        LoginUI loginUI = new LoginUI(this);
        cardsPanel.add(loginUI, "loginUI");

        MovieUI movieUI = new MovieUI(this);
        cardsPanel.add(movieUI, "movieUI");

        CatalogUI catalogUI = new CatalogUI(this);
        cardsPanel.add(catalogUI, "catalogUI");

        InsertBluRayUI insertBluRayUI = new InsertBluRayUI(this);
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
