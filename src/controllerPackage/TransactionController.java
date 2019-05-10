package controllerPackage;

import businessPackage.*;
import dataAccessPackage.SingletonConnection;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetTransactionException;
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
}
