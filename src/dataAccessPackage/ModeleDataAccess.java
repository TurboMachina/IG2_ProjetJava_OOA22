package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface ModeleDataAccess {
    Modele getModele(Integer idModele);
    ArrayList<Modele> getAllModeles();
    void ajouteModele(Modele newModele);
    void updateModele(Modele upModele);
    void deleteModele(Modele modele);
}
