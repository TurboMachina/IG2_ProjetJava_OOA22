package controllerPackage;

import businessPackage.ConnexionManager;
import modelPackage.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class ConnexionController{
    ConnexionManager manager;

    public ConnexionController(){
        setManager(manager);
    }

    private void setManager(ConnexionManager manager){
        this.manager = manager;
    }

    public ArrayList<Transaction> getAllTransactions() throws Exception {
        return manager.getAllTransactions();
    }

    public void closeConnection() throws Exception{
        manager.closeConnexion();
    }

}
