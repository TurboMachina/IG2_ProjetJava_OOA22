package modelPackage;

import java.util.GregorianCalendar;

public class ListingTransaction {
    private Integer id, kilometrage, nbProprios, dureeGarantie, matriculeCom;
    private Float prixAchat, prixVente, prixMin, prixDepart;
    private String etat, couleur, description, nomClient, numChassis,estTVARecup;
    private GregorianCalendar dateArrivee, dateVente;

    public ListingTransaction(Integer id, Integer km, String couleur, Float prixAchat, Float prixDepart, Float prixMin, Integer nbProprios, String description, GregorianCalendar dateArrivee, Integer dureeGarantie, String estTVARecup, Float prixVente, GregorianCalendar dateVente, String etat, Integer matriculeCom, String numChassis, String nomClient) {
        setId(id);
        setKilometrage(km);
        setCouleur(couleur);
        setPrixAchat(prixAchat);
        setPrixDepart(prixDepart);
        setPrixMin(prixMin);
        setNbProprios(nbProprios);
        setDescription(description);
        setDateArrivee(dateArrivee);
        setDureeGarantie(dureeGarantie);
        setEstTVARecup(estTVARecup);
        setPrixVente(prixVente);
        setDateVente(dateVente);
        setEtat(etat);
        setCommercial(matriculeCom);
        setFicheVehicule(numChassis);
        setClient(nomClient);
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

    public String estTVARecup() {
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

    public void setEstTVARecup(String estTVARecup) {
        this.estTVARecup = estTVARecup;
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


    public void setClient(String client) {
        this.nomClient = client;
    }

    public String getClient(){
        return this.nomClient;
    }

    public void setFicheVehicule(String ficheVehicule) {
        this.numChassis = ficheVehicule;
    }

    public String getFicheVehicule(){
        return this.numChassis;
    }

    public void setCommercial(Integer commercial) {
        this.matriculeCom = commercial;
    }

    public Integer getCommercial(){
        return this.matriculeCom;
    }
}
