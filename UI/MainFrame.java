package UI;

import FC.AL2000;

import javax.swing.*;
import java.awt.Color;
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

        Color bgColor = new Color(58, 58, 58);
        Color textColor = new Color(255, 255, 255);
        Color buttonColor = new Color(128, 20, 213);

        UIManager.put("Panel.background", bgColor);

        UIManager.put("Button.background",buttonColor);
        UIManager.put("Button.foreground",textColor);

        UIManager.put("Label.foreground",textColor);

        UIManager.put("ScrollPane.background",bgColor);
        UIManager.put("ScrollPane.background",bgColor);

        UIManager.put("CheckBox.background",bgColor);
        UIManager.put("CheckBox.foreground",textColor);

        UIManager.put("OptionPane.background",bgColor);
        UIManager.put("OptionPane.messageForeground",textColor);

        UIManager.put("ScrollBar.track",buttonColor);
        UIManager.put("ScrollBar.thumb",buttonColor);

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
