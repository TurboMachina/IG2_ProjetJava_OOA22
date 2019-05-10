package modelPackage;
import java.util.ArrayList;

public class Client {
    private String nom, prenom, adresseMail;
    private Integer id,numeroTel;
    private ArrayList<Transaction> transactions;

    public Client(Integer id,String nom, String prenom, String adresseMail, Integer numeroTel) {
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

    public void setNumeroTel(Integer numeroTel) {
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
