package UI;

import UI.customPanel.TopPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class homeUI extends JPanel {

    homeUI(){

        super(new BorderLayout());

        // Top panel
        TopPanel topPanel = new TopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JButton catalogButton = new JButton("Voir le catalogue");
        catalogButton.setFocusable(false);
        catalogButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(catalogButton);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton returnButton = new JButton("Retourner un film");
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(returnButton);

        centerPanel.add(Box.createGlue());

    }
}
