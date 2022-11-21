package UI.customPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TopPanel extends JPanel {

    JButton loginButton;
    JButton manageButton;
    JLabel soldeLabel;

    public TopPanel(){

        super(new BorderLayout());

        JPanel toprightPanel = new JPanel(new GridLayout(2,1));
        add(toprightPanel, BorderLayout.EAST);

        loginButton = new JButton("Se déconnecter");
        loginButton.setFocusable(false);
        toprightPanel.add(loginButton);

        manageButton = new JButton("Gérer compte");
        manageButton.setFocusable(false);
        toprightPanel.add(manageButton);

        soldeLabel = new JLabel("Solde : 15€");
        soldeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(soldeLabel, BorderLayout.CENTER);

        loginButton.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                add(Box.createRigidArea(new Dimension(loginButton.getWidth(), 0)),BorderLayout.WEST);
            }
        });
    }
}
