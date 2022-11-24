package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public DemandeAjout read(Object obj) {
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
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("delete from DemandesAjouts where abonneID = "+ obj.getAbonneID() + " and  nomFilm = '" + obj.getNomFilm() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    public DemandeAjout[] readListe(String nomFilm) {
        DemandeAjout[] liste = new DemandeAjout[1000];
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from demandesajouts where nomFilm = '" + nomFilm + "'");
            int i = 0;
            while(res.next()){
                liste[i] = new DemandeAjout(res.getInt("abonneID"),
                res.getString("nomFilm"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }
}
