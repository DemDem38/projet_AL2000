package UI;

import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JPanel {

    LoginUI(MainFrame mainFrame){

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

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(300,50));
        passwordField.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(passwordField);

        JButton loginButton = new JButton("Connexion");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO connexion
            }
        });
        loginButton.setFocusable(false);
        loginButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(loginButton);

        centerPanel.add(Box.createGlue());

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "loginUI");
        add(botPanel, BorderLayout.SOUTH);

    }

}

