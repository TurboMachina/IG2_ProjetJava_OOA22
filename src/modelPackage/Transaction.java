package modelPackage;

import java.util.GregorianCalendar;

public class Transaction {
    private Integer id, kilometrage, nbProprios, dureeGarantie;
    private Float prixAchat, prixVente, prixMin, prixDepart;
    private String etat, couleur, description;
    private boolean estTVARecup;
    private GregorianCalendar dateArrivee, dateVente;
    private Client client;
    private FicheVehicule ficheVehicule;
    private Commercial commercial;

    public Transaction(Integer id) {
         setId(id);
    }

    public Integer getId() {
        return id;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public Integer getNbProprios() {
        return nbProprios;
    }

    public Integer getDureeGarantie() {
        return dureeGarantie;
    }

    public Float getPrixAchat() {
        return prixAchat;
    }

    public Float getPrixVente() {
        return prixVente;
    }

    public Float getPrixMin() {
        return prixMin;
    }

    public Float getPrixDepart() {
        return prixDepart;
    }

    public String getEtat() {
        return etat;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEstTVARecup() {
        return estTVARecup;
    }

    public GregorianCalendar getDateArrivee() {
        return dateArrivee;
    }

    public GregorianCalendar getDateVente() {
        return dateVente;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setDureeGarantie(Integer dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    public void setPrixAchat(Float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public void setPrixVente(Float prixVente) {
        this.prixVente = prixVente;
    }

    public void setPrixDepart(Float prixDepart) {
        this.prixDepart = prixDepart;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setEstTVARecup(Integer estTVARecup) {
        this.estTVARecup = estTVARecup > 0;
    }

    public void setDateArrivee(GregorianCalendar dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setDateVente(GregorianCalendar dateVente) {
        this.dateVente = dateVente;
    }

    public void setPrixMin(Float prixMin){
        this.prixMin = prixMin;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setNbProprios(Integer nbProprios){
        this.nbProprios = nbProprios;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        client.ajouteTransaction(this);
    }

    public FicheVehicule getFicheVehicule() {
        return ficheVehicule;
    }

    public void setFicheVehicule(FicheVehicule ficheVehicule) {
        this.ficheVehicule = ficheVehicule;
        ficheVehicule.ajouteTransaction(this);
    }

    public Commercial getCommercial() {
        return commercial;
    }

    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
        commercial.ajouteTransactions(this);
    }
}
