package UI.customPanel;

import javax.swing.*;
import java.awt.*;

public class BotPanel extends JPanel {

    JButton backButton;

    public BotPanel(){

        super(new FlowLayout(FlowLayout.RIGHT));

        backButton = new JButton("Retour");
        backButton.setFocusable(false);
        add(backButton);

    }
}
