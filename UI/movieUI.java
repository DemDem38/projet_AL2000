package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class movieUI extends JPanel {

    Color bgColor;
    Color buttonColor;
    Color textColor;

    movieUI(){

        super(new BorderLayout());

        bgColor = new Color(35, 33, 33);
        buttonColor = new Color(101, 53, 204);
        textColor = new Color(255, 255, 255);

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(bgColor);
        add(topPanel, BorderLayout.NORTH);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(textColor);
        loginButton.setFocusable(false);
        topPanel.add(loginButton, BorderLayout.EAST);

        // Center panel

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(bgColor);
        add(centerPanel, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(bgColor);
        centerPanel.add(titlePanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Top Gun");
        titleLabel.setForeground(textColor);
        titleLabel.setFont(new Font(titleLabel.getFont().getFontName(), Font.PLAIN, 25));
        titlePanel.add(titleLabel);

        BufferedImage posterImg;
        try {
            posterImg = ImageIO.read(ClassLoader.getSystemClassLoader().getResource("Images/topgun.jpg"));
            JLabel posterLabel = new JLabel(new ImageIcon(posterImg.getScaledInstance(350, 500, Image.SCALE_FAST)));
            centerPanel.add(posterLabel, BorderLayout.WEST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(35, 33, 33));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setBorder(new EmptyBorder(0,20,0,0));
        centerPanel.add(infoPanel, BorderLayout.CENTER);

        infoPanel.add(Box.createGlue());

        JLabel synopsisLabel = new JLabel();
        synopsisLabel.setForeground(textColor);
        synopsisLabel.setFont(new Font(synopsisLabel.getFont().getFontName(), Font.PLAIN, synopsisLabel.getFont().getSize()));
        synopsisLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>",
                "<b>Synopsis :</b>" +
                "<br>Pete Maverick Mitchell, un jeune prodige du pilotage peu apprécié par sa hiérarchie, rejoint la très réputée école de l'aéronavale américaine, Top Gun, pour perfectionner ses techniques de combat aérien. Tous les étudiants concourent pour le titre de meilleur pilote."
        ));
        infoPanel.add(synopsisLabel);

        JLabel categoryLabel = new JLabel();
        categoryLabel.setForeground(textColor);
        categoryLabel.setFont(new Font(categoryLabel.getFont().getFontName(), Font.PLAIN, categoryLabel.getFont().getSize()));
        categoryLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>","<br><b>Genre : </b>Action, Aventure, Adulte"));
        infoPanel.add(categoryLabel);

        JLabel actorsLabel = new JLabel();
        actorsLabel.setForeground(textColor);
        actorsLabel.setFont(new Font(actorsLabel.getFont().getFontName(), Font.PLAIN, actorsLabel.getFont().getSize()));
        actorsLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>",
                "<br><b>Acteurs :</b>"+
                "<br>Tom Cruise \"Pete Mitchell\""+
                "<br>Val Kilmer \"Iceman\""+
                "<br>Kelly McGillis \"Charlie\""+
                "<br>Anthony Edwards \"Goose\""));
        infoPanel.add(actorsLabel);

        JLabel realisatorLabel = new JLabel();
        realisatorLabel.setForeground(textColor);
        realisatorLabel.setFont(new Font(realisatorLabel.getFont().getFontName(), Font.PLAIN, realisatorLabel.getFont().getSize()));
        realisatorLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>","<br><b>Réalisateur : </b>Tony Scott"));
        infoPanel.add(realisatorLabel);

        BufferedImage awardsImg;
        try {
            awardsImg = ImageIO.read(ClassLoader.getSystemClassLoader().getResource("Images/awards.png"));
            JLabel awardsLabel = new JLabel(new ImageIcon(awardsImg.getScaledInstance(480, 250, Image.SCALE_FAST)));
            infoPanel.add(awardsLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        infoPanel.add(Box.createGlue());

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(bgColor);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(rightPanel, BorderLayout.EAST);

        rightPanel.add(Box.createGlue());

        JLabel availableLabel = new JLabel("Blu-Ray disponible dans cette borne : NON");
        availableLabel.setForeground(textColor);
        availableLabel.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(availableLabel);

        JButton askButton = new JButton("Demander à ce que ce film soit disponible en Blu-Ray");
        askButton.setBackground(buttonColor);
        askButton.setForeground(textColor);
        askButton.setFocusable(false);
        askButton.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(askButton);

        JButton rentButton = new JButton("Louer ce film");
        rentButton.setBackground(buttonColor);
        rentButton.setForeground(textColor);
        rentButton.setFocusable(false);
        rentButton.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(rentButton);

        rightPanel.add(Box.createGlue());

        // Bot panel
        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botPanel.setBackground(bgColor);
        add(botPanel, BorderLayout.SOUTH);

        JButton backButton = new JButton("Retour");
        backButton.setForeground(textColor);
        backButton.setBackground(buttonColor);
        backButton.setFocusable(false);
        botPanel.add(backButton);
    }
}
