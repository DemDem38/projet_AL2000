package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import FC.POJO.BluRay;
import FC.POJO.Location;
import FC.POJO.QR;
import FC.POJO.Support;

public class SupportDAO extends DAO<Support>{

    public SupportDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Support obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Support support) {
        boolean b = false;
        // On supprime les locations qui referencent le support
        DAO<Location> locationDAO = DAOFactory.getLocationDAO();
        Location[] locations = ((LocationDAO) locationDAO).readListe(support.getID());
        for (Location location : locations) {
            if (location != null) {
                locationDAO.delete(location);
            }
        }

        try {
            b = this.connect.createStatement().execute("delete from supports where supportID = " + support.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Support read(Object obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Support obj) {
        // TODO Auto-generated method stub
        return false;
    }

    public Support[] readListe(String nomFilm) {
        Support[] liste = new Support[1000];    // TODO : ArrayList
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from supports where nomFilm = '" + nomFilm + "'");
            int i = 0;
            while(res.next()){
                if (res.getString("typeSup") == "QRCode") {
                    liste[i] = new QR(res.getInt("SupportID"));
                } else {
                    liste[i] = new BluRay(res.getInt("SupportID"), res.getString("nomFilm"));
                }
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }
    
}
