package modelPackage;

import java.util.ArrayList;

public class Client {
    private String nom, prenom, adresseMail,numeroTel;
    private Integer id;
    private ArrayList<Transaction> transactions;

    public Client(Integer id) {

        this.transactions = new ArrayList<>();
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){ return this.id; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void ajouteTransaction(Transaction newTransaction) {
        transactions.add(newTransaction);
        newTransaction.setClient(this);
    }

    public Transaction getTransaction(Integer index) {
        return transactions.get(index);
    }
}
