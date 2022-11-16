package FC.DAO;

import java.sql.Connection;

import FC.POJO.CarteAbonne;

public class CarteCreditDAO extends DAO<CarteAbonne>{

    public CarteCreditDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(CarteAbonne obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public CarteAbonne read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(CarteAbonne obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(CarteAbonne obj) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
