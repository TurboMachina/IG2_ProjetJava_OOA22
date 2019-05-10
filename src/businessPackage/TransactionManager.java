package businessPackage;

import dataAccessPackage.*;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetTransactionException;
import modelPackage.*;

import java.sql.Connection;
import java.util.ArrayList;

public class TransactionManager {
    private TransactionDataAccess dao;

    public TransactionManager(){
        setDAO(new TransactionDBAccess());
    }

    public void setDAO(TransactionDataAccess dao){this.dao = dao;}

    public ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException {
        return dao.getAllTransactions();
    }
}
