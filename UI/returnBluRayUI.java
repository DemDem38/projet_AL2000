package UI;

import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class returnBluRayUI extends JPanel {

    returnBluRayUI(){

        super(new BorderLayout());

        // Top panel
        TopPanel topPanel = new TopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Center panel
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

        // Bot panel
        BotPanel botPanel = new BotPanel();
        add(botPanel, BorderLayout.SOUTH);

    }

}

