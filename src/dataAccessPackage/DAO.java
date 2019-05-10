package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO {
    void closeConnexion() throws Exception;
    ArrayList<Transaction> getAllTransactions() throws Exception;
    Client getClient(Integer id) throws Exception;
    Commercial getCommercial(Integer idCommercial) throws Exception;
    Magasin getMagasin(Integer idMagasin) throws Exception;
    FicheVehicule getFicheVeh(String numChassis) throws Exception;
    void getAllMarque() throws Exception;
    ArrayList<Modele> getAllModeleFromMarque(String marque) throws Exception;

}
