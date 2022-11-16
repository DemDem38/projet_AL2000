package FC;

import java.sql.*;

import FC.DAO.DBConnexion;

public class testConnexion {
    public static void main(String[] args) {
        Connection connexion = DBConnexion.instance();
        System.out.println("Bonjour");
        try {
            ResultSet result = connexion.createStatement().
            executeQuery("SELECT owner, TABLE_NAME FROM all_tables WHERE owner NOT IN ('SYS', 'SYSTEM', 'CTXSYS', 'MDSYS') ORDER BY owner, TABLE_NAME");
            while (result.next()) {
                System.out.println(result.getString("owner"));
                System.out.println(result.getString("TABLE_NAME"));
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }
}
