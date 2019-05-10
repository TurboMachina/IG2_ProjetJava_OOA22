package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO {
    void closeConnexion() throws Exception;
    ArrayList<Transaction> getAllTransactions() throws Exception;
}
