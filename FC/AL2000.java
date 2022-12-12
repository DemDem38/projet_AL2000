package FC;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import FC.DAO.AbonneDAO;
import FC.DAO.DAO;
import FC.DAO.DAOFactory;
import FC.DAO.DBConnexion;
import FC.DAO.DemandeAjoutDAO;
import FC.DAO.FilmDAO;
import FC.DAO.LocationDAO;
import FC.DAO.SupportDAO;
import FC.PATTERNS.Observable;
import FC.POJO.Abonne;
import FC.POJO.DemandeAjout;
import FC.POJO.Etat;
import FC.POJO.Film;
import FC.POJO.Location;
import FC.POJO.QR;
import FC.POJO.Support;

public class AL2000 extends Observable {
    AbonneDAO abonneDAO;
    FilmDAO filmDAO;
    LocationDAO locationDAO;
    SupportDAO supportDAO;
    DemandeAjoutDAO demandeDAO;
    Connection connexion;
    ArrayList<Film> catalogue;
    ArrayList<String> categories;
    String lastUpdate;
    Film currentFilm;
    Abonne abonneConnecte;
    ArrayList<Film> nameFilmsLocate;
    ArrayList<String> etatFilmsLocate;
    ArrayList<String> dateFilmsLocate;
    SimpleDateFormat sdf;

    public AL2000() {
        connexion = DBConnexion.instance();
        abonneDAO = (AbonneDAO) DAOFactory.getAbonneDAO();
        filmDAO = (FilmDAO) DAOFactory.getFilmDAO();
        locationDAO = (LocationDAO) DAOFactory.getLocationDAO();
        supportDAO = (SupportDAO) DAOFactory.getSupportDAO();
        demandeDAO = (DemandeAjoutDAO) DAOFactory.getDemandeAjoutDAO();
        catalogue = new ArrayList<>();
        categories = new ArrayList<>();
        abonneConnecte = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void connexion(String email, int mdp) {
        Abonne abonne = abonneDAO.getAbonne(email, mdp);
        this.abonneConnecte = abonne;
        lastUpdate = "connexion";
        miseAJour();
    }

    public void abonner(String nom, String prenom, String login, int password, String adresse, String telephone, int solde) {
        Abonne abonne = new Abonne(nom, prenom, login, adresse, telephone, new ArrayList<>(), solde, password);
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
        abonneConnecte.setSolde(abonneConnecte.getSolde() - 5);
        updateAbonne(abonneConnecte);
        miseAJour();
    }

    public String getLastUpdate(){
        return this.lastUpdate;
    }

    public Abonne getAbonneConnecte() {
        return abonneConnecte;
    }
    
    public void setFilmsAbonnes(int id) {
        Etat etatLocation;
        int supportID, filmID;
        Support support;
        Film film;
        nameFilmsLocate = new ArrayList<>();
        etatFilmsLocate = new ArrayList<>();
        dateFilmsLocate = new ArrayList<>();
        ArrayList<Location> loc = locationDAO.readListeFromAbonne(id);
        for (Location l : loc) {
            etatLocation = l.getEtat();
            switch(etatLocation) {
                case enCours:
                    etatFilmsLocate.add("EN COURS");
                    break;
                case Termine:
                    etatFilmsLocate.add("TERMINE");
                    break;
                case Inspection:
                    etatFilmsLocate.add("INSPECTION");
                    break;
            }
            supportID = l.getSupportID();
            support = supportDAO.read(supportID);
            filmID = support.getFilmID();
            film = filmDAO.read(filmID);
            nameFilmsLocate.add(film);
            dateFilmsLocate.add(l.getDateDebut());
        }
    }

    public ArrayList<Film> getNameFilmsLocate() {
        return nameFilmsLocate;
    }

    public ArrayList<String> getEtatFilmsLocate() {
        return etatFilmsLocate;
    }
    public ArrayList<String> getDateFilmsLocate() {
        return dateFilmsLocate;
    }

    public void deleteAbonne(Abonne abonne) {
        deconnexion();
        abonneDAO.delete(abonne);
    }

    public void updateAbonne(Abonne abonne) {
        abonneDAO.update(abonne);
        abonneConnecte = abonne;
        lastUpdate = "updateAbonne";
        miseAJour();
    }

    public Location getLocation(String nomFilm, String dateDebut) {
        return locationDAO.readFromNomDate(nomFilm, dateDebut);
    }

    public void updateLocation(Location location) {
        location.setDateFin(sdf.format(new Date(System.currentTimeMillis())));
        location.setEtat(Etat.Termine);

        // TODO : Si solde < 0 rip
        long difference_In_Time = 0;
        try {
            difference_In_Time = sdf.parse(location.getDateFin()).getTime() - sdf.parse(location.getDateDebut()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        abonneConnecte.setSolde((int) (abonneConnecte.getSolde() - 4 * difference_In_Days));
        updateAbonne(abonneConnecte);
        locationDAO.update(location);
        lastUpdate = "updateLocation";
        miseAJour();
    }

    public void demandeBluRay(){
        DemandeAjout demande = new DemandeAjout(abonneConnecte.getID(), currentFilm.getFilmID());
        demandeDAO.create(demande);
    }
    
}
