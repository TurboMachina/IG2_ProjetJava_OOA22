package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class MagasinDBAccess implements MagasinDataAccess {

    public Magasin getMagasin(Integer idMagasin) throws ConnectionException, GetMagasinException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }

    public ArrayList<Magasin> getAllMagasins() throws ConnectionException, GetMagasinException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }
}
