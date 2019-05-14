package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class CommercialDBAccess implements CommercialDataAccess {

    public ArrayList<Commercial> getAllCommerciaux() throws ConnectionException, GetCommercialException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Commercial> listeCommerciaux = new ArrayList<>();
        try{
            String query = "SELECT * FROM dbprojet.commercial";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Commercial tempCommercial;
            while(rs.next()){
                tempCommercial = new Commercial(rs.getInt(1));
                tempCommercial.setNom(rs.getString(2));
                tempCommercial.setPrenom(rs.getString(3));
                tempCommercial.setNumeroTel(rs.getString(4));
                tempCommercial.setAdresseMail(rs.getString(5));
                tempCommercial.setMagasin(new Magasin(rs.getInt(6)));
                listeCommerciaux.add(tempCommercial);
            }
        }
        catch (SQLException e){
            throw new GetCommercialException();
        }
        return listeCommerciaux;
    }
}
