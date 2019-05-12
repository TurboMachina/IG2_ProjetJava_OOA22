package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.RechercheException;
import modelPackage.Transaction;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface RechercheDataAccess {
    ArrayList<Transaction> recherche1(Integer matricule, String marque) throws ConnectionException, RechercheException;
    ArrayList<Transaction> recherche2(Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException;
    ArrayList<Transaction> recherche3(GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException;
}
