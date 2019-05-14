package controllerPackage;

import businessPackage.ConnectionManager;
import exceptionPackage.CloseException;
import exceptionPackage.ConnectionException;

public class ConnectionController {
    private ConnectionManager manager;

    public ConnectionController(){
        setManager(new ConnectionManager());
    }

    private void setManager(ConnectionManager manager) {
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
