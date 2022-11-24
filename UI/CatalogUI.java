package UI;


import FC.AL2000;
import FC.POJO.Film;
import UI.customPanel.BotPanel;
import UI.customPanel.TopPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogUI extends JPanel {

    AL2000 model;
    CollecteurEvenements controller;
    ArrayList<MovieTile> movies;
    ArrayList<JCheckBox> categories;
    JTextField searchBar;

    CatalogUI(MainFrame mainFrame, AL2000 m, CollecteurEvenements c){

        super(new BorderLayout());

        model = m;
        controller = c;
        movies = new ArrayList<>();
        categories = new ArrayList<>();

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
        JPanel moviePanel = new JPanel(new GridLayout(0, 5));
        GridLayout gl = (GridLayout) moviePanel.getLayout();
        gl.setVgap(30);

        JScrollPane movieScrollPanel = new JScrollPane(moviePanel);
        centerPanel.add(movieScrollPanel, BorderLayout.CENTER);

        // TODO afficher les vrai films
        for (int i=0; i<25; i++){
            MovieTile tile = new MovieTile(new Film("Top Gun", "Action", "Synopsis", "Anthony", null), "/res/Images/topgun.jpg", mainFrame);
            movies.add(tile);
            moviePanel.add(tile);
        }

        // Category panel
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.PAGE_AXIS));

        JScrollPane categoryScrollPanel = new JScrollPane(categoryPanel);
        categoryScrollPanel.setBorder(new EmptyBorder(0,25,0,35));
        categoryScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerPanel.add(categoryScrollPanel, BorderLayout.WEST);

        // TODO afficher les vrais catégories
        for (int i=0; i<20; i++){
            JCheckBox cb = new JCheckBox(i < 10 ? "Action":"Aventure");
            cb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateSearch();
                }
            });
            cb.setMargin(new Insets(0,0,0,35));
            categories.add(cb);
            categoryPanel.add(cb);
        }

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
        for(JCheckBox cb : categories){
            if (cb.isSelected()){
                selectedCategories.add(cb);
            }
        }
        return selectedCategories;
    }

    public void updateSearch(){
        ArrayList<JCheckBox> selectedCategories = getSelectedCategories();
        for (MovieTile movie : movies) {
            Film film = movie.getFilm();
            movie.setVisible(true);
            if (!searchBar.getText().isEmpty() && !film.getNom().toLowerCase().replace(" ","").contains(searchBar.getText().toLowerCase().replace(" ",""))){
                movie.setVisible(false);
            }
            if(!selectedCategories.isEmpty()){
                movie.setVisible(false);
                for (JCheckBox cb : selectedCategories) {
                    if (film.getCategorie() == cb.getText() && (searchBar.getText().isEmpty() || film.getNom().toLowerCase().replace(" ","").contains(searchBar.getText().toLowerCase().replace(" ","")))){
                        movie.setVisible(true);
                    }
                }
            }
        }
    }
}
