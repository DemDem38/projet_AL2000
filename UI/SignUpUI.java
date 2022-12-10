package UI;

import FC.AL2000;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class SignUpUI extends JPanel {

    AL2000 model;
    CollecteurEvenements controller;
    Desktop desktop;    
    SignUpUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c) {

        super(new BorderLayout());

        model = m;
        controller = c;

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame, model, controller);
        add(topPanel, BorderLayout.NORTH);

        // Center left panel
        JPanel centerPanelLeft = new JPanel();
        centerPanelLeft.setLayout(new BoxLayout(centerPanelLeft, BoxLayout.PAGE_AXIS));
        add(centerPanelLeft, BorderLayout.EAST);

        centerPanelLeft.add(Box.createGlue());

        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(nomLabel);

        JTextField nomField = new JTextField();
        nomField.setMaximumSize(new Dimension(300, 20));
        nomField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(nomField);

        JLabel prenomLabel = new JLabel("Prénom");
        prenomLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(prenomLabel);

        JTextField prenomField = new JTextField(30);
        prenomField.setMaximumSize(new Dimension(300, 20));
        prenomField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(prenomField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(emailLabel);

        JTextField emailField = new JTextField(30);
        emailField.setMaximumSize(new Dimension(300, 20));
        emailField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(emailField);

        JLabel adressLabel = new JLabel("Adresse");
        adressLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(adressLabel);

        JTextField adressField = new JTextField(30);
        adressField.setMaximumSize(new Dimension(300, 20));
        adressField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(adressField);

        JLabel pwdLabel = new JLabel("Mot de passe");
        pwdLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(pwdLabel);

        JPasswordField pwdField = new JPasswordField(30);
        pwdField.setMaximumSize(new Dimension(300, 20));
        pwdField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(pwdField);

        JLabel pwdConfLabel = new JLabel("Confirmer mot de passe");
        pwdConfLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(pwdConfLabel);

        JPasswordField pwdConfField = new JPasswordField(30);
        pwdConfField.setMaximumSize(new Dimension(300, 20));
        pwdConfField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(pwdConfField);

        JPanel centerPanelRight = new JPanel();
        centerPanelRight.setLayout(new BoxLayout(centerPanelRight, BoxLayout.PAGE_AXIS));
        add(centerPanelRight, BorderLayout.CENTER);

        centerPanelRight.add(Box.createGlue());

        JLabel lienCondition = new JLabel("<html><a href=\"#\">Conditions Générale d'Utilisation</a></html>");
        lienCondition.setForeground(Color.BLUE.darker());
        lienCondition.setAlignmentX(CENTER_ALIGNMENT);
        lienCondition.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                try
                {
                    desktop.browse(new URI("https://waytolearnx.com/"));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        centerPanelRight.add(lienCondition);

        JCheckBox conditionCheck = new JCheckBox(
                "Vous confirmez avoir lu et acceptez les conditions générales d'utilisation du service.");
        conditionCheck.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelRight.add(conditionCheck);

        centerPanelRight.add(Box.createGlue());

        JButton inscritButton = new JButton("S'abonner");
        inscritButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Commande c = new Commande("abonnement");
                c.setNom(nomField.getText());
                c.setPrenom(prenomField.getText());
                c.setLogin(emailField.getText());
                c.setAdresse(adressField.getText());
                c.setPassword(new String(pwdConfField.getPassword()));
                controller.commande(c);
                mainFrame.changeCard("homeUI");
            }
        });
        inscritButton.setFocusable(false);
        inscritButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanelLeft.add(inscritButton);

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "signUpUI");
        add(botPanel, BorderLayout.SOUTH);

    }

}
