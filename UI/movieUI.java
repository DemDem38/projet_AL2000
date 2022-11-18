package UI;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

public class movieUI extends JPanel {

    movieUI(){

        super(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setFocusable(false);
        topPanel.add(loginButton, BorderLayout.EAST);

        // Center panel

        JPanel centerPanel = new JPanel(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel();
        centerPanel.add(titlePanel, BorderLayout.NORTH);
        
        JLabel titleLabel = new JLabel("Top Gun");
        titleLabel.setFont(new Font(titleLabel.getFont().getFontName(), Font.PLAIN, 25));
        titlePanel.add(titleLabel);

        BufferedImage posterImg;
        try {
            posterImg = ImageIO.read(new File("projet_AL2000/Images/topgun.jpg"));
            JLabel posterLabel = new JLabel(new ImageIcon(posterImg.getScaledInstance(250, 350, Image.SCALE_FAST))); 
            posterLabel.setSize(75, 200);
            centerPanel.add(posterLabel, BorderLayout.WEST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(infoPanel, BorderLayout.CENTER);

        JTextArea synopsisLabel = new JTextArea();
        synopsisLabel.setText("Synopsis :\nPete Maverick Mitchell, un jeune prodige du pilotage peu apprécié par sa hiérarchie, rejoint la très réputée école de l'aéronavale américaine, Top Gun, pour perfectionner ses techniques de combat aérien. Tous les étudiants concourent pour le titre de meilleur pilote.");
        synopsisLabel.setMaximumSize(new Dimension(400,200));
        synopsisLabel.setOpaque(false);
        synopsisLabel.setWrapStyleWord(true);
        synopsisLabel.setEditable(false);
        synopsisLabel.setLineWrap(true);
        
        infoPanel.add(synopsisLabel);

        JLabel categoryLabel = new JLabel("Genre : Action, Aventure, Adulte");
        infoPanel.add(categoryLabel);

        JLabel actorsLabel = new JLabel("Acteurs : Tom Cruise \"Pete Mitchell\"\n"+
        "Val Kilmer \"Iceman\"\n"+
        "Kelly McGillis \"Charlie\"\n"+
        "Anthony Edwards \"Goose\"\n"
        );
        
        infoPanel.add(actorsLabel);

        JLabel realisatorLabel = new JLabel("Réalisateur : Tony Scott");
        infoPanel.add(realisatorLabel);

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(rightPanel, BorderLayout.EAST);

        rightPanel.add(Box.createGlue());

        JLabel availableLabel = new JLabel("Blu-Ray disponible : NON");
        availableLabel.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(availableLabel);

        JButton askButton = new JButton("Demander à ce que ce film soit disponible en Blu-Ray");
        askButton.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(askButton);

        JButton rentButton = new JButton("Louer ce film");
        rentButton.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(rentButton);

        rightPanel.add(Box.createGlue());

        // Bot panel
        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(botPanel, BorderLayout.SOUTH);

        JButton backButton = new JButton("Retour");
        backButton.setFocusable(false);
        botPanel.add(backButton);
    }
}
