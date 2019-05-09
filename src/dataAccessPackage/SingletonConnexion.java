package dataAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnexion {

    private static String URL = "jdbc:mysql://localhost:3306/dbprojet";
    private static String LOGIN = "project";
    private static String PASSWORD = "project";
    private static Connection uniqueConnexion;

    private SingletonConnexion() {}

    public static Connection getConnection() throws SQLException {
        if(uniqueConnexion == null){
                uniqueConnexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        }
        return uniqueConnexion;
    }

    static void closeConnection() throws SQLException {
        uniqueConnexion.close();
    }
}
