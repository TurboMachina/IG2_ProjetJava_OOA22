package modelPackage;

import java.util.ArrayList;

public class Client {
    private String nom, prenom, adresseMail,numeroTel;
    private Integer id;
    private ArrayList<Transaction> transactions;

    public Client(Integer id) {
        this.transactions = new ArrayList<>();
        setId(id);
    }

    private void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){ return this.id; }

    public void setNom(String nom) {
        this.nom = nom.toLowerCase();
    }

    public String getNom(){return this.nom.substring(0, 1).toUpperCase() + this.nom.substring(1) + " " + this.prenom.substring(0, 1).toUpperCase() + this.prenom.substring(1);}

    public void setPrenom(String prenom) {
        this.prenom = prenom.toLowerCase();
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail.toLowerCase();
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void ajouteTransaction(Transaction newTransaction) {
        transactions.add(newTransaction);
    }

    @Override
    public String toString(){
        return this.getNom();
    }
}
