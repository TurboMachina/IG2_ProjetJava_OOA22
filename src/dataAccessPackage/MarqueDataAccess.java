package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface MarqueDataAccess {
    ArrayList<Marque> getAllMarques() throws ConnectionException, GetMarqueException;
}
