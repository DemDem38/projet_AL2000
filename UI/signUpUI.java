package UI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.LabelView;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class signUpUI extends JPanel {

    signUpUI(){

        super(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setFocusable(false);
        topPanel.add(loginButton, BorderLayout.EAST);

        JPanel centerPanel = new JPanel();        
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(nomLabel);

        JTextField nomField = new JTextField();
        nomField.setMaximumSize(new Dimension(300,20));
        nomField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(nomField);

        JLabel prenomLabel = new JLabel("Prénom");
        prenomLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(prenomLabel);

        JTextField prenomField = new JTextField(30);
        prenomField.setMaximumSize(new Dimension(300,20));
        prenomField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(prenomField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(emailLabel);

        JTextField emailField = new JTextField(30);
        emailField.setMaximumSize(new Dimension(300,20));
        emailField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(emailField);

        JLabel adressLabel = new JLabel("Adresse");
        adressLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(adressLabel);

        JTextField adressField = new JTextField(30);
        adressField.setMaximumSize(new Dimension(300,20));
        adressField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(adressField);

        JLabel pwdLabel = new JLabel("Mot de passe");
        pwdLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdLabel);

        JTextField pwdField = new JTextField(30);
        pwdField.setMaximumSize(new Dimension(300,20));
        pwdField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdField);

        JLabel pwdConfLabel = new JLabel("Confirmer mot de passe");
        pwdConfLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdConfLabel);

        JTextField pwdConfField = new JTextField(30);
        pwdConfField.setMaximumSize(new Dimension(300,20));
        pwdConfField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(pwdConfField);

        centerPanel.add(Box.createGlue());

        JCheckBox conditionCheck = new JCheckBox("Vous confirmez avoir lu et acceptez les conditions générales d'utilisation du service.");
        conditionCheck.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(conditionCheck);

        centerPanel.add(Box.createGlue());

        JButton inscritButton = new JButton("S'abonner");
        inscritButton.setFocusable(false);
        inscritButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(inscritButton);

        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(botPanel, BorderLayout.SOUTH);

        JButton backButton = new JButton("Retour");
        backButton.setFocusable(false);
        botPanel.add(backButton);

    }


    
}
