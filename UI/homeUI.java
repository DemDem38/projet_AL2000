package UI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class homeUI extends JPanel {

    homeUI(){

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

        JButton defectButton = new JButton("Voir le catalogue");
        defectButton.setFocusable(false);
        defectButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(defectButton);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton returnButton = new JButton("Retourner un film");
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(returnButton);

        centerPanel.add(Box.createGlue());

    }
}
