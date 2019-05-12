package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.RechercheException;
import modelPackage.Transaction;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface RechercheDataAccess {
    ArrayList<Transaction> rechercheTransaction(Integer matricule, String marque) throws ConnectionException, RechercheException;
    ArrayList<Transaction> rechercheModele(Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException;
    ArrayList<Transaction> rechercheVente(GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException;
}
