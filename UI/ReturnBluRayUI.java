package UI;

import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBluRayUI extends JPanel {

    ReturnBluRayUI(MainFrame mainFrame){

        super(new BorderLayout());

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame);
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
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibilities = {"Topgun", "Harry Potter", "Star Wars"};
                String s = (String) JOptionPane.showInputDialog(
                        mainFrame,
                        "Choisissez le film à rendre : ",
                        "Rendre un film",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        "Topgun");
                if(s!=null){
                    //TODO : DVD qui s'apprète à être rendu
                    mainFrame.changeCard("insertBluRayUI");
                }
            }
        });
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(returnButton);

        centerPanel.add(Box.createGlue());

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "returnBluRayUI");
        add(botPanel, BorderLayout.SOUTH);

    }

}

