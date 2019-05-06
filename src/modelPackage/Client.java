package modelPackage;

public class Client {
    private static int id = 0;
    private String nom, prenom, adresse;
    public Client(String n, String p, String a){
        nom = n;
        prenom = p;
        adresse = a;
        final int idClient = setId();
    }
    private int setId(){
        id++;
        return id+1;
    }
}
