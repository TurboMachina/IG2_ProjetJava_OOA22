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

    public void closeConnection() throws CloseException, ConnectionException{
            manager.closeConnection();
    }

    public void checkConnection() throws ConnectionException{
        manager.checkConnection();
    }
}
