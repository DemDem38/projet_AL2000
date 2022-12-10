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
import FC.POJO.QR;
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
    Abonne abonneConnecte;

    public AL2000() {
        connexion = DBConnexion.instance();
        abonneDAO = (AbonneDAO) DAOFactory.getAbonneDAO();
        filmDAO = (FilmDAO) DAOFactory.getFilmDAO();
        locationDAO = (LocationDAO) DAOFactory.getLocationDAO();
        supportDAO = (SupportDAO) DAOFactory.getSupportDAO();
        catalogue = new ArrayList<>();
        categories = new ArrayList<>();
        abonneConnecte = null;
    }

    public void connexion(String email, int mdp) {
        Abonne abonne = abonneDAO.getAbonne(email, mdp);
        this.abonneConnecte = abonne;
        lastUpdate = "connexion";
        miseAJour();
    }

    public void abonner(String nom, String prenom, String login, int password, String adresse, String telephone) {
        Abonne abonne = new Abonne(nom, prenom, login, adresse, telephone, new ArrayList<>(), 0, password);
        abonneDAO.create(abonne);
        connexion(login, password);
    }

    public void deconnexion() {
        abonneConnecte = null;
        lastUpdate = "déconnexion";
        miseAJour();
    }

    public boolean isConnected() {
        return abonneConnecte != null;
    }

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

    public boolean bluRayAvailable(){
        Support bluRayAvailable = null;
        if (isConnected()){
            bluRayAvailable = supportDAO.getBluRayAvailable(currentFilm.getFilmID());
        }
        return bluRayAvailable != null;
    }

    public void createLocation(String type){
        if(type=="QR"){
            QR qr = new QR(currentFilm.getFilmID());
            int key = supportDAO.createSupport(qr);
            Location location = new Location(key, isConnected() ? abonneConnecte.getID():-1);
            location.setDateFin(qr.getDateExpiration());
            locationDAO.create(location);
        }else{
            Support bluRayAvailable = supportDAO.getBluRayAvailable(currentFilm.getFilmID());
            Location location = new Location(bluRayAvailable.getSupportID(), isConnected() ? abonneConnecte.getID():-1);
            locationDAO.create(location);
        }
    }

    public String getLastUpdate(){
        return this.lastUpdate;
    }

    

}
