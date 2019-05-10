package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class ModeleDBAccess implements ModeleDataAccess {

    public Modele getModele(Integer idModele) throws ConnectionException, GetModeleException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }

    public ArrayList<Modele> getAllModeles() throws ConnectionException, GetModeleException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }
}
