package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface TransactionDataAccess {
    Transaction getTransaction(Integer idTransaction) throws ConnectionException, GetTransactionException;
    ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException;
    void ajouteTransactions(Transaction newTransaction) throws ConnectionException, AddTransactionException;
    void updateTransaction(Transaction upTransaction) throws ConnectionException, UpdateTransactionException;
    void deleteTransaction(Transaction transaction) throws ConnectionException, DeleteTransactionException;
}
