package FC.DAO;

import java.sql.Connection;

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
    public Location read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Location obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Location obj) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
