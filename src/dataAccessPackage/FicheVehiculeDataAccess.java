package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface FicheVehiculeDataAccess {
    FicheVehicule getFicheVeh(String numChassisFiche) throws ConnectionException, GetFicheVehException;
    ArrayList<FicheVehicule> getAllFichesVeh() throws ConnectionException, GetFicheVehException;
}
