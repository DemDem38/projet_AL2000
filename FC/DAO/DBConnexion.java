package FC.DAO;

import java.sql.*;

public class DBConnexion {
    protected static Connection instance;
    protected DBConnexion() {

    }

    public static Connection instance() {
        if(instance == null) {
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); // Chargement du pilote
                instance = DriverManager.getConnection ("jdbc:oracle:thin:@im2ag-oracle.univ-grenoble-alpes.fr:1521:im2ag", "perringe", "82fa44ad8f"); // connexion
            } catch (Exception err) { 
                    System.out.println("Une erreur, Oh Oh!"); 
            } // Attention il faut capturer les exceptions !
        }
        return instance;
    }
}
