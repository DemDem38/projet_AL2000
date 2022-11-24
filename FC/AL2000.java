package FC;

import java.sql.Connection;

import FC.DAO.AbonneDAO;
import FC.DAO.DBConnexion;
import FC.DAO.FilmDAO;
import FC.DAO.LocationDAO;
import FC.DAO.SupportDAO;
import FC.PATTERNS.Observable;

public class AL2000 extends Observable {
    AbonneDAO abonneDAO;
    FilmDAO filmDAO;
    LocationDAO locationDAO;
    SupportDAO supportDAO;
    Connection connexion;

    public AL2000() {
//        connexion = DBConnexion.instance();
//        abonneDAO = new AbonneDAO(connexion);
//        filmDAO = new FilmDAO(connexion);
//        locationDAO = new LocationDAO(connexion);
//        supportDAO = new SupportDAO(connexion);
    }

    /*public Abonne Connexion(String email, int mdp) {
        Abonne abonne;
        return abonne;
    }*/
}
