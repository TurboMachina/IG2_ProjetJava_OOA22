package modelPackage;
import java.util.ArrayList;

public class Client {
    private String nom, prenom, adresse, adresseMail;
    private int numeroTel;
    private ArrayList<Transaction> transactions;

    public Client(String nom, String prenom, String adresse, String adresseMail, int numeroTel) {
        setNom(nom);
        setPrenom(prenom);
        setAdresse(adresse);
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

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void ajouteTransaction(Transaction newTransaction) {
        transactions.add(newTransaction);
        newTransaction.setClient(this);
    }

    public Transaction getTransaction(int index) {
        return transactions.get(index);
    }
}
