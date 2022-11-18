package UI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class loginUI extends JPanel {

    loginUI(){

        super(new BorderLayout());


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JLabel loginLabel = new JLabel("email");
        loginLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setMaximumSize(new Dimension(300,50));
        loginField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(loginField);

        JLabel passwordLabel = new JLabel("mot de passe");
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setMaximumSize(new Dimension(300,50));
        passwordField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(passwordField);

        JButton loginButton = new JButton("Connexion");
        loginButton.setFocusable(false);
        loginButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(loginButton);

        centerPanel.add(Box.createGlue());

       
        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(botPanel, BorderLayout.SOUTH);
    
        JButton backButton = new JButton("Retour");
        backButton.setFocusable(false);
        botPanel.add(backButton);
    }

}

