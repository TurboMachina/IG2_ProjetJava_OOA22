package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface MagasinDataAccess {
    ArrayList<Magasin> getAllMagasins() throws ConnectionException, GetMagasinException;
}
