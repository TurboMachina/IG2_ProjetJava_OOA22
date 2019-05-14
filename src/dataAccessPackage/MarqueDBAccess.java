package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class MarqueDBAccess implements MarqueDataAccess {

    public ArrayList<Marque> getAllMarques() throws ConnectionException, GetMarqueException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Marque> marques = new ArrayList<>();
        try{
            String query = "SELECT marque.libelle FROM dbprojet.marque ORDER BY libelle ASC";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Marque marque;
            while (rs.next()){
                marque = new Marque(rs.getString(1));
                marques.add(marque);
            }
        }
        catch (SQLException e){
            throw new GetMarqueException();
        }
        return marques;
    }
}
