package modelPackage;

public class Commercial {
    private String nom, prenom, adresseMail;
    private int numeroTel;
    private Magasin magasin;

    public Commercial(String nom, String prenom, String adresseMail, int numeroTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.numeroTel = numeroTel;
    }
}
