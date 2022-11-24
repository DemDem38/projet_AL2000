package FC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import FC.DAO.DAO;
import FC.DAO.DBConnexion;
import FC.DAO.FilmDAO;
import FC.POJO.Abonne;
import FC.POJO.BluRay;
import FC.POJO.Film;

public class testConnexion {

    public static String fileToString(String fileName) throws IOException {
        InputStream in = testConnexion.class.getResourceAsStream(fileName);
        return new String(in.readAllBytes());
    }
    public static void main(String[] args) throws IOException {
        Connection connexion = DBConnexion.instance();
        try {
            Statement statement;
            statement = connexion.createStatement();

            String str = fileToString("/BDD/drop.sql");
            String[] sentences = str.split(";");  
            for (String commande : sentences) {
                statement.execute(commande);
            }

            str = fileToString("/BDD/create.sql");
            sentences = str.split(";");
            for (String commande : sentences) {
                statement.execute(commande);
            }

            str = fileToString("/BDD/insert.sql");
            sentences = str.split(";");
            for (String commande : sentences) {
                statement.execute(commande);
            }
            //test read et delete
            DAO<Film> filmDAO = new FilmDAO(connexion);
            Film film = filmDAO.read("Avatar");
            System.out.println(film);

            filmDAO.delete(film);

            ResultSet resultat = statement.executeQuery("select * from films where nomFilm = 'Avatar'");
            while(resultat.next()) { // récupération des résultats
                System.out.println( new Film (resultat.getString("nomFilm"), resultat.getString("categories"), resultat.getString("synopsis"), resultat.getString("synopsis"), resultat.getString("acteurs").split(",")));
            }
            /*ResultSet resultat = statement.executeQuery("select * from films");
            while(resultat.next()) { // récupération des résultats
                Film f = new Film(resultat.getString("nomFilm")+ resultat.getString("categories")+ resultat.getString("synopsis"), resultat.getString("synopsis"), resultat.getString("acteurs").split(","));
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
            }*/
            
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}
