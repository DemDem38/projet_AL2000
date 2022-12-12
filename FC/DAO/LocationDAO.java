package FC.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import FC.POJO.Etat;
import FC.POJO.Location;

public class LocationDAO extends DAO<Location> {
    SimpleDateFormat sdf;
    public LocationDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    }

    @Override
    public boolean create(Location location) {
        boolean b = false;
        try {
            location.setDateDebut(sdf.format(new Date(System.currentTimeMillis())));
            location.setEtat(Etat.enCours);
            b = this.connect.createStatement().execute("insert into locations(supportID, dateDebut, dateFin, abonneID, etat) values("+location.toSQL()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Location read(int id) {
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from locations where locationID = " + id);
            res.next();
            return new Location(
                res.getInt("locationID"), 
                res.getInt("supportID"), 
                res.getString("dateDebut"), 
                res.getString("dateFin"), 
                res.getInt("abonneID"), 
                res.getString("etat"));
        } catch (SQLException e) {
            System.out.println("La location n'est plus dans la BDD");
        };
        return null;
    }

    @Override
    public boolean update(Location location) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("update locations set dateFin = '" + location.getDateFin() +"', etat = '" + location.getEtat() + "' where locationID = " + location.getLocationID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean delete(Location location) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("delete from locations where locationID = " + location.getLocationID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public ArrayList<Location> readListeFromSupport(int supportID) {
        ArrayList<Location> liste = new ArrayList<>();
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from locations where supportID = " + supportID);
            while(res.next()){
                liste.add(new Location(
                    res.getInt("locationID"), 
                    res.getInt("supportID"), 
                    res.getString("dateDebut"), 
                    res.getString("dateFin"), 
                    res.getInt("abonneID"), 
                    res.getString("etat")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }

    public ArrayList<Location> readListeFromAbonne(int abonneID) {
        ArrayList<Location> liste = new ArrayList<>();
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from locations where abonneID = " + abonneID);
            while(res.next()){
                liste.add(new Location(
                    res.getInt("locationID"), 
                    res.getInt("supportID"), 
                    res.getString("dateDebut"), 
                    res.getString("dateFin"), 
                    res.getInt("abonneID"), 
                    res.getString("etat")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }

    public Location readFromNomDate(String nomFilm, String dateDebut) {
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from locations join supports using(supportID) join films using(filmID) where nomFilm = '" + nomFilm + "' and dateDebut = '" + dateDebut + "'");
            res.next();
            return new Location(
                res.getInt("locationID"), 
                res.getInt("supportID"), 
                res.getString("dateDebut"), 
                res.getString("dateFin"), 
                res.getInt("abonneID"), 
                res.getString("etat"));
        } catch (SQLException e) {
            System.out.println("La location n'est plus dans la BDD");
        };
        return null;
    }
    
}
