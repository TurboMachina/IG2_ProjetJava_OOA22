package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.*;

public class DBDAO implements DAO {

    public DBDAO() {}

    @Override
    public void closeConnexion() throws Exception{
        Connection connection = SingletonConnexion.getConnexion();
        connection.close();
    }

    public ArrayList<Transaction> getAllTransactions() throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        ArrayList<Transaction> allTransactions = new ArrayList<>();
        try{
            String query = "SELECT * FROM projetdb.transactions";
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

                transaction.setCommercial(new Commercial(rs.getInt(15)));
                transaction.setFicheVehicule(new FicheVehicule(rs.getString(16)));
                transaction.setClient(new Client(rs.getInt(17)));

                prixMin = rs.getFloat(6) ;
                if (!rs.wasNull())
                    transaction.setPrixMin(prixMin);
                nbProprios = rs.getInt(7);
                if(!rs.wasNull())
                    transaction.setNbProprios(nbProprios);
                description = rs.getString(8);
                if(!rs.wasNull())
                    transaction.setDescription(description);



                allTransactions.add(transaction);
            }
        }
        catch (SQLException e){
            throw new AllTransactionsException();
        }

    return allTransactions;
    }

    public Commercial getCommercial(Integer matriculeCom) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        Commercial commercial;
        try{
            String query = "";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
        }
        catch (SQLException e){

        }
        return commercial;
    }

    public FicheVehicule getFicheVeh(String numChassisVeh) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        FicheVehicule ficheVehicule;
        try{
            String query = "";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
        }
        catch (SQLException e){

        }
        return ficheVehicule;
    }

    public Magasin getMagasin(Integer idMag) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        Magasin magasin;
        try{
            String query = "";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
        }
        catch (SQLException e){

        }
        return magasin;
    }

    public Modele getModele(Integer idMod) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        Modele modele;
        try{
            String query = "";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
        }
        catch (SQLException e){

        }
        return modele;
    }

    public Marque getMarque(String libelleMarque) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        Marque marque;
        try{
            String query = "";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
        }
        catch (SQLException e){

        }
        return marque;
    }
}
