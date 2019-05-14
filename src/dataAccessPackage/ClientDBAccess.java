package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class ClientDBAccess implements ClientDataAccess {

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
}
