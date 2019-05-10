package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class CommercialDBAccess implements CommercialDataAccess {

    public Commercial getCommercial(Integer matriculeCom)  throws ConnectionException, GetCommercialException {
        Connection connection = SingletonConnection.getConnexion();
        Commercial commercial = new Commercial(matriculeCom);
        try{
            String query = "SELECT nom, prenom, numTel, email FROM dbprojet.commercial WHERE matricule = ?";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setInt(1,matriculeCom);
            ResultSet rs = prepStat.executeQuery();
            commercial.setNom(rs.getString(1));
            commercial.setPrenom(rs.getString(2));
            commercial.setNumeroTel(rs.getString(3));
            commercial.setAdresseMail(rs.getString(4));
            commercial.setMagasin(new Magasin(rs.getInt(5)));
        }
        catch (SQLException e){
            throw new GetCommercialException();
        }
        return commercial;
    }

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
