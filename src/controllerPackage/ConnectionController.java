package controllerPackage;

import businessPackage.*;
import exceptionPackage.CloseException;
import exceptionPackage.ConnectionException;
import modelPackage.*;

public class ConnectionController {
    private ConnectionManager manager;

    public ConnectionController(){
        setManager(new ConnectionManager());
    }

    public void setManager(ConnectionManager manager) {
        this.manager = manager;
    }

    public void closeConnection() throws CloseException{
        try{
            manager.closeConnection();
        }catch (ConnectionException e){}

    }

    public void checkConnection() throws ConnectionException{
        manager.checkConnection();
    }
}
