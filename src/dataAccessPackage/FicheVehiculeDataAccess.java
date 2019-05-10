package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface FicheVehiculeDataAccess {
    FicheVehicule getFicheVeh(String numChassisFiche);
    ArrayList<FicheVehicule> getAllFichesVeh();
    void ajouteFicheVeh(FicheVehicule newFicheVeh);
    void updateFicheVeh(FicheVehicule upFicheVeh);
    void deleteFicheVeh(FicheVehicule ficheVeh);
}
