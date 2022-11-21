package UI;


import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class catalogUI extends JPanel {

    catalogUI(){

        super(new BorderLayout());

        // Top panel
        TopPanel topPanel = new TopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        // Search panel
        JPanel searchPanel = new JPanel();
        centerPanel.add(searchPanel, BorderLayout.NORTH);

        JLabel searchLabel = new JLabel("Rechercher : ");
        searchPanel.add(searchLabel);

        JTextField searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(300,20));
        searchBar.setAlignmentX(CENTER_ALIGNMENT);
        searchPanel.add(searchBar);

        JButton searchButton = new JButton("Rechercher");
        searchButton.setFocusable(false);
        searchPanel.add(searchButton);

        // Movie panel
        JPanel moviePanel = new JPanel(new GridLayout(0, 5));
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

        // Category panel
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.PAGE_AXIS));

        JScrollPane categoryScrollPanel = new JScrollPane(categoryPanel);
        categoryScrollPanel.setBorder(new EmptyBorder(0,25,0,35));
        categoryScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerPanel.add(categoryScrollPanel, BorderLayout.WEST);

        for (int i=0; i<25; i++){
            JCheckBox cb1 = new JCheckBox("Action");
            cb1.setMargin(new Insets(0,0,0,35));
            categoryPanel.add(cb1);
        }

        // Bot panel
        BotPanel botPanel = new BotPanel();
        add(botPanel, BorderLayout.SOUTH);
        
    }
}
