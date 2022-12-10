package UI;

import FC.AL2000;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JPanel {

    AL2000 model;
    CollecteurEvenements controller;

    LoginUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

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
                Commande c = new Commande("connexion");
                c.setLogin(loginField.getText());
                c.setPassword(String.valueOf(passwordField.getPassword()));
                controller.commande(c);
                if (model.isConnected()) {
                    mainFrame.changeCard("homeUI");
                }
                loginField.setText("");
                passwordField.setText("");
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

