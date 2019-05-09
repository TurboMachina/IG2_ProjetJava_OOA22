package dataAccessPackage;

import exceptionPackage.*;

import java.sql.SQLException;

public interface DAO {
    void closeConnexion() throws SQLException;
    void verifierMatricule(String matricule) throws MatriculeException;
}
