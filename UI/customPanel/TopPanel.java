package UI.customPanel;

import FC.AL2000;
import FC.PATTERNS.Observateur;
import UI.CollecteurEvenements;
import UI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TopPanel extends JPanel implements Observateur {

    JButton loginButton;
    JButton manageButton;
    JLabel soldeLabel;
    AL2000 model;
    CollecteurEvenements controller;

    public TopPanel(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

        super(new BorderLayout());

        model = m;
        model.ajouteObservateur(this);
        controller = c;

        JPanel toprightPanel = new JPanel(new GridLayout(2,1));
        add(toprightPanel, BorderLayout.EAST);

        loginButton = new JButton("Se déconnecter");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.isConnected()){
                    model.deconnexion();
                    mainFrame.changeCard("homeUI");
                }else{
                    mainFrame.changeCard("loginUI");
                }
            }
        });
        loginButton.setFocusable(false);
        toprightPanel.add(loginButton);

        manageButton = new JButton("Gérer mon compte");
        manageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.isConnected()){
                    mainFrame.changeCard("manageUI");
                }else{
                    mainFrame.changeCard("signUpUI");
                }
            }
        });
        manageButton.setFocusable(false);
        toprightPanel.add(manageButton);

        soldeLabel = new JLabel("Solde : 15€");
        soldeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(soldeLabel, BorderLayout.CENTER);

        loginButton.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                add(Box.createRigidArea(new Dimension(loginButton.getWidth(), 0)),BorderLayout.WEST);
            }
        });

        metAJour();
    }

    @Override
    public void metAJour() {
        if(model.isConnected()){
            // TODO récupérer solde
            soldeLabel.setText("15€");
            loginButton.setText("Se déconnecter");
            manageButton.setText("Gérer mon compte");
        }else{
            soldeLabel.setVisible(false);
            loginButton.setText("Se connecter");
            manageButton.setText("M'inscrire");
        }
    }
}
