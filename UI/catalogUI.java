package UI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.FlowLayout;
import javax.imageio.ImageIO;
import java.awt.*;

public class catalogUI extends JPanel {

    catalogUI(){
        super(new BorderLayout());

        // Top panel

        JPanel topPanel = new JPanel(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);

        JPanel toprightPanel = new JPanel();
        toprightPanel.setLayout(new BoxLayout(toprightPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(toprightPanel, BorderLayout.EAST);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setFocusable(false);
        toprightPanel.add(loginButton);

        JButton logoutButton = new JButton("Se déconnecter");
        logoutButton.setFocusable(false);
        toprightPanel.add(logoutButton);

        JLabel soldeLabel = new JLabel("Solde : 15€");
        soldeLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(soldeLabel, BorderLayout.CENTER);

        loginButton.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                topPanel.add(Box.createRigidArea(new Dimension(loginButton.getWidth(), 0)),BorderLayout.WEST);  
            }
        });

        // Center panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        JPanel moviePanel = new JPanel(new GridLayout(0, 6));
        GridLayout gl = (GridLayout) moviePanel.getLayout();
        gl.setVgap(30);

        JScrollPane movieScrollPanel = new JScrollPane(moviePanel);
        centerPanel.add(movieScrollPanel, BorderLayout.CENTER);

        for (int i=0; i<25; i++){
            BufferedImage img1;
            try {
                img1 = ImageIO.read(getClass().getResource("/res/Images/topgun.jpg"));
                JLabel label1 = new JLabel(new ImageIcon(img1.getScaledInstance(175, 250, Image.SCALE_FAST)));
                moviePanel.add(label1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.PAGE_AXIS));

        JScrollPane categoryScrollPanel = new JScrollPane(categoryPanel);
        centerPanel.add(categoryScrollPanel, BorderLayout.WEST);


        for (int i=0; i<25; i++){
            JCheckBox cb1 = new JCheckBox("Action");
            categoryPanel.add(cb1);
        }

        // Bot panel

        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(botPanel, BorderLayout.SOUTH);

        JButton backButton = new JButton("Retour");
        backButton.setFocusable(false);
        botPanel.add(backButton);
        
    }
}
