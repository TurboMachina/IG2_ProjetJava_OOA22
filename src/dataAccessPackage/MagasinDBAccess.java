package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class MagasinDBAccess implements MagasinDataAccess {

    public ArrayList<Magasin> getAllMagasins() throws ConnectionException, GetMagasinException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<Magasin> magasins = new ArrayList<>();
        try{
            String query = "SELECT magasin.idMagasin, magasin.libelle FROM dbprojet.magasin";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            Magasin magasin;
            while (rs.next()){
                magasin = new Magasin(rs.getInt(1));
                magasin.setNom(rs.getString(2));
                magasins.add(magasin);
            }
        }
        catch (SQLException e){
            throw new GetMagasinException();
        }
        return magasins;
    }
}
