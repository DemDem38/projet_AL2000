package UI;

import FC.AL2000;
import FC.PATTERNS.Observateur;
import UI.customPanel.TopPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JPanel implements Observateur {

    AL2000 model;
    CollecteurEvenements controller;
    private JButton returnButton;

    HomeUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

        super(new BorderLayout());

        model = m;
        controller = c;

        model.ajouteObservateur(this);

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame, model, controller);
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JButton catalogButton = new JButton("Voir le catalogue");
        catalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Commande c = new Commande("updateCatalogue");
                controller.commande(c);
                mainFrame.changeCard("catalogUI");
            }
        });
        catalogButton.setFocusable(false);
        catalogButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(catalogButton);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        returnButton = new JButton("Retourner un film");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("returnBluRayUI");
            }
        });
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        returnButton.setVisible(false);
        centerPanel.add(returnButton);

        centerPanel.add(Box.createGlue());

    }

    @Override
    public void metAJour() {
        if (model.isConnected()) {
            returnButton.setVisible(true);
        } else {
            returnButton.setVisible(false);
        }
    }

}
