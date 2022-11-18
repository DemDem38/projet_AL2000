package UI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class signUpUI extends JPanel {

    signUpUI(){

        super(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(topPanel, BorderLayout.NORTH);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setFocusable(false);
        topPanel.add(loginButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.PAGE_AXIS));
        formPanel.setBackground(Color.GREEN);
        add(formPanel, BorderLayout.CENTER);

        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setHorizontalAlignment(JLabel.CENTER);
        formPanel.add(nomLabel);

        JTextField nomField = new JTextField();
        formPanel.add(nomField);

        JLabel prenomLabel = new JLabel("Prénom");
        nomLabel.setHorizontalAlignment(JLabel.CENTER);
        formPanel.add(prenomLabel);

        JTextField prenomField = new JTextField(30);
        formPanel.add(prenomField);

        JLabel emailLabel = new JLabel("Email");
        nomLabel.setHorizontalAlignment(JLabel.CENTER);
        formPanel.add(emailLabel);

        JTextField emailField = new JTextField(30);
        formPanel.add(emailField);

        JLabel adressLabel = new JLabel("Adresse");
        nomLabel.setHorizontalAlignment(JLabel.CENTER);
        formPanel.add(adressLabel);

        JTextField adressField = new JTextField(30);
        formPanel.add(adressField);

        JLabel pwdLabel = new JLabel("Mot de passe");
        nomLabel.setHorizontalAlignment(JLabel.CENTER);
        formPanel.add(pwdLabel);

        JTextField pwdField = new JTextField(30);
        formPanel.add(pwdField);

        JLabel pwdConfLabel = new JLabel("Confirmer mot de passe");
        nomLabel.setHorizontalAlignment(JLabel.CENTER);
        formPanel.add(pwdConfLabel);

        JTextField pwdConfField = new JTextField(30);
        formPanel.add(pwdConfField);

        centerPanel.add(formPanel, BorderLayout.CENTER);

        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(botPanel, BorderLayout.SOUTH);

        JButton backButton = new JButton("Retour");
        backButton.setFocusable(false);
        botPanel.add(backButton);

    }


    
}
