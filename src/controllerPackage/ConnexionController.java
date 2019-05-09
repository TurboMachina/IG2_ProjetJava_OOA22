package controllerPackage;

import businessPackage.ConnexionManager;
import exceptionPackage.*;

import java.sql.SQLException;

public class ConnexionController {

    private ConnexionManager manager;

    public ConnexionController(){
        setManager(new ConnexionManager());
    }

    private void setManager(ConnexionManager manager){
        this.manager = manager;
    }

    public void closeConnexion()throws SQLException {
        manager.closeConnexion();
    }

    public void verifierMatricule(String matricule) throws MatriculeException{
        manager.verifierMatricule(matricule);
    }
}
