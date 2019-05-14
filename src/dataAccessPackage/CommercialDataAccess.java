package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface CommercialDataAccess {
    ArrayList<Commercial> getAllCommerciaux()  throws ConnectionException, GetCommercialException;
}
