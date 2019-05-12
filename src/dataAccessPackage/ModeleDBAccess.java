package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class ModeleDBAccess implements ModeleDataAccess {
    public ArrayList<Modele> getAllModeles() throws ConnectionException, GetModeleException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Modele> modeles = new ArrayList<>();
        try{
            String query = "SELECT modele.idModele, modele.libelle, modele.App_libelle  FROM dbprojet.modele";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Modele modele;
            while (rs.next()){
                modele = new Modele(rs.getInt(1));
                modele.setLibelle(rs.getString(2));
                modele.setMarque(new Marque(rs.getString(3)));
                modeles.add(modele);
            }
        }
        catch (SQLException e){
            throw new GetModeleException();
        }
        return modeles;
    }
}
