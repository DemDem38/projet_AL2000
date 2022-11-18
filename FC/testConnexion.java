package FC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

import FC.DAO.DBConnexion;
import FC.POJO.Abonne;
import FC.POJO.BluRay;
import FC.POJO.Film;

public class testConnexion {
    public static void main(String[] args) throws IOException {
        Connection connexion = DBConnexion.instance();
        try {
            Statement statement;
            statement = connexion.createStatement();

            Path path = Path.of("BDD/drop.sql");
            String str = Files.readString(path);
            String[] sentences = str.split(";");  
            for (String commande : sentences) {
                statement.execute(commande);
            }

            path = Path.of("BDD/create.sql");
            str = Files.readString(path);
            sentences = str.split(";");
            for (String commande : sentences) {

                statement.execute(commande);
            }

            path = Path.of("BDD/insert.sql");
            str = Files.readString(path);
            sentences = str.split(";");
            for (String commande : sentences) {
                statement.execute(commande);
            }

            ResultSet resultat = statement.executeQuery("select * from films");
            while(resultat.next()) { // récupération des résultats
                Film f = new Film(resultat.getString("nomFilm"), resultat.getString("categories"), resultat.getString("synopsis"), resultat.getString("synopsis"), resultat.getString("acteurs").split(","));
                System.out.println(f);
            }

            resultat = statement.executeQuery("select * from supports");
            while(resultat.next()) { // récupération des résultats
                BluRay bluray = new BluRay(resultat.getInt("supportID"), resultat.getString("nomFilm"));
                System.out.println(bluray);
            }

            resultat = statement.executeQuery("select * from abonnes");
            while(resultat.next()) { // récupération des résultats
                Abonne abonne = new Abonne(resultat.getInt("abonneID"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("email"), resultat.getString("adresse"), resultat.getString("telephone"), (resultat.getString("restrictions")==null?null:resultat.getString("restrictions").split(",")), resultat.getInt("solde"), resultat.getInt("mdpHash"));
                System.out.println(abonne);
            }
            
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}
