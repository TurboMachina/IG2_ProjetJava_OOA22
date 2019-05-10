package modelPackage;

import java.util.*;

public class FicheVehicule {
    private long numChassis;
    private GregorianCalendar dateMiseCircu;
    private ArrayList<Transaction> transactions;
    private Modele modele;
    public FicheVehicule(long numChassis, GregorianCalendar dateMiseCircu, Modele modele){
        setNumChassis(numChassis);
        setDateMiseCircu(dateMiseCircu);
        setModele(modele);
    }

    private void setNumChassis(long numChassis) {
        this.numChassis = numChassis;
    }

    private void setDateMiseCircu(GregorianCalendar dateMiseCircu) {
        this.dateMiseCircu = dateMiseCircu;
    }

    private void setModele(Modele modele) {
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
