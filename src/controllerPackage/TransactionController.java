package controllerPackage;

import businessPackage.*;
import dataAccessPackage.SingletonConnection;
import exceptionPackage.*;
import modelPackage.*;

import java.sql.Connection;
import java.util.ArrayList;

public class TransactionController {
    private TransactionManager manager;

    public TransactionController(){
        setManager(new TransactionManager());
    }

    public void setManager(TransactionManager manager){
        this.manager = manager;
    }

    public ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException {
        return manager.getAllTransactions();
    }

    public ArrayList<Client> getAllClients() throws ConnectionException, GetClientException{
        return manager.getAllClients();
    }

    public ArrayList<Commercial> getAllCommerciaux() throws ConnectionException, GetCommercialException {
        return manager.getAllCommerciaux();
    }

    public ArrayList<FicheVehicule> getAllNumChassis() throws ConnectionException, GetFicheVehException {
        return manager.getAllNumChassis();
    }

}
