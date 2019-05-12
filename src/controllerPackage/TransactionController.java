package controllerPackage;

import businessPackage.*;
import dataAccessPackage.RechercheDBAccess;
import dataAccessPackage.SingletonConnection;
import exceptionPackage.*;
import modelPackage.*;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class TransactionController {
    private TransactionManager manager;

    public TransactionController(){
        setManager(new TransactionManager());
    }

    public void setManager(TransactionManager manager){
        this.manager = manager;
    }

    public ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException {
        return manager.getAllTransactions();
    }

    public ArrayList<Client> getAllClients() throws ConnectionException, GetClientException{
        return manager.getAllClients();
    }

    public ArrayList<Commercial> getAllCommerciaux() throws ConnectionException, GetCommercialException {
        return manager.getAllCommerciaux();
    }

    public ArrayList<FicheVehicule> getAllNumChassis() throws ConnectionException, GetFicheVehException {
        return manager.getAllNumChassis();
    }

    public int ajouteTransaction(Transaction transaction) throws ConnectionException, AddTransactionException{
        return manager.ajouteTransaction(transaction);
    }

    public void updateTransaction(Transaction transaction) throws ConnectionException, UpdateTransactionException{
        manager.updateTransaction(transaction);
    }

    public void deleteTransaction(Integer idTransaction) throws ConnectionException, DeleteTransactionException{
        manager.deleteTransaction(idTransaction);
    }

    public ArrayList<Transaction> recherche1(Integer matricule, String marque) throws ConnectionException, RechercheException{
        return manager.recherche1(matricule,marque);
    }
    public ArrayList<Transaction> recherche2(Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{
        return manager.recherche2(idModele, idMagasin);
    }
    public ArrayList<Transaction> recherche3(GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{
        return manager.recherche3(dateDebut,dateFin,idModele,idMagasin);
    }


    //TESTS

    public boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            if(Integer.parseInt(value) < 0)
                return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean tryParseFloat(String value) {
        try {
            Float.parseFloat(value);
            if (Float.parseFloat(value) < 0)
                return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkDateIsPrior(Date value){
        Date todayDate = new Date();
        return (value.before(todayDate) || value.equals(todayDate));
    }

    public boolean checkIfMot(String s) {
        if (s == null){
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ((Character.isLetter(s.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

}
