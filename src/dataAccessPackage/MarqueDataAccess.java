package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface MarqueDataAccess {
    Marque getMarque(String libelleMarque);
    ArrayList<Marque> getAllMarques();
    void ajouteMarque(Marque newMarque);
    void updateMarque(Marque upMarque);
    void deleteMarque(Marque marque);
}
