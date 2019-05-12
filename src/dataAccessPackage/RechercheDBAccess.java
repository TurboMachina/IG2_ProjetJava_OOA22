package dataAccessPackage;

import exceptionPackage.ConnectionException;
import exceptionPackage.DeleteTransactionException;
import exceptionPackage.RechercheException;
import modelPackage.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RechercheDBAccess implements RechercheDataAccess {

    public ArrayList<Transaction> rechercheTransaction(Integer matricule, String marque) throws ConnectionException, RechercheException {
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Transaction> transactions= new ArrayList<>();
        try{
            String query = "SELECT transactions.idTransaction, transactions.prixVente, transactions.dateVente, m2.libelle, m.libelle, c.nom, c.prenom FROM transactions " +
                    "INNER JOIN clients c on transactions.idClient = c.idClient" +
                    "INNER JOIN fichevehicule f on transactions.numChassis = f.numChassis " +
                    "INNER JOIN commercial c2 on transactions.matricule = c2.matricule" +
                    "INNER JOIN modele m on f.idModele = m.idModele" +
                    "INNER JOIN marque m2 on m.libelle = m2.libelle " +
                    "WHERE c2.matricule = ? AND m2.libelle = ?";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1,matricule);
            prepStat.setString(2, marque);
            ResultSet rs = prepStat.executeQuery();
            Transaction transaction;
            java.sql.Date date;
            while(rs.next()){
                transaction = new Transaction(rs.getInt(1));
                transaction.setPrixVente(rs.getFloat(2));

                date = rs.getDate(3);
                GregorianCalendar cal1 = new GregorianCalendar();
                cal1.setTime(date);
                transaction.setDateVente(cal1);

                transaction.setClient(new Client(0));
                transaction.getClient().setNom(rs.getString(6));
                transaction.getClient().setPrenom(rs.getString(7));

                transaction.setFicheVehicule(new FicheVehicule(""));
                transaction.getFicheVehicule().setModele(new Modele(0));
                transaction.getFicheVehicule().getModele().setLibelle(rs.getString(5));

                transaction.getFicheVehicule().getModele().setMarque(new Marque(rs.getString(4)));

                transactions.add(transaction);
            }
        }
        catch (SQLException e){
            throw new RechercheException();
        }
        return transactions;
    }

    public ArrayList<Transaction> rechercheModele(Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Transaction> transactions = new ArrayList<>();
        try{
            String query = "SELECT transactions.id, transactions.kilometrage, transactions.couleur, transactions.prixVente, transactions.dureeGarantie, transactions.estTVARecup, transactions.etat, " +
                    "m.libelle, m.cylindree, m.cylindre, m.transmission, m.vitesses, m.poidAVide, m.carburant, m.consoMixte, m.consoUrbain, m.consoExtraUrbain, m.nbPortes," +
                    "f.dateMiseCircu FROM transactions" +
                    "INNER JOIN fichevehicule f on transactions.numChassis = f.numChassis" +
                    "INNER JOIN modele m on f.idModele = m.idModele" +
                    "INNER JOIN commercial c on transactions.matricule = c.matricule\n" +
                    "INNER JOIN magasin m2 on c.idMagasin = m2.idMagasin " +
                    "WHERE m.idModele = ? AND m2.idMagasin = ?";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1, idModele);
            prepStat.setInt(2, idMagasin);
            ResultSet rs = prepStat.executeQuery();
            Transaction transaction;
            Modele modele;
            java.sql.Date date;
            while (rs.next()){
                transaction = new Transaction(rs.getInt(1));
                transaction.setKilometrage(rs.getInt(2));
                transaction.setCouleur(rs.getString(3));
                transaction.setPrixVente(rs.getFloat(4));
                transaction.setDureeGarantie(rs.getInt(5));
                transaction.setEstTVARecup(rs.getInt(6));
                transaction.setEtat(rs.getString(7));

                transaction.setFicheVehicule(new FicheVehicule(""));
                date = rs.getDate(19);
                GregorianCalendar cal1 = new GregorianCalendar();
                cal1.setTime(date);
                transaction.getFicheVehicule().setDateMiseCircu(cal1);

                modele = new Modele(0);
                modele.setLibelle(rs.getString(8));
                modele.setCylindree(rs.getInt(9));
                modele.setCylindre(rs.getInt(10));
                modele.setTransmission(rs.getString(11));
                modele.setVitesses(rs.getInt(12));
                modele.setPoidAVide(rs.getInt(13));
                modele.setCarburant(rs.getString(14));
                modele.setConsoMixte(rs.getFloat(15));
                modele.setConsoUrbain(rs.getFloat(16));
                modele.setConsoExtraUrbain(rs.getFloat(17));
                modele.setNbPortes(rs.getInt(18));
                transaction.getFicheVehicule().setModele(modele);

                transactions.add(transaction);
            }
        }
        catch (SQLException e){
            throw new RechercheException();
        }
        return transactions;
    }

    public ArrayList<Transaction> rechercheVente(GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin) throws ConnectionException, RechercheException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Transaction> transactions = new ArrayList<>();
        try{
            String queryId = "SELECT transactions.prixVente, transactions.dateVente, f.numChassis, c.nom, c.prenom, c2.nom, c2.prenom FROM transactions\n" +
                    "INNER JOIN fichevehicule f on transactions.numChassis = f.numChassis\n" +
                    "INNER JOIN commercial c on transactions.matricule = c.matricule\n" +
                    "INNER JOIN clients c2 on transactions.idClient = c2.idClient\n" +
                    "WHERE (transactions.dateVente BETWEEN ? AND ?) AND f.idModele = ? AND c.idMagasin = ?";
            PreparedStatement prepStat = connection.prepareStatement(queryId);
            prepStat.setDate(1,new java.sql.Date(dateDebut.getTimeInMillis()));
            prepStat.setDate(2,new java.sql.Date(dateFin.getTimeInMillis()));
            prepStat.setInt(3,idModele);
            prepStat.setInt(4, idMagasin);
            ResultSet rs = prepStat.executeQuery();
            Transaction transaction;
            java.sql.Date date;
            while(rs.next()){
                transaction = new Transaction(0);
                transaction.setPrixVente(rs.getFloat(1));
                date = rs.getDate(2);
                GregorianCalendar cal1 = new GregorianCalendar();
                cal1.setTime(date);
                transaction.setDateVente(cal1);
                transaction.setFicheVehicule(new FicheVehicule(rs.getString(3)));

                transaction.setCommercial(new Commercial(0));
                transaction.getCommercial().setNom(rs.getString(4));
                transaction.getCommercial().setPrenom(rs.getString(5));

                transaction.setClient(new Client(0));
                transaction.getClient().setNom(rs.getString(6));
                transaction.getClient().setPrenom(rs.getString(7));

                transactions.add(transaction);
            }
        }
        catch (SQLException e){
            throw new RechercheException();
        }
        return transactions;
    }
}
