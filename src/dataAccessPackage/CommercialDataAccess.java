package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface CommercialDataAccess {
    Commercial getCommercial(Integer matriculeCom) throws ConnectionException, GetCommercialException;
    ArrayList<Commercial> getAllCommerciaux()  throws ConnectionException, GetCommercialException;
}
