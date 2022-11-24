package FC.DAO;

import java.sql.Connection;

import FC.POJO.Abonne;

public class AbonneDAO extends DAO<Abonne> {

    public AbonneDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Abonne obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Abonne read(Object obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Abonne obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Abonne obj) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
