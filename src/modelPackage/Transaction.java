package modelPackage;

import java.util.GregorianCalendar;

public class Transaction {
    private int kilometrage, prixAchat, prixDepart, prixMin, nbProprios, dureeGarantie, prixVente;
    private String etat, couleur, description;
    private boolean estTVARecup;
    private GregorianCalendar dateArrivee, dateVente;

    public Transaction(int kilometrage, int prixAchat, int prixDepart, int prixMin, int nbProprios, int dureeGarantie, int prixVente, String couleur, String description, boolean estTVARecup, GregorianCalendar dateArrivee, GregorianCalendar dateVente) {
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
}
