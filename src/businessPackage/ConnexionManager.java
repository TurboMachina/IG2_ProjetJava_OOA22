package businessPackage;

import dataAccessPackage.DAO;
import dataAccessPackage.DBDAO;
import exceptionPackage.*;

import java.sql.SQLException;

public class ConnexionManager {
    private DAO dao;

    public ConnexionManager(){

    }

    private void setDAO(DAO dao){
        this.dao = new DBDAO();
    }

    public void closeConnexion() throws SQLException{
            dao.closeConnexion();
    }

    public void verifierMatricule(String matricule) throws MatriculeException{
        dao.verifierMatricule(matricule);
    }
}
