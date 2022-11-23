package UI;

import UI.customPanel.TopPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeUI extends JPanel {

    homeUI(mainFrame mainFrame){

        super(new BorderLayout());

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame);
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        JButton catalogButton = new JButton("Voir le catalogue");
        catalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("catalogUI");
            }
        });
        catalogButton.setFocusable(false);
        catalogButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(catalogButton);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton returnButton = new JButton("Retourner un film");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("returnBluRayUI");
            }
        });
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(returnButton);

        centerPanel.add(Box.createGlue());

    }
}
