package modelPackage;

import java.util.ArrayList;

public class Commercial {
    private String nom, prenom, adresseMail,numeroTel;
    private Integer matricule;
    private Magasin magasin;
    private ArrayList<Transaction> transactions;

    public Commercial(Integer matricule) {
        setMatricule(matricule);
        this.transactions = new ArrayList<>();
    }

    private void setMatricule(Integer matricule){ this.matricule = matricule; }

    public Integer getMatricule(){return this.matricule;}

    public void setNom(String nom) {
        this.nom = nom.toLowerCase();
    }

    public String getNom(){
        return this.nom.substring(0, 1).toUpperCase() + this.nom.substring(1) + " " + this.prenom.substring(0, 1).toUpperCase() + this.prenom.substring(1);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom.toLowerCase();
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail.toLowerCase();
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void setMagasin(Magasin newMagasin){
        this.magasin = newMagasin;
    }
    public void ajouteTransactions(Transaction newTransaction){
        transactions.add(newTransaction);
    }

    @Override
    public String toString(){
        return this.getNom();
    }
}
