package FC.DAO;

import java.sql.Connection;

public class DAOFactory {
    protected static final Connection conn = DBConnexion.instance();
    public static DAO getAbonneDAO(){
        return new AbonneDAO(conn);
    }
    public static DAO getFilmDAO(){
        return new FilmDAO(conn);
    }
    public static DAO getLocationDAO(){
        return new LocationDAO(conn);
    }
    public static DAO getSupportDAO(){
        return new SupportDAO(conn);
    }
    public static DAO getDemandeAjoutDAO(){
        return new DemandeAjoutDAO(conn);
    }
    
}
