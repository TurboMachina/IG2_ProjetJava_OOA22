package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TransactionDBAccess implements TransactionDataAccess {

    public ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException {
        Connection connexion = SingletonConnection.getConnexion();
        ArrayList<Transaction> allTransactions = new ArrayList<>();
        try{
            String query = "SELECT * FROM dbprojet.transactions\n" +
                    "    LEFT JOIN dbprojet.clients c on transactions.idClient = c.idClient\n" +
                    "    LEFT JOIN dbprojet.commercial c2 on transactions.matricule = c2.matricule\n" +
                    "    LEFT JOIN dbprojet.fichevehicule f on transactions.numChassis = f.numChassis ORDER BY transactions.idTransaction ASC";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();

            Transaction transaction;
            Double prixMin;
            String description;
            Integer nbProprios;
            java.sql.Date date;
            while (rs.next()){
                date = rs.getDate(9);
                GregorianCalendar cal1 = new GregorianCalendar();
                cal1.setTime(date);
                date = rs.getDate(13);
                GregorianCalendar cal2 = new GregorianCalendar();
                cal2.setTime(date);
                transaction = new Transaction(rs.getInt(1));
                transaction.setKilometrage(rs.getInt(2));
                transaction.setCouleur(rs.getString(3));
                transaction.setPrixAchat(rs.getDouble(4));
                transaction.setPrixDepart(rs.getDouble(5));
                transaction.setDateArrivee(cal1);
                transaction.setDureeGarantie(rs.getInt(10));
                transaction.setEstTVARecup(rs.getInt(11));
                transaction.setPrixVente(rs.getDouble(12));
                transaction.setDateVente(cal2);
                transaction.setEtat(rs.getString(14));

                prixMin = rs.getDouble(6) ;
                if (!rs.wasNull())
                    transaction.setPrixMin(prixMin);
                nbProprios = rs.getInt(7);
                if(!rs.wasNull())
                    transaction.setNbProprios(nbProprios);
                description = rs.getString(8);
                if(!rs.wasNull())
                    transaction.setDescription(description);

                transaction.setCommercial(new Commercial(rs.getInt(15)));
                transaction.getCommercial().setNom(rs.getString(24));
                transaction.getCommercial().setPrenom(rs.getString(25));
                transaction.getCommercial().setNumeroTel(rs.getString(26));
                transaction.getCommercial().setAdresseMail(rs.getString(27));
                transaction.getCommercial().setMagasin(new Magasin(rs.getInt(28)));

                transaction.setFicheVehicule(new FicheVehicule(rs.getString(16)));
                date = rs.getDate(30);
                cal1 = new GregorianCalendar();
                cal1.setTime(date);
                transaction.getFicheVehicule().setDateMiseCircu(cal1);
                transaction.getFicheVehicule().setModele(new Modele(rs.getInt(31)));


                transaction.setClient(new Client(rs.getInt(17)));
                transaction.getClient().setNom(rs.getString(19));
                transaction.getClient().setPrenom(rs.getString(20));
                transaction.getClient().setNumeroTel(rs.getString(21));
                transaction.getClient().setAdresseMail(rs.getString(22));

                allTransactions.add(transaction);
            }
        }
        catch (SQLException e){
            throw new GetTransactionException();
        }

        return allTransactions;
    }

    public int ajouteTransaction(Transaction newTransaction, int nextId) throws ConnectionException, AddTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        int insertedLineNumber = 0;
        try {
            String query = "INSERT INTO dbprojet.transactions (kilometrage,couleur,prixAchat,prixDepart,dateArrivee," +
                    "dureeGarantie,estTVARecup,prixVente,dateVente,etat, matricule, numChassis, idClient) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1,newTransaction.getKilometrage());
            prepStat.setString(2, newTransaction.getCouleur());
            prepStat.setDouble(3, newTransaction.getPrixAchat());
            prepStat.setDouble(4, newTransaction.getPrixDepart());
            prepStat.setDate(5, new java.sql.Date(newTransaction.getDateArrivee().getTimeInMillis()));
            prepStat.setInt(6, newTransaction.getDureeGarantie());
            prepStat.setInt(7, (newTransaction.isEstTVARecup() ? 1 : 0));
            prepStat.setDouble(8, newTransaction.getPrixVente());
            prepStat.setDate(9, new java.sql.Date(newTransaction.getDateVente().getTimeInMillis()));
            prepStat.setString(10, newTransaction.getEtat());
            prepStat.setInt(11, newTransaction.getCommercial().getMatricule());
            prepStat.setString(12, newTransaction.getFicheVehicule().getNumChassis());
            prepStat.setInt(13, newTransaction.getClient().getId());
            insertedLineNumber = prepStat.executeUpdate();

            if(newTransaction.getPrixMin()!= null){
                query = "UPDATE transactions SET prixMin = ? where idTransaction = '" + nextId + "'";
                prepStat = connection.prepareStatement(query);
                prepStat.setDouble(1, newTransaction.getPrixMin());
                prepStat.executeUpdate();
            }

            if(newTransaction.getNbProprios() != null){
                query = "UPDATE transactions SET nbProprios = ? where idTransaction = '" + nextId + "'";
                prepStat = connection.prepareStatement(query);
                prepStat.setInt(1, newTransaction.getNbProprios());
                prepStat.executeUpdate();
            }

            if(newTransaction.getDescription() != null){
                query = "UPDATE transactions SET description = ? where idTransaction = '" + nextId + "'";
                prepStat = connection.prepareStatement(query);
                prepStat.setString(1, newTransaction.getDescription());
                prepStat.executeUpdate();
            }
        }
        catch (SQLException e) {
            throw new AddTransactionException();
        }
        return insertedLineNumber;
    }

    public void updateTransaction(Transaction upTransaction) throws ConnectionException, UpdateTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        try{
            String query = "UPDATE dbprojet.transactions SET kilometrage = ?,couleur = ?,prixAchat = ?,prixDepart = ?,dateArrivee = ?" +
                    ", dureeGarantie = ?,estTVARecup = ?,prixVente = ?,dateVente = ?,etat = ?, matricule = ?, numChassis = ?, idClient = ? " +
                    "WHERE idTransaction = '"+ upTransaction.getId() +"'";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1,upTransaction.getKilometrage());
            prepStat.setString(2, upTransaction.getCouleur());
            prepStat.setDouble(3, upTransaction.getPrixAchat());
            prepStat.setDouble(4, upTransaction.getPrixDepart());
            prepStat.setDate(5, new java.sql.Date(upTransaction.getDateArrivee().getTimeInMillis()));
            prepStat.setInt(6, upTransaction.getDureeGarantie());
            prepStat.setInt(7, (upTransaction.isEstTVARecup() ? 1 : 0));
            prepStat.setDouble(8, upTransaction.getPrixVente());
            prepStat.setDate(9, new java.sql.Date(upTransaction.getDateVente().getTimeInMillis()));
            prepStat.setString(10, upTransaction.getEtat());
            prepStat.setInt(11, upTransaction.getCommercial().getMatricule());
            prepStat.setString(12, upTransaction.getFicheVehicule().getNumChassis());
            prepStat.setInt(13, upTransaction.getClient().getId());

            if(upTransaction.getPrixMin()!= null){
                query = "UPDATE transactions SET prixMin = ? where idTransaction = '"+ upTransaction.getId() +"'";
                prepStat = connection.prepareStatement(query);
                prepStat.setDouble(1, upTransaction.getPrixMin());
                prepStat.executeUpdate();
            }
            else{
                query = "UPDATE transactions SET prixMin = ? where idTransaction = '"+ upTransaction.getId() +"'";
                prepStat = connection.prepareStatement(query);
                prepStat.setNull(1, Types.DOUBLE);
                prepStat.executeUpdate();
            }

            if(upTransaction.getNbProprios() != null){
                query = "UPDATE transactions SET nbProprios = ? where idTransaction = '"+ upTransaction.getId() +"'";
                prepStat = connection.prepareStatement(query);
                prepStat.setInt(1, upTransaction.getNbProprios());
                prepStat.executeUpdate();
            }
            else{
                query = "UPDATE transactions SET nbProprios = ? where idTransaction = '"+ upTransaction.getId() +"'";
                prepStat = connection.prepareStatement(query);
                prepStat.setNull(1, Types.INTEGER);
                prepStat.executeUpdate();
            }

            if(upTransaction.getDescription() != null){
                query = "UPDATE transactions SET description = ? where idTransaction = '"+ upTransaction.getId() +"'";
                prepStat = connection.prepareStatement(query);
                prepStat.setString(1, upTransaction.getDescription());
                prepStat.executeUpdate();
            }
            else{
                query = "UPDATE transactions SET description = ? where idTransaction = '"+ upTransaction.getId() +"'";
                prepStat = connection.prepareStatement(query);
                prepStat.setNull(1, Types.VARCHAR);
                prepStat.executeUpdate();
            }
        }
        catch (SQLException e){
            throw new UpdateTransactionException();
        }
    }

    public void deleteTransaction(Integer idTransaction) throws ConnectionException, DeleteTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        try{
            String query = "DELETE FROM transactions WHERE idTransaction = ?";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1,idTransaction);
            prepStat.executeUpdate();
        }
        catch (SQLException e){
            throw new DeleteTransactionException();
        }
    }

    public int getNextId() throws ConnectionException{
        Connection connection = SingletonConnection.getConnexion();
        int nextId = 0;
        try {
            String queryId = "SELECT idTransaction FROM dbprojet.transactions ORDER BY idTransaction DESC LIMIT 1";
            PreparedStatement prepStat = connection.prepareStatement(queryId);
            ResultSet rs = prepStat.executeQuery();
            while(rs.next()){
                nextId = rs.getInt(1)+1;
            }
        }catch (SQLException e){
            throw new ConnectionException();
        }
        return nextId;
    }

    public ArrayList<Transaction> getTransactionsAndMarques() throws ConnectionException, GetTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Transaction> transactions = new ArrayList<>();
        try{
            String query = "SELECT idTransaction, estTVARecup, prixVente, prixAchat, m.App_libelle FROM dbProjet.transactions\n" +
                    "INNER JOIN fichevehicule f on transactions.numChassis = f.numChassis\n" +
                    "INNER JOIN modele m on f.idModele = m.idModele ORDER BY m.App_libelle ASC";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Transaction transaction;
            while (rs.next()){
                transaction = new Transaction(rs.getInt(1));
                transaction.setEstTVARecup(rs.getInt(2));
                transaction.setPrixVente(rs.getDouble(3));
                transaction.setPrixAchat(rs.getDouble(4));
                transaction.setFicheVehicule(new FicheVehicule(""));
                transaction.getFicheVehicule().setModele(new Modele(0));
                transaction.getFicheVehicule().getModele().setMarque(new Marque(rs.getString(5)));

                transactions.add(transaction);
            }
        }
        catch (SQLException e){
            throw new GetTransactionException();
        }
        return transactions;
    }
}
