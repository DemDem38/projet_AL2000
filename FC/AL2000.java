package FC;

import java.sql.Connection;
import java.util.ArrayList;

import FC.DAO.AbonneDAO;
import FC.DAO.DAO;
import FC.DAO.DAOFactory;
import FC.DAO.DBConnexion;
import FC.DAO.FilmDAO;
import FC.DAO.LocationDAO;
import FC.DAO.SupportDAO;
import FC.PATTERNS.Observable;
import FC.POJO.Abonne;
import FC.POJO.Film;
import FC.POJO.Location;
import FC.POJO.Support;

public class AL2000 extends Observable {
    AbonneDAO abonneDAO;
    FilmDAO filmDAO;
    LocationDAO locationDAO;
    SupportDAO supportDAO;
    Connection connexion;
    ArrayList<Film> catalogue;
    ArrayList<String> categories;
    String lastUpdate;
    Film currentFilm;

    public AL2000() {
        connexion = DBConnexion.instance();
        abonneDAO = (AbonneDAO) DAOFactory.getAbonneDAO();
        filmDAO = (FilmDAO) DAOFactory.getFilmDAO();
        locationDAO = (LocationDAO) DAOFactory.getLocationDAO();
        supportDAO = (SupportDAO) DAOFactory.getSupportDAO();
        catalogue = new ArrayList<>();
        categories = new ArrayList<>();
    }

    /*public Abonne Connexion(String email, int mdp) {
        Abonne abonne;
        return abonne;
    }*/

    public void updateCatalogue(){
        catalogue = filmDAO.getFilms();
        categories = filmDAO.getCategories();
        lastUpdate = "catalogue";
        miseAJour();
    }

    public ArrayList<Film> getCatalogue() {
        return catalogue;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public Film getCurrentFilm() {
        return currentFilm;
    }

    public void setCurrentFilm(Film currentFilm) {
        this.currentFilm = currentFilm;
        lastUpdate = "currentFilm";
        miseAJour();
    }

    public String getLastUpdate(){
        return this.lastUpdate;
    }

}
