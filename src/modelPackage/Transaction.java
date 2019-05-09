package modelPackage;

import java.util.GregorianCalendar;

public class Transaction {
    private int id, kilometrage, prixAchat, prixDepart, prixMin, nbProprios, dureeGarantie, prixVente;
    private String etat, couleur, description;
    private boolean estTVARecup;
    private GregorianCalendar dateArrivee, dateVente;
    private Client client;
    private FicheVéhicule ficheVéhicule;
    private Commercial commercial;

    public Transaction(int id, Client client, FicheVéhicule ficheVéhicule, Commercial commercial,int kilometrage, int prixAchat, int prixDepart, int prixMin, int nbProprios, int dureeGarantie, int prixVente, String couleur, String description, boolean estTVARecup, GregorianCalendar dateArrivee, GregorianCalendar dateVente) {
        this.id = id;
        this.client = client;
        this.ficheVéhicule = ficheVéhicule;
        this.commercial = commercial;
        this.kilometrage = kilometrage;
        this.prixAchat = prixAchat;
        this.prixDepart = prixDepart;
        this.prixMin = prixMin;
        this.nbProprios = nbProprios;
        this.dureeGarantie = dureeGarantie;
        this.prixVente = prixVente;
        this.couleur = couleur;
        this.description = description;
        this.estTVARecup = estTVARecup;
        this.dateArrivee = dateArrivee;
        this.dateVente = dateVente;

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        client.ajouteTransaction(this);
    }

    public FicheVéhicule getFicheVéhicule() {
        return ficheVéhicule;
    }

    public void setFicheVéhicule(FicheVéhicule ficheVéhicule) {
        this.ficheVéhicule = ficheVéhicule;
        ficheVéhicule.ajouteTransaction(this);
    }

    public Commercial getCommercial() {
        return commercial;
    }

    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
        commercial.ajouteTransactions(this);
    }
}
