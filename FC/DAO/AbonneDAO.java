package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import FC.POJO.Abonne;
import FC.POJO.Location;

public class AbonneDAO extends DAO<Abonne> {

    public AbonneDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Abonne abonne) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("insert into abonnes(nom, prenom, email, adresse, telephone, restrictions, solde, mdpHash) values("+abonne.toSQL()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Abonne read(int id) {
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from abonnes where abonneID = " + id);
            res.next();
            return new Abonne(res.getInt("abonneID"),
            res.getString("nom"),
            res.getString("prenom"),
            res.getString("email"),
            res.getString("adresse"),
            res.getString("telephone"),
            new ArrayList<String>(Arrays.asList(res.getString("restrictions").split(","))),
            res.getInt("solde"),
            res.getInt("mdpHash")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        };
        return null;
    }

    @Override
    public boolean update(Abonne abonne) {
        boolean b = false;
        // TODO : vérifier format dateFin
        try {
            b = this.connect.createStatement().execute("update abonnes set nom = '" + abonne.getNom() +"' and prenom = '" + abonne.getPrenom() + "' and email = '" + abonne.getEmail() + "' and adresse = '" + abonne.getAdresse() + "' and telephone = '" + abonne.getTel() + "' and restrictions = '" + String.join(",", abonne.getRestrictions()) + "' and solde = " + abonne.getSolde() + " and mdpHash = " + abonne.getMdp());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean delete(Abonne abonne) {
        boolean b = false;
        DAO<Location> locationDAO = DAOFactory.getLocationDAO();
        ArrayList<Location> locations = ((LocationDAO) locationDAO).readListe(abonne.getID());
        for (Location location : locations) {
            if (location != null) {
                locationDAO.delete(location);
            }
        }
        try {
            b = this.connect.createStatement().execute("delete from abonnes where abonneID = " + abonne.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
    
}
