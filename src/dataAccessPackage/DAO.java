package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO {
    void closeConnexion() throws Exception;
    ArrayList<Transaction> getAllTransactions() throws Exception;
    Commercial getCommercial(Integer matriculeCom) throws Exception;
    FicheVehicule getFicheVeh(String numChassisVeh) throws Exception;
    Magasin getMagasin(Integer idMag) throws Exception;
    Modele getModele(Integer idMod) throws Exception;
    Marque getMarque(String libelleMarque) throws Exception;


}
