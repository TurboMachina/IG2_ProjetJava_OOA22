package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.OtherException;
import modelPackage.*;

import java.sql.*;

public class SingletonConnection {

    private static String URL = "jdbc:mysql://localhost:3306/dbprojet";
    private static String LOGIN = "project";
    private static String PASSWORD = "project";
    private static Connection uniqueConnexion;

    private SingletonConnection() {}

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
