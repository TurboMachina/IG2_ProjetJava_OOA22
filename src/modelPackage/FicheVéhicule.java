package modelPackage;

import java.util.*;

public class FicheVéhicule {
    private long numChassis;
    private GregorianCalendar dateMiseCircu;
    private ArrayList<Transaction> transactions;
    private Modèle modèle;
    public FicheVéhicule(long numChassis, int jour, int mois, int annee, Modèle modèle){
        this.numChassis = numChassis;
        dateMiseCircu = setDateMiseCircu(jour, mois, annee);
        this.modèle = setModèle(modèle);
    }
    public GregorianCalendar setDateMiseCircu(int jour, int mois, int annee){
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.DAY_OF_MONTH,jour);
        gc.set(Calendar.MONTH, mois);
        gc.set(Calendar.YEAR,annee);
        return gc;
    }
    private Modèle setModèle(Modèle modèle){
        return modèle; // ici on doit rajouter le modèle dans le tableau modeles de Marque mais seulement si le modèle n'y est pas encore présent
    }
    public void ajouteTransaction(Transaction newTransaction){
        transactions.add(newTransaction);
        newTransaction.setFicheVéhicule(this);
    }
    public Transaction getTransaction(int index){
        return transactions.get(index);
    }
}
