package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;
public class TransactionDBAccess implements TransactionDataAccess {

    public Transaction getTransaction(Integer idTransaction) throws ConnectionException, GetTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }

    public ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }

    public void ajouteTransactions(Transaction newTransaction) throws ConnectionException, AddTransactionException{
        Connection connection = SingletonConnection.getConnexion();
    }

    public void updateTransaction(Transaction upTransaction) throws ConnectionException, UpdateTransactionException{
        Connection connection = SingletonConnection.getConnexion();
    }

    public void deleteTransaction(Transaction transaction) throws ConnectionException, DeleteTransactionException{
        Connection connection = SingletonConnection.getConnexion();
    }
}
