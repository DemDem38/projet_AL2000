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
import java.io.Console;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

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

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(nomLabel);

        JTextField nomField = new JTextField();
        nomField.setMaximumSize(new Dimension(300, 20));
        nomField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(nomField);

        JLabel prenomLabel = new JLabel("Prénom");
        prenomLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(prenomLabel);

        JTextField prenomField = new JTextField(30);
        prenomField.setMaximumSize(new Dimension(300, 20));
        prenomField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(prenomField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(emailLabel);

        JTextField emailField = new JTextField(30);
        emailField.setMaximumSize(new Dimension(300, 20));
        emailField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(emailField);

        JLabel adressLabel = new JLabel("Adresse");
        adressLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(adressLabel);

        JTextField adressField = new JTextField(30);
        adressField.setMaximumSize(new Dimension(300, 20));
        adressField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(adressField);

        JLabel pwdLabel = new JLabel("Mot de passe");
        pwdLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdLabel);

        JPasswordField pwdField = new JPasswordField(30);
        pwdField.setMaximumSize(new Dimension(300, 20));
        pwdField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdField);

        JLabel pwdConfLabel = new JLabel("Confirmer mot de passe");
        pwdConfLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdConfLabel);

        JPasswordField pwdConfField = new JPasswordField(30);
        pwdConfField.setMaximumSize(new Dimension(300, 20));
        pwdConfField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdConfField);

        JButton inscritButton = new JButton("S'abonner");
        inscritButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String email = emailField.getText();
                String adresse = adressField.getText();
                System.out.println(nom);
                System.out.println(prenom);
                System.out.println(email);
                System.out.println(adresse);
                if ( nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || adresse.isEmpty() ) {
                    JOptionPane.showMessageDialog(centerPanel, "Tout les champs doivent être remplis");
                }else if ( !Arrays.equals(pwdField.getPassword(), pwdConfField.getPassword()) ) {
                    JOptionPane.showMessageDialog(centerPanel, "Les deux mots de passe doivent être identique");
                } else {
                    Commande c = new Commande("abonnement");
                    c.setNom(nomField.getText());
                    c.setPrenom(prenomField.getText());
                    c.setLogin(emailField.getText());
                    c.setAdresse(adressField.getText());
                    c.setPassword(new String(pwdConfField.getPassword()));
                    controller.commande(c);
                    mainFrame.changeCard("homeUI");
                }
            }
        });
        inscritButton.setFocusable(false);
        inscritButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(inscritButton);

        centerPanel.add(Box.createGlue());

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "signUpUI");
        add(botPanel, BorderLayout.SOUTH);

    }

}
