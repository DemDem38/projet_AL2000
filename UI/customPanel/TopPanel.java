package UI.customPanel;

import FC.PATTERNS.Observateur;
import UI.mainFrame;

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

    public TopPanel(mainFrame mainFrame){

        super(new BorderLayout());

        JPanel toprightPanel = new JPanel(new GridLayout(2,1));
        add(toprightPanel, BorderLayout.EAST);

        loginButton = new JButton("Se déconnecter");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO vérifier si connecté
                if (false){
                    // TODO déconnecter
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
                // TODO vérifier si connecté
                if (false){
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
        // TODO récupérer solde
        soldeLabel.setText("15€");
        // TODO vérifier si connecté
        if(false){
            loginButton.setText("Se déconnecter");
            manageButton.setText("Gérer mon compte");
        }else{
            loginButton.setText("Se connecter");
            manageButton.setText("M'inscrire");
        }
    }
}
