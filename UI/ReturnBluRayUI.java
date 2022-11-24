package UI;

import FC.AL2000;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBluRayUI extends JPanel {

    AL2000 model;
    CollecteurEvenements controller;

    ReturnBluRayUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

        super(new BorderLayout());

        model = m;
        controller = c;

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame, model, controller);
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JButton defectButton = new JButton("Blu-Ray défectueux");
        defectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO recupérer les locations en cours du client
                Object[] possibilities = {"Topgun", "Harry Potter", "Star Wars"};
                String s = (String) JOptionPane.showInputDialog(
                        mainFrame,
                        "Choisissez le film défectueux : ",
                        "Rendre un film défectueux",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        null);
                if(s!=null){
                    //TODO : DVD qui s'apprète à être rendu
                    Commande c = new Commande("BluRayDefectueux");
                    controller.commande(c);
                    mainFrame.changeCard("insertBluRayUI");
                }
            }
        });
        defectButton.setFocusable(false);
        defectButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(defectButton);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton returnButton = new JButton("Rendre un Blu-Ray");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO recupérer les locations en cours du client
                Object[] possibilities = {"Topgun", "Harry Potter", "Star Wars"};
                String s = (String) JOptionPane.showInputDialog(
                        mainFrame,
                        "Choisissez le film à rendre : ",
                        "Rendre un film",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        null);
                if(s!=null){
                    //TODO : DVD qui s'apprète à être rendu infos ?
                    Commande c = new Commande("BluRayRendu");
                    controller.commande(c);
                    mainFrame.changeCard("insertBluRayUI");
                }
            }
        });
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(returnButton);

        centerPanel.add(Box.createGlue());

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "returnBluRayUI");
        add(botPanel, BorderLayout.SOUTH);

    }

}

