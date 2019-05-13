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
        if(testTransaction(transaction)) {
            int idMax = daoTransaction.getNextId();
            return daoTransaction.ajouteTransaction(transaction, idMax);
        }
        else
            return 0;
    }

    public void updateTransaction(Transaction transaction) throws ConnectionException, UpdateTransactionException, TransactionFormException{
        setDAOTransaction(new TransactionDBAccess());
        if(testTransaction(transaction))
            daoTransaction.updateTransaction(transaction);
    }

    public void deleteTransaction(Integer idTransaction) throws ConnectionException, DeleteTransactionException, DeleteFormException{
        setDAOTransaction(new TransactionDBAccess());
        int idMax = daoTransaction.getNextId();
        DeleteFormException error = new DeleteFormException();
        if(idTransaction < 0 || idTransaction > idMax){
            error.addError("- L'ID a supprimer est plus grande que l'ID max de la table");
            throw error;
        }
        else
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



    //TESTS

    private boolean testTransaction(Transaction transaction) throws TransactionFormException {
        TransactionFormException error = new TransactionFormException();
        Integer errorCount = 0;

        //ID Transaction
        if(transaction.getId() != null){
            if (!(transaction.getId() instanceof Integer)){
                errorCount++;
                error.addError("- ID pas de type Entier");
            }
        }
        else{
            errorCount++;
            error.addError("- ID vide");
        }

        //Kilometrage
        if(transaction.getKilometrage() != null){
            if(!(transaction.getKilometrage() instanceof Integer)){
                errorCount++;
                error.addError("- Kilométrage pas de type Entier");
            }
            else{
                if(transaction.getKilometrage() < 0){
                    errorCount++;
                    error.addError("- Kilometrage inférieur à 0");
                }
            }
        }
        else{
            errorCount++;
            error.addError("- Kilométrage vide" );
        }

        //couleur
        if(transaction.getCouleur() != null){
            if(!checkIfMot(transaction.getCouleur())){
                errorCount++;
                error.addError("- Votre couleur n'est pas un mot");
            }
        }
        else{
            errorCount++;
            error.addError("- Couleur vide");
        }

        //prixAchat

        //prixDepart

        //prixMin

        //nbProprios

        //description

        //dateArrivee

        //estTVARecup

        //prixVente

        //dateVente

        //etat

        //matricule

        //numChassis

        //idClient

        return (errorCount == 0);
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return Integer.parseInt(value) < 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean tryParseFloat(String value) {
        try {
            Float.parseFloat(value);
            return Float.parseFloat(value) < 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkDateIsPrior(Date value){
        Date todayDate = new Date();
        return (value.before(todayDate) || value.equals(todayDate));
    }

    private boolean checkIfMot(String s) {
        if (s == null){
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
