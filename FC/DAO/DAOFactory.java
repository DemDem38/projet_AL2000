package FC.DAO;

import java.sql.Connection;

import FC.POJO.Abonne;
import FC.POJO.DemandeAjout;
import FC.POJO.Film;
import FC.POJO.Location;
import FC.POJO.Support;

public class DAOFactory {
    protected static final Connection conn = DBConnexion.instance();
    public static DAO<Abonne> getAbonneDAO(){
        return new AbonneDAO(conn);
    }
    public static DAO<Film> getFilmDAO(){
        return new FilmDAO(conn);
    }
    public static DAO<Location> getLocationDAO(){
        return new LocationDAO(conn);
    }
    public static DAO<Support> getSupportDAO(){
        return new SupportDAO(conn);
    }
    public static DAO<DemandeAjout> getDemandeAjoutDAO(){
        return new DemandeAjoutDAO(conn);
    }
    
}
