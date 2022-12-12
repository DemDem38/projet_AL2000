package UI;


import FC.AL2000;
import FC.PATTERNS.Observateur;
import FC.POJO.Film;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogUI extends JPanel implements Observateur {

    AL2000 model;
    CollecteurEvenements controller;
    ArrayList<MovieTile> movies;
    ArrayList<JCheckBox> categoriesCB;
    JTextField searchBar;
    MainFrame mainFrame;
    JPanel moviePanel;
    JPanel categoryPanel;

    CatalogUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

        super(new BorderLayout());

        model = m;
        model.ajouteObservateur(this);
        controller = c;
        movies = new ArrayList<>();
        this.mainFrame = mainFrame;
        categoriesCB = new ArrayList<>();

        // Top panel
        TopPanel topPanel = new TopPanel(mainFrame, model, controller);
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        // Search panel
        JPanel searchPanel = new JPanel();
        centerPanel.add(searchPanel, BorderLayout.NORTH);

        JLabel searchLabel = new JLabel("Rechercher : ");
        searchPanel.add(searchLabel);

        searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(300,20));
        searchBar.setAlignmentX(CENTER_ALIGNMENT);
        searchPanel.add(searchBar);

//        JButton searchButton = new JButton("Rechercher");
//        searchButton.setFocusable(false);
//        searchPanel.add(searchButton);

        // Movie panel
        moviePanel = new JPanel(new GridLayout(0, 5));
        GridLayout gl = (GridLayout) moviePanel.getLayout();
        gl.setVgap(30);

        JScrollPane movieScrollPanel = new JScrollPane(moviePanel);
        movieScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        movieScrollPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(128, 20, 213);
            }
        });
        centerPanel.add(movieScrollPanel, BorderLayout.CENTER);

        // Category panel
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.PAGE_AXIS));

        JScrollPane categoryScrollPanel = new JScrollPane(categoryPanel);
        categoryScrollPanel.setBorder(new EmptyBorder(0,25,0,35));
        categoryScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerPanel.add(categoryScrollPanel, BorderLayout.WEST);


        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearch();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearch();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearch();
            }
        });

        // Bot panel
        BotPanel botPanel = new BotPanel(mainFrame, "catalogUI");
        add(botPanel, BorderLayout.SOUTH);
        
    }

    public ArrayList<JCheckBox> getSelectedCategories(){
        ArrayList<JCheckBox> selectedCategories = new ArrayList<>();
        for(JCheckBox cb : categoriesCB){
            if (cb.isSelected()){
                selectedCategories.add(cb);
            }
        }
        return selectedCategories;
    }

    public void updateSearch(){
        moviePanel.removeAll();
        ArrayList<JCheckBox> selectedCategories = getSelectedCategories();
        for (MovieTile movie : movies) {
            Film film = movie.getFilm();
            moviePanel.add(movie);
            //movie.setVisible(true);
            if (!searchBar.getText().isEmpty() && !film.getNom().toLowerCase().replace(" ","").contains(searchBar.getText().toLowerCase().replace(" ",""))){
                moviePanel.remove(movie);
                //movie.setVisible(false);
            }
            if(!selectedCategories.isEmpty()){
                moviePanel.remove(movie);
                //movie.setVisible(false);
                for (JCheckBox cb : selectedCategories) {
                    if (film.getCategorie().equalsIgnoreCase(cb.getText()) && (searchBar.getText().isEmpty() || film.getNom().toLowerCase().replace(" ","").contains(searchBar.getText().toLowerCase().replace(" ","")))){
                        moviePanel.add(movie);
                        //movie.setVisible(true);
                    }
                }
            }
        }
        moviePanel.repaint();
        moviePanel.revalidate();
    }

    @Override
    public void metAJour() {
        if(model.getLastUpdate().equals("catalogue")){
            // Mise a jour du catalogue
            movies.clear();
            moviePanel.removeAll();
            ArrayList<Film> catalogue = model.getCatalogue();
            for(Film film : catalogue){
                MovieTile tile = new MovieTile(film, mainFrame, model);
                movies.add(tile);
                moviePanel.add(tile);
            }

            // Mise à jour des categories
            categoriesCB.clear();
            categoryPanel.removeAll();
            ArrayList<String> categories = model.getCategories();
            for (String categorie : categories){
                JCheckBox cb = new JCheckBox(categorie);
                cb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateSearch();
                    }
                });
                cb.setMargin(new Insets(0,0,0,35));
                categoriesCB.add(cb);
                categoryPanel.add(cb);
            }
        }
    }
}
