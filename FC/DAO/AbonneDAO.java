package FC.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import FC.POJO.Abonne;
import FC.POJO.DemandeAjout;
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
            ArrayList<String> al = new ArrayList<>();
            if (res.getString("restrictions") != null) {
                al = new ArrayList<String>(Arrays.asList(res.getString("restrictions").split(",")));
            }
            return new Abonne(res.getInt("abonneID"),
            res.getString("nom"),
            res.getString("prenom"),
            res.getString("email"),
            res.getString("adresse"),
            res.getString("telephone"),
            al,
            res.getInt("solde"),
            res.getInt("mdpHash")
            );
        } catch (SQLException e) {
            System.out.println("L'abonné n'est plus dans la BDD");
        };
        return null;
    }

    @Override
    public boolean update(Abonne abonne) {
        boolean b = false;
        try {
            b = this.connect.createStatement().execute("update abonnes set nom = '" + abonne.getNom() +"', prenom = '" + abonne.getPrenom() + "', email = '" + abonne.getEmail() + "', adresse = '" + abonne.getAdresse() + "', telephone = '" + abonne.getTel() + "', restrictions = '" + String.join(",", abonne.getRestrictions()) + "', solde = " + abonne.getSolde() + ", mdpHash = " + abonne.getMdp() + " where AbonneID = " + abonne.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean delete(Abonne abonne) {
        boolean b = false;
        DAO<Location> locationDAO = DAOFactory.getLocationDAO();
        DAO<DemandeAjout> demandeAjoutDAO = DAOFactory.getDemandeAjoutDAO();

        ArrayList<Location> locations = ((LocationDAO) locationDAO).readListeFromAbonne(abonne.getID());
        for (Location location : locations) {
            if (location != null) {
                locationDAO.delete(location);
            }
        }

        ArrayList<DemandeAjout> demandeAjouts = ((DemandeAjoutDAO) demandeAjoutDAO).readListeFromAbonne(abonne.getID());
        for (DemandeAjout demandeAjout : demandeAjouts) {
            if (demandeAjout != null) {
                demandeAjoutDAO.delete(demandeAjout);
            }
        }

        try {
            b = this.connect.createStatement().execute("delete from abonnes where abonneID = " + abonne.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    public Abonne getAbonne(String email, int mdp) {
        try {
            ResultSet res = this.connect.createStatement().executeQuery("select * from abonnes where email = '" + email + "' and mdpHash = " + mdp);
            res.next();
            ArrayList<String> al = new ArrayList<>();
            if (res.getString("restrictions") != null) {
                al = new ArrayList<String>(Arrays.asList(res.getString("restrictions").split(",")));
            }
            return new Abonne(res.getInt("abonneID"),
            res.getString("nom"),
            res.getString("prenom"),
            res.getString("email"),
            res.getString("adresse"),
            res.getString("telephone"),
            al,
            res.getInt("solde"),
            res.getInt("mdpHash")
            );
        } catch (SQLException e) {
            System.out.println("Cet utilisateur n'existe pas");
        }
        return null;
    }
    
}
