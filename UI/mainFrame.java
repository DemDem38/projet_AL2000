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

        CardLayout cl = (CardLayout)(cardsPanel.getLayout());
        cl.show(cardsPanel, "homeUI");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setVisible(true);
    }

}
