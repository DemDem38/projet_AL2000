package UI;

import FC.AL2000;
import FC.PATTERNS.Observateur;
import FC.POJO.Abonne;
import FC.POJO.Film;
import FC.POJO.Location;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReturnBluRayUI extends JPanel implements Observateur {

    AL2000 model;
    CollecteurEvenements controller;
    private Abonne abonne;

    ReturnBluRayUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

        super(new BorderLayout());

        model = m;
        model.ajouteObservateur(this);
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
                Object[] possibilities =  possibilities() ;
                String s = (String) JOptionPane.showInputDialog(
                        mainFrame,
                        "Choisissez le film défectueux : ",
                        "Rendre un film défectueux",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        null);
                if(s!=null){
                    String [] resultat = s.split(" loué le ");
                    Location l = model.getLocation(resultat[0], resultat[1]);
                    Commande c = new Commande("BluRayDefectueux");
                    JOptionPane.showConfirmDialog(centerPanel, "Suivez les instructions sur la machine pour le paiment de la location, Vous serez rendourser une fois le Blu-Ray verifier", "Paiment", JOptionPane.OK_CANCEL_OPTION);
                    c.setLocation(l);
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
                Object possibilities[] = possibilities();
                if (possibilities() != null) {
                    String s = (String) JOptionPane.showInputDialog(
                        mainFrame,
                        "Choisissez le film à rendre : ",
                        "Rendre un film",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        null);
                    if(s!=null){
                        String [] resultat = s.split(" loué le ");
                        Location l = model.getLocation(resultat[0], resultat[1]);
                        Commande c = new Commande("BluRayRendu");
                        c.setLocation(l);
                        JOptionPane.showConfirmDialog(centerPanel, "Suivez les instructions sur la machine pour le paiment de la location", "Paiment", JOptionPane.OK_CANCEL_OPTION);
                        controller.commande(c);
                        mainFrame.changeCard("insertBluRayUI");
                    }
                } else {
                    System.out.println("Connectez-vous pour rendre un Blu-Ray");
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

    private Object [] possibilities() {
        ArrayList<Object> possibilities = new ArrayList<>();
        if(model.isConnected()) {  // Si abonné connecté, on affiche tous les films
            for (int i = 0; i < model.getEtatFilmsLocate().size(); i++) {
                String ligne = new String();
                if (model.getEtatFilmsLocate().get(i) == "EN COURS" && model.getTypeSupportFilmsLocate().get(i) == "BluRay") {
                    ligne = model.getNameFilmsLocate().get(i).getNom();
                    ligne += " loué le ";
                    ligne += model.getDateFilmsLocate().get(i);
                    possibilities.add(ligne);
                }
            }
            return possibilities.toArray(new Object[0]);
        } else {
            return null;
        }
    }

    @Override
    public void metAJour() {
        switch (model.getLastUpdate()) {
            case "connexion":
                abonne = model.getAbonneConnecte();
                break;
            case "déconnexion":
                abonne = model.getAbonneConnecte();
                break;
            case "updateAbonne":
                abonne = model.getAbonneConnecte();
                break;
            default:
                break;
        }
    }

}

