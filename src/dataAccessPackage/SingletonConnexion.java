package dataAccessPackage;

import exceptionPackage.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnexion {

    private static String URL = "jdbc:mysql://localhost:3306/dbprojet";
    private static String LOGIN = "project";
    private static String PASSWORD = "project";
    private static Connection uniqueConnexion;

    private SingletonConnexion() {}

    public static Connection getConnexion() throws ConnectionException {
        if(uniqueConnexion == null){
            try{
                uniqueConnexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            }
            catch (SQLException e){
                throw new ConnectionException();
            }
        }
        return uniqueConnexion;
    }
}
