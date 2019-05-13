package businessPackage;


import dataAccessPackage.*;
import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class TransactionManager {
    private TransactionDataAccess daoTransaction;
    private ClientDataAccess daoClient;
    private CommercialDataAccess daoCommercial;
    private FicheVehiculeDataAccess daoFicheVeh;
    private RechercheDataAccess daoRecherche;
    private MarqueDataAccess daoMarque;
    private MagasinDataAccess daoMagasin;
    private ModeleDataAccess daoModele;

    public TransactionManager(){
    }

    private void setDAOTransaction(TransactionDataAccess dao){this.daoTransaction = dao;}
    private void setDAOClient(ClientDataAccess dao){this.daoClient = dao;}
    private void setDAOCommercial(CommercialDataAccess dao){this.daoCommercial = dao;}
    private void setDAOFicheVeh(FicheVehiculeDataAccess dao){this.daoFicheVeh = dao;}
    private void setDAORecherche(RechercheDataAccess dao){this.daoRecherche = dao;}
    private void setDAOMarque(MarqueDataAccess dao){this.daoMarque = dao;}
    private void setDAOMagasin(MagasinDataAccess dao){this.daoMagasin = dao;}
    private void setDAOModele(ModeleDataAccess dao){this.daoModele = dao;}


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

    public int ajouteTransaction(Transaction transaction) throws ConnectionException, AddTransactionException, TransactionFormException {
        setDAOTransaction(new TransactionDBAccess());
        Integer idMax = getNextID();
        return daoTransaction.ajouteTransaction(transaction, idMax);
    }

    public int getNextID() throws ConnectionException{
        setDAOTransaction(new TransactionDBAccess());
        Integer idMax = daoTransaction.getNextId();
        return idMax;
    }

    public void updateTransaction(Transaction transaction) throws ConnectionException, UpdateTransactionException, TransactionFormException{
        setDAOTransaction(new TransactionDBAccess());
        daoTransaction.updateTransaction(transaction);
    }

    public void deleteTransaction(Integer idTransaction) throws ConnectionException, DeleteTransactionException, DeleteFormException{
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

    public ArrayList<Magasin> getAllMagasins() throws ConnectionException, GetMagasinException{
        setDAOMagasin(new MagasinDBAccess());
        return daoMagasin.getAllMagasins();
    }

    public ArrayList<Modele> getAllModeles() throws ConnectionException, GetModeleException{
        setDAOModele(new ModeleDBAccess());
        return daoModele.getAllModeles();
    }
}
