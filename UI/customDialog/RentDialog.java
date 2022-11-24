package UI.customDialog;

import UI.CollecteurEvenements;
import UI.Commande;
import UI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentDialog extends JDialog {

    CollecteurEvenements controller;

    public RentDialog(MainFrame mainFrame, CollecteurEvenements c, Boolean bluRayAvailable){

        super(mainFrame, "Choix du support");

        controller = c;

        JLabel label = new JLabel("Choississez un support :");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.CENTER);

        if(bluRayAvailable) {
            JButton bluRayButton = new JButton("BluRay");
            bluRayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Commande c = new Commande("louer");
                    c.setSupport("BluRay");
                    // TODO qu'est ce qu'on a besoin pour créer location
                    controller.commande(c);
                    mainFrame.changeCard("homeUI");
                    dispose();
                }
            });
            bluRayButton.setFocusable(false);
            buttonPanel.add(bluRayButton);
        }

        JButton QRButton = new JButton("QR Code");
        QRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Commande c = new Commande("louer");
                c.setSupport("QR");
                // TODO qu'est ce qu'on a besoin pour créer location
                controller.commande(c);
                mainFrame.changeCard("homeUI");
                dispose();
            }
        });
        QRButton.setFocusable(false);
        buttonPanel.add(QRButton);

        setSize(200,100);
        setVisible(true);

    }

}
