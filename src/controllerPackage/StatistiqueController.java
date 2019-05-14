package controllerPackage;


import exceptionPackage.*;
import modelPackage.*;
import viewPackage.*;
import businessPackage.*;

public class StatistiqueController {
    private StatistiqueManager manager;

    public StatistiqueController() throws ConnectionException, GetTransactionException {
        setManager(new StatistiqueManager());
    }

    private void setManager(StatistiqueManager manager) {
        this.manager = manager;
    }

    public String getResultats() throws ConnectionException, GetTransactionException, GetMarqueException {
        return manager.getResultats();
    }
}
