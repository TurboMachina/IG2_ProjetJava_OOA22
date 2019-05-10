package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface TransactionDataAccess {
    Transaction getTransaction(Integer idTransaction);
    ArrayList<Transaction> getAllTransactions();
    void ajouteTransactions(Transaction newTransaction);
    void updateClient(Transaction upTransaction);
    void deleteClient(Transaction transaction);
}
