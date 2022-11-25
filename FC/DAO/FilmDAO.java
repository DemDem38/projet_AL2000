package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import FC.POJO.DemandeAjout;
import FC.POJO.Film;
import FC.POJO.Support;

public class FilmDAO extends DAO<Film>{

    public FilmDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Film film) {
        //ne pas oublier : si on créer un film, on créer un support QR code direct
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("insert into films values("+film.toSQL()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Film read(Object obj) {
        String nomFilm = (String) obj;
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from films where nomFilm = '" + nomFilm + "'");
            res.next();
            return new Film(res.getString("nomFilm"), 
            res.getString("categories"), 
            res.getString("synopsis"), 
            res.getString("synopsis"), 
            res.getString("acteurs").split(","));
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return null;
    }

    @Override
    public boolean update(Film film) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("UPDATE films set categorie =  '" + film.getCategorie() + "', realisateur = '" + film.getRealisateur() + "', synopsis = '" + film.getSynopsis() + "', acteurs = '" + String.join(",", film.getActeurs()) + "' WHERE nomFilm = '" + film.getNom() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean delete(Film film) {
        boolean b = false;
        // On supprime les demandes d'ajout qui référencent le film
        DAO<DemandeAjout> demandeAjoutDAO = DAOFactory.getDemandeAjoutDAO();
        DemandeAjout[] listeDemandes = ((DemandeAjoutDAO) demandeAjoutDAO).readListe(film.getNom());
        if (listeDemandes != null) {
            for (DemandeAjout demande : listeDemandes) {
                if (demande != null) {
                    demandeAjoutDAO.delete(demande);
                }
            }
        } 

        // On supprime les supports qui référencent le film
        DAO<Support> supportDAO = DAOFactory.getSupportDAO();
        Support[] supports = ((SupportDAO) supportDAO).readListe(film.getNom());
        for (Support support : supports) {
            if (support != null) {
                supportDAO.delete(support);
            }
        }
        
        try {
            b = this.connect.createStatement().execute("delete from films where nomFilm = '" + film.getNom()+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }























































    public ArrayList<Film> getFilms(){
        ArrayList<Film> films = new ArrayList<>();
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from films");
            while(res.next()){
                films.add(new Film(res.getString("nomFilm"), 
                res.getString("categories"), 
                res.getString("synopsis"), 
                res.getString("synopsis"), 
                res.getString("acteurs").split(",")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return films;
    }

    public ArrayList<String> getCategories(){
        ArrayList<String> categories = new ArrayList<>();
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select distinct categories from films");
            while(res.next()){
                categories.add(res.getString("categories"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return categories;
    }
    
}
