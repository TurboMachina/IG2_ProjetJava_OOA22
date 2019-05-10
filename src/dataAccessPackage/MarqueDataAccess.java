package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface MarqueDataAccess {
    Marque getMarque(String libelleMarque);
    ArrayList<Marque> getAllMarques();
}
