package viewPackage;

import controllerPackage.TransactionController;
import modelPackage.Magasin;
import modelPackage.Transaction;

import javax.swing.*;

public class RechercheModele extends JPanel {
    private TransactionController controller;
    private PrincipalWindow w;

    public RechercheModele(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }

}
