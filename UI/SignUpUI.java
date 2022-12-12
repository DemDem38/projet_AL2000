package UI;

import FC.AL2000;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

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

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.setPreferredSize(new Dimension(450, 450));
        add(leftPanel, BorderLayout.LINE_END);

        leftPanel.add(Box.createGlue());

        JLabel soldeLabel = new JLabel("Solde de départ");
        soldeLabel.setAlignmentX(LEFT_ALIGNMENT);
        leftPanel.add(soldeLabel);

        JTextField soldeField = new JTextField(15);
        soldeField.setMaximumSize(new Dimension(100, 500));
        soldeField.setFont(new Font("SansSerif", Font.BOLD, 20));
        soldeField.setText("15");
        soldeField.setAlignmentX(LEFT_ALIGNMENT);
        // Verification que l'utilisateur n'entre que des chiffres dans ce champ
        soldeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        leftPanel.add(soldeField);

        leftPanel.add(Box.createGlue());

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

        JLabel telephonLabel = new JLabel("Telephone");
        telephonLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(telephonLabel);

        JTextField telephonField = new JTextField(30);
        telephonField.setMaximumSize(new Dimension(300, 20));
        telephonField.setAlignmentX(CENTER_ALIGNMENT);
        // Verification que l'utilisateur n'entre que des chiffres dans ce champ
        telephonField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        centerPanel.add(telephonField);

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
                String telephone = telephonField.getText();
                if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || adresse.isEmpty() || telephone.isEmpty()) {
                    JOptionPane.showMessageDialog(centerPanel, "Tout les champs doivent être remplis", "Champ manquant",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!Arrays.equals(pwdField.getPassword(), pwdConfField.getPassword())) {
                    JOptionPane.showMessageDialog(centerPanel, "Les deux mots de passe doivent être identique",
                            "Mot de passe invalide", JOptionPane.ERROR_MESSAGE);
                } else if (Integer.parseInt(soldeField.getText()) < 15) {
                    JOptionPane.showMessageDialog(centerPanel, "Le solde minimum est de 15 euros", "Solde insuffisant !",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showConfirmDialog(centerPanel, "Suivez les instructions sur la machine pour le paiement", "Paiement", JOptionPane.OK_CANCEL_OPTION);
                    Commande c = new Commande("abonnement");
                    c.setNom(nomField.getText());
                    c.setPrenom(prenomField.getText());
                    c.setLogin(emailField.getText());
                    c.setAdresse(adressField.getText());
                    c.setTelephone(telephonField.getText());
                    c.setSolde(Integer.parseInt(soldeField.getText()));
                    c.setPassword(new String(pwdConfField.getPassword()));
                    controller.commande(c);
                    nomField.setText("");
                    prenomField.setText("");
                    emailField.setText("");
                    adressField.setText("");
                    telephonField.setText("");
                    soldeField.setText("");
                    pwdConfField.setText("");
                    pwdField.setText("");
                    JOptionPane.showMessageDialog(centerPanel,
                            "Vous avez bien était inscrit vous recevrez votre carte dans un délai de 3 jours");
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
