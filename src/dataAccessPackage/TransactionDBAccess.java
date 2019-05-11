package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TransactionDBAccess implements TransactionDataAccess {

    public Transaction getTransaction(Integer idTransaction) throws ConnectionException, GetTransactionException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }

    public ArrayList<Transaction> getAllTransactions() throws ConnectionException, GetTransactionException {
        Connection connexion = SingletonConnection.getConnexion();
        ArrayList<Transaction> allTransactions = new ArrayList<>();
        try{
            String query = "SELECT * FROM dbprojet.transactions\n" +
                    "    LEFT JOIN dbprojet.clients c on transactions.idClient = c.idClient\n" +
                    "    LEFT JOIN dbprojet.commercial c2 on transactions.matricule = c2.matricule\n" +
                    "    LEFT JOIN dbprojet.fichevehicule f on transactions.numChassis = f.numChassis";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();

            Transaction transaction;
            Float prixMin;
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
                transaction = new Transaction(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        cal1,
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getFloat(12),
                        cal2,
                        rs.getString(14)
                );
                prixMin = rs.getFloat(6) ;
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

    public void ajouteTransactions(Transaction newTransaction) throws ConnectionException, AddTransactionException{
        Connection connection = SingletonConnection.getConnexion();
    }

    public void updateTransaction(Transaction upTransaction) throws ConnectionException, UpdateTransactionException{
        Connection connection = SingletonConnection.getConnexion();
    }

    public void deleteTransaction(Transaction transaction) throws ConnectionException, DeleteTransactionException{
        Connection connection = SingletonConnection.getConnexion();
    }
}
