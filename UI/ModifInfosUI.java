package UI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FC.AL2000;
import FC.POJO.Abonne;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

public class ModifInfosUI extends JPanel {

    AL2000 model;
    CollecteurEvenements controller;
    ManageUI manageUI;

    ModifInfosUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c, ManageUI a) {
        super(new BorderLayout());

        model = m;
        controller = c;
        manageUI = a;

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame, model, controller);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JLabel infosLabel = new JLabel();
        infosLabel.setText("Indiquez, dans les champs ci-dessous, vos nouvelles valeurs");
        infosLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(infosLabel);

        centerPanel.add(Box.createGlue());

        // nom, prenom, email, adresse, telephone, mdp , confirmer mdp
        JLabel nameLabel = new JLabel("Nom");
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setAlignmentX(CENTER_ALIGNMENT);
        nameTextField.setMaximumSize(new Dimension(300, 50));
        centerPanel.add(nameTextField);
        
        // Prenom
        JLabel firstnameLabel = new JLabel("Prenom");
        firstnameLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(firstnameLabel);

        JTextField firstnameTextField = new JTextField();
        firstnameTextField.setAlignmentX(CENTER_ALIGNMENT);
        firstnameTextField.setMaximumSize(new Dimension(300, 50));
        centerPanel.add(firstnameTextField);

        // email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(emailLabel);

        JTextField emailTextField = new JTextField();
        emailTextField.setAlignmentX(CENTER_ALIGNMENT);
        emailTextField.setMaximumSize(new Dimension(300, 50));
        centerPanel.add(emailTextField);

        // adresse
        JLabel adresseLabel = new JLabel("Adresse");
        adresseLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(adresseLabel);

        JTextField adresseTextField = new JTextField();
        adresseTextField.setAlignmentX(CENTER_ALIGNMENT);
        adresseTextField.setMaximumSize(new Dimension(300, 50));
        centerPanel.add(adresseTextField);

        // telephone
        JLabel telephoneLabel = new JLabel("Telephone");
        telephoneLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(telephoneLabel);

        JTextField telephoneTextField = new JTextField();
        telephoneTextField.setAlignmentX(CENTER_ALIGNMENT);
        telephoneTextField.setMaximumSize(new Dimension(300, 50));
        centerPanel.add(telephoneTextField);

        // mot de passe
        JLabel passwrdLabel = new JLabel("Mot de passe");
        passwrdLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(passwrdLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(300, 50));
        passwordField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(passwordField);

        // Confirmer mot de passe
        JLabel confirmPasswrdLabel = new JLabel("Confirmer mot de passe");
        confirmPasswrdLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(confirmPasswrdLabel);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setMaximumSize(new Dimension(300, 50));
        confirmPasswordField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(confirmPasswordField);

        centerPanel.add(Box.createGlue());

        JButton sauvegardeButton = new JButton("sauvegarder");
        sauvegardeButton.setFocusable(false);
        sauvegardeButton.setAlignmentX(CENTER_ALIGNMENT);
        sauvegardeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String firstname = firstnameTextField.getText();
                String email = emailTextField.getText();
                String adress = adresseTextField.getText();
                String telephone = telephoneTextField.getText();
                String mdp = String.valueOf(passwordField.getPassword());
                String confirmMdp = String.valueOf(confirmPasswordField.getPassword());
                if (name.equals("") || firstname.equals("") || email.equals("") || adress.equals("") ||
                    telephone.equals("") || mdp.equals("") || confirmMdp.equals("")) {
                    System.out.println("Erreur : un champ est vide");
                } else if (!mdp.equals(confirmMdp)) {
                    System.out.println("Erreur : le mot de passe est différent du mot de passe confirmé");
                } else {
                    Abonne abonne = manageUI.getAbonne();
                    Abonne abonneUpdate = new Abonne(abonne.getID(), name, firstname, email, adress, telephone, abonne.getRestrictions(),
                                                        abonne.getSolde(), mdp.hashCode());
                    model.updateAbonne(abonneUpdate);
                    mainFrame.changeCard("manageUI");
                }
                nameTextField.setText("");
                firstnameTextField.setText("");
                emailTextField.setText("");
                adresseTextField.setText("");
                telephoneTextField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });
        centerPanel.add(sauvegardeButton);

        centerPanel.add(Box.createGlue());

        BotPanel botPanel = new BotPanel(mainFrame, "modifInfosUI");
        add(botPanel, BorderLayout.SOUTH);
    }

}
