package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface TransactionDataAccess {
    ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException;
    int ajouteTransaction(Transaction newTransaction, int nextId) throws ConnectionException, AddTransactionException;
    void updateTransaction(Transaction upTransaction) throws ConnectionException, UpdateTransactionException;
    void deleteTransaction(Integer idTransaction) throws ConnectionException, DeleteTransactionException;
    int getNextId() throws ConnectionException;
    ArrayList<Transaction> getTransactionsAndMarques() throws ConnectionException, GetTransactionException;
}
