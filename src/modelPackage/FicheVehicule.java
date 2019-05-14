package modelPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FicheVehicule {
    private String numChassis;
    private GregorianCalendar dateMiseCircu;
    private ArrayList<Transaction> transactions;
    private Modele modele;


    public FicheVehicule(String numChassis){
        setNumChassis(numChassis);
        transactions = new ArrayList<>();
    }

    public void setNumChassis(String numChassis) {
        this.numChassis = numChassis;
    }

    public String getNumChassis(){return this.numChassis;}

    public void setDateMiseCircu(GregorianCalendar dateMiseCircu) {
        this.dateMiseCircu = dateMiseCircu;
    }

    public String getDateMiseCircu(){
        SimpleDateFormat temp = new SimpleDateFormat("dd-MM-YYYY");
        temp.setCalendar(this.dateMiseCircu);
        return temp.format(this.dateMiseCircu.getTime());
    }

    public void setModele(Modele modele) {
        modele.ajouteFicheVehicule(this);
        this.modele = modele;
    }

    public Modele getModele(){
        return this.modele;
    }

    public void ajouteTransaction(Transaction newTransaction){
        transactions.add(newTransaction);
    }

    @Override
    public String toString(){
        return this.getNumChassis();
    }
}
