package UI;

import FC.AL2000;
import FC.PATTERNS.Observateur;
import UI.customDialog.RentDialog;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MovieUI extends JPanel {

    AL2000 model;
    CollecteurEvenements controller;

    MovieUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

        super(new BorderLayout());

        model = m;
        controller = c;

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame, model, controller);
        add(topPanel, BorderLayout.NORTH);

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
            posterImg = ImageIO.read(getClass().getResource("/res/Images/topgun.jpg"));
            JLabel posterLabel = new JLabel(new ImageIcon(posterImg.getScaledInstance(350, 500, Image.SCALE_FAST)));
            centerPanel.add(posterLabel, BorderLayout.WEST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setBorder(new EmptyBorder(0,20,0,0));
        centerPanel.add(infoPanel, BorderLayout.CENTER);

        infoPanel.add(Box.createGlue());

        JLabel synopsisLabel = new JLabel();
        synopsisLabel.setFont(new Font(synopsisLabel.getFont().getFontName(), Font.PLAIN, synopsisLabel.getFont().getSize()));
        synopsisLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>",
                "<b>Synopsis :</b>" +
                "<br>Pete Maverick Mitchell, un jeune prodige du pilotage peu apprécié par sa hiérarchie, rejoint la très réputée école de l'aéronavale américaine, Top Gun, pour perfectionner ses techniques de combat aérien. Tous les étudiants concourent pour le titre de meilleur pilote."
        ));
        infoPanel.add(synopsisLabel);

        JLabel categoryLabel = new JLabel();
        categoryLabel.setFont(new Font(categoryLabel.getFont().getFontName(), Font.PLAIN, categoryLabel.getFont().getSize()));
        categoryLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>","<br><b>Genre : </b>Action, Aventure, Adulte"));
        infoPanel.add(categoryLabel);

        JLabel actorsLabel = new JLabel();
        actorsLabel.setFont(new Font(actorsLabel.getFont().getFontName(), Font.PLAIN, actorsLabel.getFont().getSize()));
        actorsLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>",
                "<br><b>Acteurs :</b>"+
                "<br>Tom Cruise \"Pete Mitchell\""+
                "<br>Val Kilmer \"Iceman\""+
                "<br>Kelly McGillis \"Charlie\""+
                "<br>Anthony Edwards \"Goose\""));
        infoPanel.add(actorsLabel);

        JLabel realisatorLabel = new JLabel();
        realisatorLabel.setFont(new Font(realisatorLabel.getFont().getFontName(), Font.PLAIN, realisatorLabel.getFont().getSize()));
        realisatorLabel.setText(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>","<br><b>Réalisateur : </b>Tony Scott"));
        infoPanel.add(realisatorLabel);

        BufferedImage awardsImg;
        try {
            awardsImg = ImageIO.read(getClass().getResource("/res/Images/awards.png"));
            JLabel awardsLabel = new JLabel(new ImageIcon(awardsImg.getScaledInstance(450, 230, Image.SCALE_FAST)));
            infoPanel.add(awardsLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        infoPanel.add(Box.createGlue());

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(rightPanel, BorderLayout.EAST);

        rightPanel.add(Box.createGlue());

        // TODO savoir si le film est disponible en BluRay
        JLabel availableLabel = new JLabel("Blu-Ray disponible dans cette borne : NON");
        availableLabel.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(availableLabel);

        JButton askButton = new JButton("Demander à ce que ce film soit disponible en Blu-Ray");
        askButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO demande d'ajout du film comme BluRay
                Commande c = new Commande("demandeBluRay");
                controller.commande(c);
                askButton.setText("Votre demande à bien été prise en compte");
                askButton.setEnabled(false);
            }
        });
        askButton.setFocusable(false);
        askButton.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(askButton);

        JButton rentButton = new JButton("Louer ce film");
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO savoir si le film est disponible en bluRay
                RentDialog dialog = new RentDialog(mainFrame, controller, true);
            }
        });
        rentButton.setFocusable(false);
        rentButton.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(rentButton);

        rightPanel.add(Box.createGlue());

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "movieUI");
        add(botPanel, BorderLayout.SOUTH);
    }
}
