package dataAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnexion {

    public static String URL = "jdbc:mysql://localhost:3306/dbprojet";
    private static Connection uniqueConnexion;

    private SingletonConnexion() {}

    public static Connection getConnection(String login, String password) throws SQLException {
        if(uniqueConnexion == null){
            try{
                uniqueConnexion = DriverManager.getConnection(URL, login, password);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return uniqueConnexion;
    }
}
