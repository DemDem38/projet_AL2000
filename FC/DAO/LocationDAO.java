package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import FC.POJO.Location;

public class LocationDAO extends DAO<Location> {

    public LocationDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Location obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Location read(Object obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Location obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Location location) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("delete from locations where supportID = " + location.getSupportID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public Location[] readListe(int supportID) {
        Location[] liste = new Location[1000];
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from locations where supportID = " + supportID);
            int i = 0;
            while(res.next()){
                liste[i] = new Location(res.getInt("supportID"), res.getInt("abonneID"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }
    
}
