package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface FicheVehiculeDataAccess {
    ArrayList<FicheVehicule> getAllNumChassis() throws ConnectionException, GetFicheVehException;
}
