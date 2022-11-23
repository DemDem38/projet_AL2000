package UI;

import UI.customPanel.BotPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertBluRayUI extends JPanel {

    insertBluRayUI(mainFrame mainFrame){
        super(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JLabel insertLabel = new JLabel("Inserez le Blu-Ray dans la borne");
        insertLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(insertLabel);

        JButton insertButton = new JButton("Simulation d'insertion du DVD");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: le DVD est rendu
                mainFrame.changeCard("homeUI");
            }
        });
        insertButton.setFocusable(false);
        insertButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(insertButton);

        centerPanel.add(Box.createGlue());

        BotPanel botPanel = new BotPanel(mainFrame, "insertBluRayUI");
        add(botPanel, BorderLayout.SOUTH);
    }
}
