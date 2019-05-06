package modelPackage;

public class Client {
    private String nom, prenom, adresse, adresseMail;
    private int numeroTel;
    private Transaction [] transactions;

    public Client(String nom, String prenom, String adresse, String adresseMail, int numeroTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.numeroTel = numeroTel;
    }
}
