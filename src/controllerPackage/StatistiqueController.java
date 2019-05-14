package controllerPackage;


import exceptionPackage.*;
import modelPackage.*;
import viewPackage.*;
import businessPackage.*;

public class StatistiqueController {
    private StatistiqueManager manager;

    private void setManager(StatistiqueManager manager) {
        this.manager = manager;
    }

    public String getStatistiques() throws ConnectionException, GetTransactionException, GetMarqueException{
        setManager(new StatistiqueManager());
        return manager.getStatistiques();
    }

}
