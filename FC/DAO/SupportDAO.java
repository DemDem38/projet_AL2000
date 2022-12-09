package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import FC.POJO.BluRay;
import FC.POJO.Location;
import FC.POJO.QR;
import FC.POJO.Support;

public class SupportDAO extends DAO<Support>{

    public SupportDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Support support) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("insert into supports(filmID, typeSup, dateExpiration) values("+support.toSQL()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean delete(Support support) {
        boolean b = false;
        // On supprime les locations qui referencent le support
        DAO<Location> locationDAO = DAOFactory.getLocationDAO();
        ArrayList<Location> locations = ((LocationDAO) locationDAO).readListeFromSupport(support.getSupportID());
        for (Location location : locations) {
            if (location != null) {
                locationDAO.delete(location);
            }
        }
        try {
            b = this.connect.createStatement().execute("delete from supports where supportID = " + support.getSupportID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Support read(int id) {
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from supports where supportID = " + id + "");
            res.next();
            if (res.getString("typeSup").equals("QRCode")) {
                return new QR(res.getInt("supportID"), res.getInt("filmID"), res.getString("dateExpiration"));
            } else {
                return new BluRay(res.getInt("supportID"), res.getInt("filmID"));
            }
        } catch (SQLException e) {
            System.out.println("Le support n'est pas dans la BDD");
        };
        return null;
    }

    @Override
    public boolean update(Support support) {
        boolean b = false;
        try {
            String typeSup;
            if (support instanceof QR) {
                typeSup = "QRCode";
            } else {
                typeSup = "BluRay";
            }
            b = this.connect.createStatement().execute("UPDATE supports set filmID = " + support.getFilmID() + ", typeSup = '" + typeSup + "' WHERE supportID = " + support.getSupportID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    public ArrayList<Support> readListe(int filmID) {
        ArrayList<Support> liste = new ArrayList<>();
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from supports where filmID = " + filmID);
            while(res.next()){
                if (res.getString("typeSup") == "QRCode") {
                    liste.add(new QR(res.getInt("SupportID")));
                } else {
                    liste.add(new BluRay(res.getInt("SupportID"), res.getInt("filmID")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }
    
}
