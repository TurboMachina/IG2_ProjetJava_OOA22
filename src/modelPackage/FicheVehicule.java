package modelPackage;

import java.util.*;

public class FicheVehicule {
    private String numChassis;
    private GregorianCalendar dateMiseCircu;
    private ArrayList<Transaction> transactions;
    private Modele modele;
    public FicheVehicule(String numChassis){
        setNumChassis(numChassis);
    }

    public void setNumChassis(String numChassis) {
        this.numChassis = numChassis;
    }

    public String getNumChassis(){return this.numChassis;}

    public void setDateMiseCircu(GregorianCalendar dateMiseCircu) {
        this.dateMiseCircu = dateMiseCircu;
    }

    public void setModele(Modele modele) {
        modele.ajouteFicheVehicule(this);
        this.modele = modele;
    }

    public void ajouteTransaction(Transaction newTransaction){
        transactions.add(newTransaction);
        newTransaction.setFicheVehicule(this);
    }
    public Transaction getTransaction(int index){
        return transactions.get(index);
    }
}
