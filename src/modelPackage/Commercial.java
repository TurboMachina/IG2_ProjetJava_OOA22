package modelPackage;

import java.util.ArrayList;

public class Commercial {
    private String nom, prenom, adresseMail;
    private int numeroTel;
    private Magasin magasin;
    private ArrayList<Transaction> transactions;

    public Commercial(String nom, String prenom, String adresseMail, int numeroTel) {
        setNom(nom);
        setPrenom(prenom);
        setAdresseMail(adresseMail);
        setNumeroTel(numeroTel);
        this.transactions = new ArrayList<>();
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
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
