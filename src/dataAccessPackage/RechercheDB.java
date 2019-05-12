package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.DeleteTransactionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class RechercheDB {

    public void recherche1(String adresse, Integer matricule, String marque) throws ConnectionException, DeleteTransactionException {
        Connection connection = SingletonConnection.getConnexion();
        try{
            String queryId = "";
            PreparedStatement prepStat = connection.prepareStatement(queryId);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            throw new DeleteTransactionException();
        }
    }

    public void recherche2(String modele, String adresse) throws ConnectionException, DeleteTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        try{
            String queryId = "";
            PreparedStatement prepStat = connection.prepareStatement(queryId);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            throw new DeleteTransactionException();
        }
    }

    public void recherche3(GregorianCalendar dateDebut, GregorianCalendar dateFin, String modele, String adresse) throws ConnectionException, DeleteTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        try{
            String queryId = "";
            PreparedStatement prepStat = connection.prepareStatement(queryId);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            throw new DeleteTransactionException();
        }
    }
}
