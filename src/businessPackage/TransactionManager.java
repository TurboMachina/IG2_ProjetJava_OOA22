package businessPackage;


import dataAccessPackage.*;
import exceptionPackage.*;
import modelPackage.Client;
import modelPackage.Commercial;
import modelPackage.FicheVehicule;
import modelPackage.Transaction;
import java.sql.Connection;
import java.util.ArrayList;

public class TransactionManager {
    private TransactionDataAccess daoTransaction;
    private ClientDataAccess daoClient;
    private CommercialDataAccess daoCommercial;
    private FicheVehiculeDataAccess daoFicheVeh;
    private RechercheDataAccess daoRecherche;

    public TransactionManager(){
    }

    public void setDAOTransaction(TransactionDataAccess dao){this.daoTransaction = dao;}
    public void setDAOClient(ClientDataAccess dao){this.daoClient = dao;}
    public void setDAOCommercial(CommercialDataAccess dao){this.daoCommercial = dao;}
    public void setDAOFicheVeh(FicheVehiculeDataAccess dao){this.daoFicheVeh = dao;}


    public ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException {
        setDAOTransaction(new TransactionDBAccess());
        return daoTransaction.getAllTransactions();
    }

    public ArrayList<Client> getAllClients() throws ConnectionException, GetClientException {
        setDAOClient(new ClientDBAccess());
        return daoClient.getAllClients();
    }

    public ArrayList<Commercial> getAllCommerciaux() throws ConnectionException, GetCommercialException {
        setDAOCommercial(new CommercialDBAccess());
        return daoCommercial.getAllCommerciaux();
    }

    public ArrayList<FicheVehicule> getAllNumChassis() throws ConnectionException, GetFicheVehException {
        setDAOFicheVeh(new FicheVehiculeDBAccess());
        return daoFicheVeh.getAllNumChassis();
    }

    public int ajouteTransaction(Transaction transaction) throws ConnectionException, AddTransactionException{
        setDAOTransaction(new TransactionDBAccess());
        int idMax = daoTransaction.getNextId();
        return daoTransaction.ajouteTransaction(transaction,idMax);
    }

    public void updateTransaction(Transaction transaction) throws ConnectionException, UpdateTransactionException{
        setDAOTransaction(new TransactionDBAccess());
        daoTransaction.updateTransaction(transaction);
    }

    public void deleteTransaction(Integer idTransaction) throws ConnectionException, DeleteTransactionException{
        setDAOTransaction(new TransactionDBAccess());
        daoTransaction.deleteTransaction(idTransaction);
    }
}
