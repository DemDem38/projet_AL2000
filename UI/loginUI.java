package UI;

import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class loginUI extends JPanel {

    loginUI(mainFrame mainFrame){

        super(new BorderLayout());

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel
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

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "loginUI");
        add(botPanel, BorderLayout.SOUTH);

    }

}

