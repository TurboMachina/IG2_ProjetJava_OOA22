package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface MarqueDataAccess {
    Marque getMarque(String libelleMarque) throws ConnectionException, GetMarqueException;
    ArrayList<Marque> getAllMarques() throws ConnectionException, GetMarqueException;
}
