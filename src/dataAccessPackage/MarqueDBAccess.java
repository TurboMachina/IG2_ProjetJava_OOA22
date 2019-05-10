package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class MarqueDBAccess implements MarqueDataAccess {

    public Marque getMarque(String libelleMarque) throws ConnectionException, GetMarqueException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }

    public ArrayList<Marque> getAllMarques() throws ConnectionException, GetMarqueException{
        Connection connection = SingletonConnection.getConnexion();
        return null;
    }
}
