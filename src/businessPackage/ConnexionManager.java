package businessPackage;

import dataAccessPackage.DAO;
import dataAccessPackage.DBDAO;
import exceptionPackage.*;
import javafx.beans.property.DoublePropertyBase;
import modelPackage.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class ConnexionManager {
    DAO dao;

    public ConnexionManager(){
        setDao(new DBDAO());
    }

    public void setDao(DAO dao){
        this.dao = dao;
    }

    public void closeConnexion() throws Exception{
            dao.closeConnexion();
    }

    public ArrayList<Transaction> getAllTransactions() throws Exception {
        return dao.getAllTransactions();
    }
}
