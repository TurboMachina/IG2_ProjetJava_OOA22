package dataAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnexion {

    public static String URL = "jdbc:mysql://localhost:3306/dbprojet";
    public static String LOGIN = "project";
    public static String PASSWORD = "project";
    private static Connection uniqueConnexion;

    private SingletonConnexion() {}

    public static Connection getConnection() throws SQLException {
        if(uniqueConnexion == null){
            try{
                uniqueConnexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return uniqueConnexion;
    }
}
