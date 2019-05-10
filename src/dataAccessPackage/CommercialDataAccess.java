package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface CommercialDataAccess {
    Commercial getCommercial(Integer matriculeCom);
    ArrayList<Commercial> getAllCommerciaux();
}
