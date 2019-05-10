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
        getAllMarque();
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

                prixMin = rs.getFloat(6) ;
                if (!rs.wasNull())
                    transaction.setPrixMin(prixMin);
                nbProprios = rs.getInt(7);
                if(!rs.wasNull())
                    transaction.setNbProprios(nbProprios);
                description = rs.getString(8);
                if(!rs.wasNull())
                    transaction.setDescription(description);

                transaction.setCommercial(getCommercial(rs.getInt(15)));
                transaction.setFicheVehicule(getFicheVeh(rs.getString(16)));
                transaction.setClient(getClient(rs.getInt(17)));
                allTransactions.add(transaction);
            }
        }
        catch (SQLException e){
            throw new AllTransactionsException();
        }

    return allTransactions;
    }

    public Client getClient(Integer id) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        Client client;
        try{
            String query = "SELECT * FROM dbprojet.client WHERE idClient = ?";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            prepStat.setInt(1, id);
            ResultSet rs = prepStat.executeQuery();
            client = new Client(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5)
                    );
        }
        catch (SQLException e){
            throw new ClientException();
        }
        return client;
    }

    public Commercial getCommercial(Integer idCommercial) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        Commercial commercial;
        try{
            String query = "SELECT * FROM dbprojet.commercial WHERE matricule = ?";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            prepStat.setInt(1, idCommercial);
            ResultSet rs = prepStat.executeQuery();
            commercial = new Commercial(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            );
            commercial.setMagasin(getMagasin(rs.getInt(5)));
        }
        catch (SQLException e){
            throw new ClientException();
        }
        return commercial;
    }

    public Magasin getMagasin(Integer id) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        Magasin magasin;
        try{
            String query = "SELECT * FROM dbprojet.magasin WHERE idMagasin = ?";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            prepStat.setInt(1, id);
            ResultSet rs = prepStat.executeQuery();
            magasin = new Magasin(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            );
        }
        catch (SQLException e){
            throw new ClientException();
        }
        return magasin;
    }

    public FicheVehicule getFicheVeh(String numChassis) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        FicheVehicule ficheveh;
        ArrayList<Marque> listeMarques = ListeMarque.getListeMarques();
        try{
            String query = "SELECT * FROM dbprojet.client WHERE numChassis = ?";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            prepStat.setString(1, numChassis);
            ResultSet rs = prepStat.executeQuery();
            java.sql.Date date;
            date = rs.getDate(2);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);

            int i = 0;
            Integer idToFind = rs.getInt(3);
            boolean modeleTrouve = false;
            Marque marque;
            Modele modeleSave = null;
            while (i < listeMarques.size() && !modeleTrouve){
                marque = listeMarques.get(i);
                ArrayList<Modele> modeles = marque.getModeles();
                for (Modele modele : modeles){
                    if (modele.getID().equals(idToFind)){
                        modeleTrouve = true;
                        modeleSave = modele;
                    }
                }
                i++;
            }

            ficheveh = new FicheVehicule(
                    rs.getString(1),
                    cal,
                    modeleSave
            );
        }
        catch (SQLException e){
            throw new ClientException();
        }
        return ficheveh;
    }

    public void getAllMarque() throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        ArrayList<Marque> listeMarques = ListeMarque.getListeMarques();
        try{
            String query = "SELECT * FROM projetdb.marque";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Marque marque;
            ArrayList<Modele> modeles;
            while (rs.next()){
                marque = new Marque(rs.getString(1));
                modeles = getAllModeleFromMarque(marque.getLibelle());
                for (Modele modele : modeles){
                    marque.ajouteModele(modele);
                }
                listeMarques.add(marque);
            }
        }
        catch (SQLException e){
            throw new AllTransactionsException();
        }
    }

    public ArrayList<Modele> getAllModeleFromMarque(String marque) throws Exception{
        Connection connexion = SingletonConnexion.getConnexion();
        ArrayList<Modele> modeles = new ArrayList<>();
        try{
            String query = "SELECT * FROM projetdb.modele WHERE App_libelle = ?";
            PreparedStatement prepStat = connexion.prepareStatement(query);
            prepStat.setString(1, marque);
            ResultSet rs = prepStat.executeQuery();
            Modele modele;
            while (rs.next()){
                modele = new Modele(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getFloat(9),
                        rs.getFloat(10),
                        rs.getFloat(11),
                        rs.getInt(12)
                );
                modeles.add(modele);
            }
        }
        catch (SQLException e){
            throw new AllTransactionsException();
        }
        return modeles;
    }
}
