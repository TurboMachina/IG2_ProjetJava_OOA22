package businessPackage;

import dataAccessPackage.DAO;
import dataAccessPackage.DBDAO;

public class ConnexionManager {
    private DAO dao;

    public ConnexionManager(){

    }

    private void setDAO(DAO dao){
        this.dao = new DBDAO();
    }

    public void closeConnexion() throws Exception{
            dao.closeConnexion();
    }
}
