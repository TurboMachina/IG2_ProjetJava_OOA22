package controllerPackage;


import businessPackage.StatistiqueManager;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetMarqueException;
import exceptionPackage.GetTransactionException;

public class StatistiqueController {
    private StatistiqueManager manager;

    private void setManager(StatistiqueManager manager) {
        this.manager = manager;
    }

    public String getStatistiques() throws ConnectionException, GetTransactionException, GetMarqueException {
        setManager(new StatistiqueManager());
        return manager.getStatistiques();
    }

}
