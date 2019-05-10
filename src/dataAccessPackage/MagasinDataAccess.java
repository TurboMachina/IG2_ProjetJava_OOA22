package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface MagasinDataAccess {
    Magasin getMagasin(Integer idMagasin) throws ConnectionException, GetMagasinException;
    ArrayList<Magasin> getAllMagasins() throws ConnectionException, GetMagasinException;
}
