package UI;

import FC.AL2000;

import javax.swing.*;
import java.awt.CardLayout;

public class MainFrame extends JFrame implements Runnable {

    JPanel cardsPanel;
    AL2000 model;
    CollecteurEvenements controller;

    MainFrame(AL2000 m, CollecteurEvenements c) {
        super("AL2000");
        model = model;
        controller = c;
    }

    @Override
    public void run() {

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

    public static void demarrer(AL2000 model, CollecteurEvenements c) {
        SwingUtilities.invokeLater(new MainFrame(model, c));
    }

}
