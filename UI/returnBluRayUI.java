package UI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class returnBluRayUI extends JPanel {

    returnBluRayUI(){

        super(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setFocusable(false);
        topPanel.add(loginButton, BorderLayout.EAST);

        JLabel soldeLabel = new JLabel("Solde : 15€");
        soldeLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(soldeLabel, BorderLayout.CENTER);

        loginButton.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                topPanel.add(Box.createRigidArea(new Dimension(loginButton.getWidth(), 0)),BorderLayout.WEST);  
            }
        });

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JButton defectButton = new JButton("Blu-Ray défectueux");
        defectButton.setFocusable(false);
        defectButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(defectButton);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton returnButton = new JButton("Rendre un Blu-Ray");
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(returnButton);

        centerPanel.add(Box.createGlue());

        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(botPanel, BorderLayout.SOUTH);

        JButton backButton = new JButton("Retour");
        backButton.setFocusable(false);
        botPanel.add(backButton);

    }

}

