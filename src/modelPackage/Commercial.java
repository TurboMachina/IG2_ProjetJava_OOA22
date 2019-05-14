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

    public String getNom(){
        return this.nom + " " + this.prenom;
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
