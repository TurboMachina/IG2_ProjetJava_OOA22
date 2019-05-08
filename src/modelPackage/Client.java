package modelPackage;
import java.util.ArrayList;

public class Client {
    private String nom, prenom, adresse, adresseMail;
    private int numeroTel;
    private ArrayList<Transaction> transactions;

    public Client(String nom, String prenom, String adresse, String adresseMail, int numeroTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.numeroTel = numeroTel;
        this.transactions = new ArrayList<>();
    }

    public void ajouteTransaction(Transaction newTransaction) {
        transactions.add(newTransaction);
        newTransaction.setClient(this);
    }

    public Transaction getTransaction(int index) {
        return transactions.get(index);
    }
}
