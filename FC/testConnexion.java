package FC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import FC.DAO.AbonneDAO;
import FC.DAO.DAO;
import FC.DAO.DAOFactory;
import FC.DAO.DBConnexion;
import FC.DAO.DemandeAjoutDAO;
import FC.DAO.FilmDAO;
import FC.DAO.LocationDAO;
import FC.DAO.SupportDAO;
import FC.POJO.Abonne;
import FC.POJO.BluRay;
import FC.POJO.DemandeAjout;
import FC.POJO.Etat;
import FC.POJO.Film;
import FC.POJO.Location;
import FC.POJO.QR;
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

            //DROP
            String str = fileToString("/BDD/drop.sql");
            String[] sentences = str.split(";");  
            for (String commande : sentences) {
                statement.execute(commande);
            }

            //CREATE
            str = fileToString("/BDD/create.sql");
            sentences = str.split(";");
            for (String commande : sentences) {
                statement.execute(commande);
            }

            //INSERT
            str = fileToString("/BDD/insert.sql");
            sentences = str.split(";");
            for (String commande : sentences) {
                statement.execute(commande);
            }

            /*
            // Test film
            DAO<Film> filmDAO = new FilmDAO(connexion);
            System.out.println("TEST CREATE : \n");
            String test = "test";
            ArrayList<String> acteurs = new ArrayList<>();
            acteurs.add(test);
            acteurs.add(test);
            acteurs.add(test);
            Film f = new Film(test, test, test, test, acteurs);
            filmDAO.create(f);
            System.out.println(filmDAO.read(16));

            // test read
            Film film = filmDAO.read(1);
            System.out.println("TEST READ : \n");
            System.out.println(film);

            // test update
            System.out.println("---------------------\n");
            System.out.println("TEST UPDATE : \n");
            film.setNom("Le Parrain");
            filmDAO.update(film);
            System.out.println("AFFICHAGE DU FILM MIS A JOUR \n");
            film = filmDAO.read(1);
            System.out.println(film);

            // test delete
            System.out.println("---------------------\n");
            System.out.println("TEST DELETE : \n");
            filmDAO.delete(film);
            System.out.println(filmDAO.read(1)==null?"OK":"Suppression échouée");
            


            // Test location
            DAO<Location> locationDAO = new LocationDAO(connexion);
            System.out.println("TEST CREATE : \n");
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            Location l = new Location(13, 1);
            locationDAO.create(l);
            System.out.println(locationDAO.read(16));
            // test read
            Location location = locationDAO.read(2);
            System.out.println("TEST READ : \n");
            System.out.println(location);

            // test update
            System.out.println("---------------------\n");
            System.out.println("TEST UPDATE : \n");
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            location.setDateFin(sdf.format(new Date(System.currentTimeMillis())));
            location.setEtat(Etat.Termine);
            locationDAO.update(location);
            System.out.println("AFFICHAGE DE LA LOCATION MISE A JOUR \n");
            location = locationDAO.read(2);
            System.out.println(location);

            // test delete
            System.out.println("---------------------\n");
            System.out.println("TEST DELETE : \n");
            locationDAO.delete(location);
            System.out.println(locationDAO.read(2)==null?"OK":"Suppression échouée");
            

            
            // Test abonnes
            DAO<Abonne> abonneDao = new AbonneDAO(connexion);
            System.out.println("TEST CREATE : \n");
            ArrayList<String> restrictions = new ArrayList<>();
            restrictions.add(test);
            restrictions.add(test);
            restrictions.add(test);
            Abonne a = new Abonne(test, test, test, test, test, restrictions, 0, 0);
            abonneDao.create(a);
            System.out.println(abonneDao.read(11));

            // test read
            Abonne abonne = abonneDao.read(1);
            System.out.println("TEST READ : \n");
            System.out.println(abonne);

            // test update
            System.out.println("---------------------\n");
            System.out.println("TEST UPDATE : \n");
            abonne.setAdresse("39 RTE DU TUYAU");
            abonneDao.update(abonne);
            System.out.println("AFFICHAGE DE L'ABONNE MIS A JOUR \n");
            abonne = abonneDao.read(1);
            System.out.println(abonne);
            // test delete
            System.out.println("---------------------\n");
            System.out.println("TEST DELETE : \n");
            abonneDao.delete(abonne);
            System.out.println(abonneDao.read(1)==null?"OK":"Suppression échouée");
            
            

            // Test Supports
            DAO<Support> supportDAO = new SupportDAO(connexion);
            System.out.println("TEST CREATE : \n");
            QR q = new QR(8);
            BluRay b = new BluRay(7);
            supportDAO.create(q);
            supportDAO.create(b);
            System.out.println(supportDAO.read(26));
            System.out.println(supportDAO.read(27));

            // test read
            Support support = supportDAO.read(2);
            System.out.println("TEST READ : \n");
            System.out.println(support);

            // test update
            System.out.println("---------------------\n");
            System.out.println("TEST UPDATE : \n");
            support.setFilmID(3);
            supportDAO.update(support);
            System.out.println("AFFICHAGE DU SUPPORT MIS A JOUR \n");
            support = supportDAO.read(2);
            System.out.println(support);

            // test delete
            System.out.println("---------------------\n");
            System.out.println("TEST DELETE : \n");
            supportDAO.delete(support);
            System.out.println(supportDAO.read(2)==null?"OK":"Suppression échouée");
            
            

            // Test demandes d'ajouts
            DAO<DemandeAjout> demandeAjoutDAO = new DemandeAjoutDAO(connexion);
            System.out.println("TEST CREATE : \n");
            DemandeAjout d = new DemandeAjout(4, 14);
            demandeAjoutDAO.create(d);
            System.out.println(demandeAjoutDAO.read(11));

            // test read
            DemandeAjout demandeAjout = demandeAjoutDAO.read(2);
            System.out.println("TEST READ : \n");
            System.out.println(demandeAjout);

            // test update
            System.out.println("---------------------\n");
            System.out.println("TEST UPDATE : \n");
            System.out.println("on ne va jamais mettre à jour une demande");

            // test delete
            System.out.println("---------------------\n");
            System.out.println("TEST DELETE : \n");
            demandeAjoutDAO.delete(demandeAjout);
            System.out.println(demandeAjoutDAO.read(2)==null?"OK":"Suppression échouée");
            */
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}
