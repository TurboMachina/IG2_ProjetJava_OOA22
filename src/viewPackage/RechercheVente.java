package viewPackage;

import controllerPackage.TransactionController;

import javax.swing.*;

public class RechercheVente extends JPanel {
    private TransactionController controller;
    private PrincipalWindow w;

    public RechercheVente(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }

}
