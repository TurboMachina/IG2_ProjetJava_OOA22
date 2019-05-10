package dataAccessPackage;

import modelPackage.*;

import java.util.ArrayList;

public interface MagasinDataAccess {
    Magasin getMagasin(Integer idMagasin);
    ArrayList<Magasin> getAllMagasins();
    void ajouteMagasin(Magasin newMagasin);
    void updateMagasin(Magasin upMagasin);
    void deleteMagasin(Magasin magasin);
}
