package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class FicheVehiculeDBAccess implements FicheVehiculeDataAccess {

    public FicheVehicule getFicheVeh(String numChassisFiche) throws ConnectionException, GetFicheVehException{
        Connection connection = SingletonConnection.getConnexion();
        FicheVehicule ficheVehicule = new FicheVehicule(numChassisFiche);
        try{
            String query = "SELECT dateMiseCircu, idModele FROM dbprojet.fichevehicule WHERE numChassis = ?";
            PreparedStatement prepStat = connection.prepareStatement(query);
            prepStat.setString(1,numChassisFiche);
            ResultSet rs = prepStat.executeQuery();
            // A finir

        }
        catch (SQLException e){
            throw new GetFicheVehException();
        }
        return ficheVehicule;
    }

    public ArrayList<FicheVehicule> getAllFichesVeh() throws ConnectionException, GetFicheVehException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }
}
