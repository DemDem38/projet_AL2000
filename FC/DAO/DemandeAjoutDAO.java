package FC.DAO;

import java.sql.Connection;

import FC.POJO.DemandeAjout;

public class DemandeAjoutDAO extends DAO<DemandeAjout>{

    public DemandeAjoutDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(DemandeAjout obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public DemandeAjout read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(DemandeAjout obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(DemandeAjout obj) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
