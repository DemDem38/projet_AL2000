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
        model = m;
        controller = c;
    }

    @Override
    public void run() {

        cardsPanel = new JPanel(new CardLayout());
        add(cardsPanel);

        ReturnBluRayUI returnBluRayUI = new ReturnBluRayUI(this, model, controller);
        cardsPanel.add(returnBluRayUI, "returnBluRayUI");

        HomeUI homeUI = new HomeUI(this, model, controller);
        cardsPanel.add(homeUI, "homeUI");

        SignUpUI signUI = new SignUpUI(this, model, controller);
        cardsPanel.add(signUI, "signUpUI");

        LoginUI loginUI = new LoginUI(this, model, controller);
        cardsPanel.add(loginUI, "loginUI");

        MovieUI movieUI = new MovieUI(this, model, controller);
        cardsPanel.add(movieUI, "movieUI");

        CatalogUI catalogUI = new CatalogUI(this, model, controller);
        cardsPanel.add(catalogUI, "catalogUI");

        InsertBluRayUI insertBluRayUI = new InsertBluRayUI(this, controller);
        cardsPanel.add(insertBluRayUI, "insertBluRayUI");

        ManageUI manageAccountUI = new ManageUI(this, model, controller);
        cardsPanel.add(manageAccountUI, "manageUI");

        ModifInfosUI modifInfosUI = new ModifInfosUI(this, model, controller, manageAccountUI);
        cardsPanel.add(modifInfosUI, "modifInfosUI");

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
