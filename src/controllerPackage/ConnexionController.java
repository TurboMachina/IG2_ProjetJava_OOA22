package controllerPackage;

import businessPackage.ConnexionManager;

public class ConnexionController {

    ConnexionManager manager;

    public ConnexionController(){
        setManager(new ConnexionManager());
    }

    public void setManager(ConnexionManager manager){
        this.manager = manager;
    }

    public void closeConnexion()throws Exception{
        manager.closeConnexion();
    }
}
