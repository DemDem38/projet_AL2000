package FC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import FC.DAO.DAO;
import FC.DAO.DAOFactory;
import FC.DAO.DBConnexion;
import FC.DAO.FilmDAO;
import FC.POJO.Abonne;
import FC.POJO.BluRay;
import FC.POJO.Film;
import FC.POJO.Location;
import FC.POJO.Support;

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
            Film film = filmDAO.read(1);
            System.out.println(film);

            filmDAO.delete(film);

            ResultSet resultat = statement.executeQuery("select * from films where filmID = 1");
            while(resultat.next()) { // récupération des résultats
                System.out.println(new Film 
                (resultat.getInt("filmID"), 
                resultat.getString("nomFilm"), 
                resultat.getString("categories"), 
                resultat.getString("synopsis"), 
                resultat.getString("realisateur"), 
                new ArrayList<String>(Arrays.asList(resultat.getString("acteurs").split(",")))));
            }
            /*DAO<Location> lDao = DAOFactory.getLocationDAO();
            Location l = lDao.read(1);
            System.out.println(l);

            DAO<Support> sDao = DAOFactory.getSupportDAO();
            Support s = sDao.read(1);
            System.out.println(s);

            sDao.delete(s);
            s = sDao.read(1);
            System.out.println(s);

            l = lDao.read(1);
            System.out.println(l);*/

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
