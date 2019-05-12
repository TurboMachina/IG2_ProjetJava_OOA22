package businessPackage;

import controllerPackage.ConnectionController;
import dataAccessPackage.*;
import exceptionPackage.CloseException;
import exceptionPackage.ConnectionException;
import modelPackage.*;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private Connection connection;

    public void closeConnection() throws CloseException, ConnectionException {
        connection = SingletonConnection.getConnexion();
        try {
            connection.close();
        }
        catch (SQLException e){
            throw new CloseException();
        }
    }

    public void checkConnection() throws ConnectionException{
            Connection connection = SingletonConnection.getConnexion();
    }
}
