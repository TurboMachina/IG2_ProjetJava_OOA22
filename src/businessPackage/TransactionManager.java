package businessPackage;


import dataAccessPackage.*;
import exceptionPackage.*;
import modelPackage.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TransactionManager {
    private TransactionDataAccess daoTransaction;
    private ClientDataAccess daoClient;
    private CommercialDataAccess daoCommercial;
    private FicheVehiculeDataAccess daoFicheVeh;
    private RechercheDataAccess daoRecherche;
    private MarqueDataAccess daoMarque;

    public TransactionManager(){
    }

    public void setDAOTransaction(TransactionDataAccess dao){this.daoTransaction = dao;}
    public void setDAOClient(ClientDataAccess dao){this.daoClient = dao;}
    public void setDAOCommercial(CommercialDataAccess dao){this.daoCommercial = dao;}
    public void setDAOFicheVeh(FicheVehiculeDataAccess dao){this.daoFicheVeh = dao;}
    public void setDAORecherche(RechercheDataAccess dao){this.daoRecherche = dao;}
    public void setDAOMarque(MarqueDataAccess dao){this.daoMarque = dao;}


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

    public ArrayList<Transaction> rechercheTransaction(Integer matricule, String marque) throws ConnectionException, RechercheException{
        setDAORecherche(new RechercheDBAccess());
        return daoRecherche.rechercheTransaction(matricule,marque);
    }
    public ArrayList<Transaction> rechercheModele(Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{
        setDAORecherche(new RechercheDBAccess());
        return daoRecherche.rechercheModele(idModele, idMagasin);
    }
    public ArrayList<Transaction> rechercheVente(GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{
        setDAORecherche(new RechercheDBAccess());
        return daoRecherche.rechercheVente(dateDebut,dateFin,idModele,idMagasin);
    }

    public ArrayList<Marque> getAllMarques() throws ConnectionException, GetMarqueException{
        setDAOMarque(new MarqueDBAccess());
        return daoMarque.getAllMarques();
    }
}
