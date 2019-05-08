package modelPackage;

import java.util.ArrayList;

public class Commercial {
    private String nom, prenom, adresseMail;
    private int numeroTel;
    private Magasin magasin;
    private ArrayList<Transaction> transactions;

    public Commercial(String nom, String prenom, String adresseMail, int numeroTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.numeroTel = numeroTel;
        this.transactions = new ArrayList<>();
    }
    public void setMagasin(Magasin newMagasin){
        this.magasin = newMagasin;
        newMagasin.ajouteCommercial(this);
    }
    public void ajouteTransactions(Transaction newTransaction){
        transactions.add(newTransaction);
        newTransaction.setCommercial(this);
    }

    public Transaction getTransactions(int index) {
        return transactions.get(index);
    }
}
