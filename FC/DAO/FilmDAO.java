package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("insert into films(nomFilm, categories, realisateur, synopsis, acteurs) values("+film.toSQL()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Film read(int id) {
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from films where filmID = " + id);
            res.next();
            return new Film(res.getInt("filmID"),
            res.getString("nomFilm"), 
            res.getString("categories"), 
            res.getString("synopsis"), 
            res.getString("synopsis"), 
            new ArrayList<String>(Arrays.asList(res.getString("acteurs").split(","))));
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return null;
    }

    @Override
    public boolean update(Film film) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("UPDATE films set categorie =  '" + film.getCategorie() + "', realisateur = '" + film.getRealisateur() + "', synopsis = '" + film.getSynopsis() + "', acteurs = '" + String.join(",", film.getActeurs()) + "' where filmID = " + film.getFilmID());
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
        ArrayList<DemandeAjout> listeDemandes = ((DemandeAjoutDAO) demandeAjoutDAO).readListe(film.getFilmID());
        if (listeDemandes != null) {
            for (DemandeAjout demande : listeDemandes) {
                if (demande != null) {
                    demandeAjoutDAO.delete(demande);
                }
            }
        } 

        // On supprime les supports qui référencent le film
        DAO<Support> supportDAO = DAOFactory.getSupportDAO();
        ArrayList<Support> supports = ((SupportDAO) supportDAO).readListe(film.getFilmID());
        for (Support support : supports) {
            if (support != null) {
                supportDAO.delete(support);
            }
        }
        
        try {
            b = this.connect.createStatement().execute("delete from films where filmID = " + film.getFilmID());
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
                films.add(new Film(res.getInt("filmID"), 
                res.getString("nomFilm"), 
                res.getString("categories"), 
                res.getString("synopsis"), 
                res.getString("realisateur"), 
                new ArrayList<String>(Arrays.asList(res.getString("acteurs").split(",")))));
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
