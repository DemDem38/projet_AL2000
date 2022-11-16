package FC.DAO;

import java.sql.Connection;

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
    public boolean delete(Support obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Support read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Support obj) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
