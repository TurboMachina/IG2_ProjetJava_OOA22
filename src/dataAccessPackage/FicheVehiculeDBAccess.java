package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class FicheVehiculeDBAccess implements FicheVehiculeDataAccess {

    public ArrayList<FicheVehicule> getAllNumChassis() throws ConnectionException, GetFicheVehException{
        Connection connection = SingletonConnection.getConnexion();
        ArrayList<FicheVehicule> listeNumChassis = new ArrayList<>();
        try{
            String query = "SELECT numChassis FROM dbprojet.fichevehicule";
            PreparedStatement prepStat = connection.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            FicheVehicule tempFiche;
            while(rs.next()){
                tempFiche = new FicheVehicule(rs.getString(1));
                listeNumChassis.add(tempFiche);
            }

        }
        catch (SQLException e){
            throw new GetFicheVehException();
        }
        return listeNumChassis;
    }
}
