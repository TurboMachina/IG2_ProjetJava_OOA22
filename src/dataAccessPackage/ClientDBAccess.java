package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class ClientDBAccess implements ClientDataAccess {

    public Client getClient(Integer idClient) throws ConnectionException, GetClientException {
        Connection connection = SingletonConnection.getConnexion();
        Client client = new Client(idClient);
        try{
            String query = "SELECT nom, prenom, numTel, email FROM dbprojet.clients WHERE idClient = ?";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1,idClient);
            ResultSet rs = prepStat.executeQuery();
            client.setNom(rs.getString(1));
            client.setPrenom(rs.getString(2));
            client.setNumeroTel(rs.getString(3));
            client.setAdresseMail(rs.getString(4));
        }
        catch (SQLException e){
            throw new GetClientException();
        }
        return client;
    }

    public ArrayList<Client> getAllClients() throws ConnectionException, GetClientException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Client> listeClients = new ArrayList<>();
        try{
            String query = "SELECT * FROM dbprojet.clients";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Client tempClient;
            while(rs.next()){
                tempClient = new Client(rs.getInt(1));
                tempClient.setNom(rs.getString(2));
                tempClient.setPrenom(rs.getString(3));
                tempClient.setNumeroTel(rs.getString(4));
                tempClient.setAdresseMail(rs.getString(5));
                listeClients.add(tempClient);
            }
        }
        catch (SQLException e){
            throw new GetClientException();
        }
        return listeClients;
    }

    public ArrayList<Client> getAllLinkedClients() throws ConnectionException, GetClientException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Client> listeClients = new ArrayList<>();
        try{
            String query = "SELECT * FROM dbprojet.clients INNER JOIN dbprojet.transactions ON clients.idClient = transactions.idClient ";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Client tempClient;
            while(rs.next()){
                tempClient = new Client(rs.getInt(1));
                tempClient.setNom(rs.getString(2));
                tempClient.setPrenom(rs.getString(3));
                tempClient.setNumeroTel(rs.getString(4));
                tempClient.setAdresseMail(rs.getString(5));
                listeClients.add(tempClient);
            }
        }
        catch (SQLException e){
            throw new GetClientException();
        }
        return listeClients;
    }
}
