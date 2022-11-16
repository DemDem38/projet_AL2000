package FC.DAO;

import java.sql.Connection;

import FC.POJO.Film;

public class FilmDAO extends DAO<Film>{

    public FilmDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Film obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Film read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Film obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Film obj) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
