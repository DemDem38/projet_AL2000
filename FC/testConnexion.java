package FC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

import FC.DAO.DBConnexion;

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
            
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}
