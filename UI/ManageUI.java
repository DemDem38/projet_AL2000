package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import FC.AL2000;
import FC.PATTERNS.Observateur;
import FC.POJO.Abonne;
import FC.POJO.Film;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

public class ManageUI extends JPanel implements Observateur {

    AL2000 model;
    CollecteurEvenements controller;
    private JTextField nomAccoutTextField, prenomAccoutTextField, mailAccoutTextField,
    adresseAccoutTextField, telephoneAccounTextField, mdpAccoutTextField;
    private JLabel soldeLabel;
    private JPanel filmsPanel;
    private JScrollPane filmsScrollPane;
    private Abonne abonne;
    private ArrayList<Film> filmsLocate;
    private ArrayList<String> etatFilmsLocate;

    ManageUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c) {
        super(new BorderLayout());
        JPanel ourPanel = this;

        model = m;
        controller = c;
        model.ajouteObservateur(this);

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame, model, controller);
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(Box.createGlue());

        soldeLabel = new JLabel("Solde compte : ");
        soldeLabel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(soldeLabel);

        JButton creditButton = new JButton("Créditer carte");
        creditButton.setFocusable(false);
        creditButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(creditButton);
        creditButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String retour = JOptionPane.showInputDialog(
                    ourPanel,
                    "Indiquez le montant",
                    "",
                    JOptionPane.PLAIN_MESSAGE
                );
                if (retour != null) {
                    try {
                        int somme = Integer.parseInt(retour);
                        if (somme < 0) {
                            JOptionPane.showMessageDialog(
                                ourPanel,
                                "Vous ne pouvez pas retirer d'argent",
                                "Transaction échouée",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            abonne.setSolde(abonne.getSolde() + somme);
                            model.updateAbonne(abonne);
                        }
                    } catch (NumberFormatException ne) {
                        JOptionPane.showMessageDialog(
                            ourPanel,
                            "La transaction n'a pas pu se faire",
                            "Transaction échouée",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        centerPanel.add(Box.createGlue());

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        add(leftPanel, BorderLayout.WEST);

        leftPanel.add(Box.createGlue());

        JButton modifInfoButton = new JButton("Modifier infos");
        modifInfoButton.setFocusable(false);
        modifInfoButton.setAlignmentX(CENTER_ALIGNMENT);
        modifInfoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("modifInfosUI");
            }

        });
        leftPanel.add(modifInfoButton);


        JPanel infosPanel = new JPanel();
        GridLayout infoLayout = new GridLayout(6, 2);
        infosPanel.setLayout(infoLayout);

        leftPanel.add(Box.createGlue());

        JLabel nomLabel = new JLabel("Nom :");
        nomLabel.setAlignmentX(LEFT_ALIGNMENT);
        infosPanel.add(nomLabel);

        nomAccoutTextField = new JTextField();
        nomAccoutTextField.setEditable(false);
        nomAccoutTextField.setBorder(BorderFactory.createEmptyBorder());
        nomAccoutTextField.setAlignmentX(RIGHT_ALIGNMENT);
        infosPanel.add(nomAccoutTextField);

        JLabel prenomLabel = new JLabel("Prénom :");
        prenomLabel.setAlignmentX(LEFT_ALIGNMENT);
        infosPanel.add(prenomLabel);

        prenomAccoutTextField = new JTextField();
        prenomAccoutTextField.setEditable(false);
        prenomAccoutTextField.setBorder(BorderFactory.createEmptyBorder());
        prenomAccoutTextField.setAlignmentX(RIGHT_ALIGNMENT);
        infosPanel.add(prenomAccoutTextField);

        JLabel mailLabel = new JLabel("Mail :");
        mailLabel.setAlignmentX(LEFT_ALIGNMENT);
        infosPanel.add(mailLabel);

        mailAccoutTextField = new JTextField();
        mailAccoutTextField.setEditable(false);
        mailAccoutTextField.setBorder(BorderFactory.createEmptyBorder());
        mailAccoutTextField.setAlignmentX(RIGHT_ALIGNMENT);
        infosPanel.add(mailAccoutTextField);

        JLabel adresseLabel = new JLabel("Adresse :");
        adresseLabel.setAlignmentX(LEFT_ALIGNMENT);
        infosPanel.add(adresseLabel);

        adresseAccoutTextField = new JTextField();
        adresseAccoutTextField.setEditable(false);
        adresseAccoutTextField.setBorder(BorderFactory.createEmptyBorder());
        adresseAccoutTextField.setAlignmentX(RIGHT_ALIGNMENT);
        infosPanel.add(adresseAccoutTextField);

        JLabel telephoneLabel = new JLabel("Telephone :");
        telephoneLabel.setAlignmentX(LEFT_ALIGNMENT);
        infosPanel.add(telephoneLabel);

        telephoneAccounTextField = new JTextField();
        telephoneAccounTextField.setEditable(false);
        telephoneAccounTextField.setBorder(BorderFactory.createEmptyBorder());
        telephoneAccounTextField.setAlignmentX(RIGHT_ALIGNMENT);
        infosPanel.add(telephoneAccounTextField);

        JLabel mdpLabel = new JLabel("Mot de passe :");
        mdpLabel.setAlignmentX(LEFT_ALIGNMENT);
        infosPanel.add(mdpLabel);

        mdpAccoutTextField = new JTextField();
        mdpAccoutTextField.setEditable(false);
        mdpAccoutTextField.setBorder(BorderFactory.createEmptyBorder());
        mdpAccoutTextField.setAlignmentX(RIGHT_ALIGNMENT);
        infosPanel.add(mdpAccoutTextField);

        leftPanel.add(infosPanel);
        leftPanel.add(Box.createGlue());

        JLabel filmsLabel = new JLabel("Les films loués");
        filmsLabel.setAlignmentX(CENTER_ALIGNMENT);
        leftPanel.add(filmsLabel);

        // Adding a list of film
        filmsPanel = new JPanel();
        filmsPanel.setLayout(new BoxLayout(filmsPanel, BoxLayout.PAGE_AXIS));

        filmsScrollPane = new JScrollPane(filmsPanel);
        filmsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        leftPanel.add(filmsScrollPane);
        leftPanel.add(Box.createGlue());

        JButton closeAccButton = new JButton("Fermer compte");
        closeAccButton.setFocusable(false);
        closeAccButton.setAlignmentX(CENTER_ALIGNMENT);
        closeAccButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int retour = JOptionPane.showConfirmDialog(
                   ourPanel,
                    "Êtes-vous sûr de vouloir supprimer votre compte ?",
                    "Suppression du compte",
                    JOptionPane.OK_CANCEL_OPTION);

                if (retour == 0) {
                    model.deleteAbonne(abonne);
                    mainFrame.changeCard("homeUI");
                }
            }

        });
        leftPanel.add(closeAccButton);
        leftPanel.add(Box.createGlue());

        BotPanel botPanel = new BotPanel(mainFrame, "manageAccountUI");
        add(botPanel, BorderLayout.SOUTH);

    }

    private void miseAJourUI(Abonne abonne) {
        if (!model.isConnected()) {
            nomAccoutTextField.setText("");
            prenomAccoutTextField.setText("");
            mailAccoutTextField.setText("");
            adresseAccoutTextField.setText("");
            telephoneAccounTextField.setText("");
            soldeLabel.setText("Solde :");
            filmsPanel.removeAll();
            filmsPanel.revalidate();
            filmsPanel.repaint();
            filmsLocate = null;
            etatFilmsLocate = null;
        } else {
            nomAccoutTextField.setText(abonne.getNom());
            prenomAccoutTextField.setText(abonne.getPrenom());
            mailAccoutTextField.setText(abonne.getEmail());
            adresseAccoutTextField.setText(abonne.getAdresse());
            telephoneAccounTextField.setText(abonne.getTel());
            soldeLabel.setText("Solde : " + abonne.getSolde() + "€");
            filmsPanel.removeAll();
            filmsPanel.revalidate();
            filmsPanel.repaint();
            model.setFilmsAbonnes(abonne.getID());
            filmsLocate = model.getNameFilmsLocate();
            etatFilmsLocate = model.getEtatFilmsLocate();
            JPanel p;
            for (int i = 0; i < filmsLocate.size(); i++) {
                p = new JPanel();
                p.setLayout(new GridLayout(1, 2));
                JLabel nomFilm = new JLabel(filmsLocate.get(i).getNom());
                p.add(nomFilm);
                JLabel etatFilm = new JLabel(etatFilmsLocate.get(i));
                p.add(etatFilm);
                filmsPanel.add(p);
            }
        }
    }

    @Override
    public void metAJour() {
        switch (model.getLastUpdate()) {
            case "connexion":
                abonne = model.getAbonneConnecte();
                miseAJourUI(abonne);
                break;
            case "déconnexion":
                abonne = model.getAbonneConnecte();
                miseAJourUI(abonne);
                break;
            case "updateAbonne":
                abonne = model.getAbonneConnecte();
                miseAJourUI(abonne);
                break;
            case "updateLocation":
                abonne = model.getAbonneConnecte();
                miseAJourUI(abonne);
                break;
            default:
                break;
        }
    }

    public Abonne getAbonne() {
        return abonne;
    }
    
}
