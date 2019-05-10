package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface ModeleDataAccess {
    Modele getModele(Integer idModele) throws ConnectionException, GetModeleException;
    ArrayList<Modele> getAllModeles() throws ConnectionException, GetModeleException;
}
