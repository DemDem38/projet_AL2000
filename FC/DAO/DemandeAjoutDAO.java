package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import FC.POJO.DemandeAjout;

public class DemandeAjoutDAO extends DAO<DemandeAjout>{

    public DemandeAjoutDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }
    @Override
    public boolean create(DemandeAjout dAjout) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("insert into demandesAjouts(abonneID, filmID) values("+dAjout.toSQL()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public DemandeAjout read(int id) {
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from demandesAjouts where demandeAjoutID = " + id);
            res.next();
            return new DemandeAjout(res.getInt("demandeAjoutID"), res.getInt("abonneID"), res.getInt("filmID"));
        } catch (SQLException e) {
            System.out.println("La demande n'est pas dans la BDD");
        };
        return null;
    }

    @Override
    public boolean update(DemandeAjout dAjout) {
        return false; // ne sert à rien
    }

    @Override
    public boolean delete(DemandeAjout dAjout) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("delete from DemandesAjouts where demandeAjoutID = " + dAjout.getDemandeAjoutID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    public ArrayList<DemandeAjout> readListeFromFilm(int filmID) {
        ArrayList<DemandeAjout> liste = new ArrayList<DemandeAjout>();
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from demandesajouts where filmID = " + filmID);
            while(res.next()){
                liste.add(new DemandeAjout(res.getInt("demandeAjoutID"), res.getInt("abonneID"), res.getInt("filmID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }

    public ArrayList<DemandeAjout> readListeFromAbonne(int abonneID) {
        ArrayList<DemandeAjout> liste = new ArrayList<DemandeAjout>();
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from demandesajouts where abonneID = " + abonneID);
            while(res.next()){
                liste.add(new DemandeAjout(res.getInt("demandeAjoutID"), res.getInt("abonneID"), res.getInt("filmID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return liste;
    }
}
