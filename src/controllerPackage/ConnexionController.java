package controllerPackage;

import businessPackage.ConnexionManager;

public class ConnexionController {

    private ConnexionManager manager;

    public ConnexionController(){
        setManager(new ConnexionManager());
    }

    private void setManager(ConnexionManager manager){
        this.manager = manager;
    }

    public void closeConnexion()throws Exception{
        manager.closeConnexion();
    }
}
