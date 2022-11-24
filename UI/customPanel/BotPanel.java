package UI.customPanel;

import UI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotPanel extends JPanel {

    JButton backButton;
    String currentPage;

    public BotPanel(MainFrame mainFrame, String currentPage){

        super(new FlowLayout(FlowLayout.RIGHT));

        this.currentPage = currentPage;

        backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (currentPage){
                    case "movieUI":
                        mainFrame.changeCard("catalogUI");
                        break;
                    case "insertBluRayUI":
                        mainFrame.changeCard("returnBluRayUI");
                        break;
                    case "signUpUI":
                    case "returnBluRayUI":
                    case "loginUI":
                    case "catalogUI":
                    default:
                        mainFrame.changeCard("homeUI");

                }
            }
        });
        backButton.setFocusable(false);
        add(backButton);

    }
}
