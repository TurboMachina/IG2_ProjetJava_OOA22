package businessPackage;
import dataAccessPackage.*;
import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;
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
        setDAOTransaction(new TransactionDBAccess());
        setDAOClient(new ClientDBAccess());
        setDAOCommercial(new CommercialDBAccess());
        setDAOFicheVeh(new FicheVehiculeDBAccess());
        setDAORecherche(new RechercheDBAccess());
        setDAOMarque(new MarqueDBAccess());
        setDAOMagasin(new MagasinDBAccess());
        setDAOModele(new ModeleDBAccess());
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

        return daoTransaction.getAllTransactions();
    }

    public ArrayList<Client> getAllClients() throws ConnectionException, GetClientException {

        return daoClient.getAllClients();
    }

    public ArrayList<Commercial> getAllCommerciaux() throws ConnectionException, GetCommercialException {

        return daoCommercial.getAllCommerciaux();
    }

    public ArrayList<FicheVehicule> getAllNumChassis() throws ConnectionException, GetFicheVehException {

        return daoFicheVeh.getAllNumChassis();
    }

    public Integer ajouteTransaction(Transaction transaction) throws ConnectionException, AddTransactionException {

        Integer idMax = getNextID();
        return daoTransaction.ajouteTransaction(transaction, idMax);
    }

    public int getNextID() throws ConnectionException{

        return daoTransaction.getNextId();
    }

    public void updateTransaction(Transaction transaction) throws ConnectionException, UpdateTransactionException{

        daoTransaction.updateTransaction(transaction);
    }

    public void deleteTransaction(Integer idTransaction) throws ConnectionException, DeleteTransactionException{

        daoTransaction.deleteTransaction(idTransaction);
    }

    public ArrayList<Transaction> rechercheTransaction(Integer matricule, String marque) throws ConnectionException, RechercheException{

        return daoRecherche.rechercheTransaction(matricule,marque);
    }
    public ArrayList<Transaction> rechercheModele(Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{

        return daoRecherche.rechercheModele(idModele, idMagasin);
    }
    public ArrayList<Transaction> rechercheVente(GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{

        return daoRecherche.rechercheVente(dateDebut,dateFin,idModele,idMagasin);
    }

    public ArrayList<Marque> getAllMarques() throws ConnectionException, GetMarqueException{

        return daoMarque.getAllMarques();
    }

    public ArrayList<Magasin> getAllMagasins() throws ConnectionException, GetMagasinException{

        return daoMagasin.getAllMagasins();
    }

    public ArrayList<Modele> getAllModeles() throws ConnectionException, GetModeleException{

        return daoModele.getAllModeles();
    }
}
