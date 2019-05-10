package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface MagasinDataAccess {
    Magasin getMagasin(Integer idMagasin);
    ArrayList<Magasin> getAllMagasins();
}
