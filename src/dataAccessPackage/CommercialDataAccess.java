package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface CommercialDataAccess {
    Commercial getCommercial(Integer matriculeCom);
    ArrayList<Commercial> getAllCommerciaux();
    void ajouteCommercial(Commercial newCommercial);
    void updateCommercial(Commercial upCommercial);
    void deleteCommercial(Commercial commercial);
}
