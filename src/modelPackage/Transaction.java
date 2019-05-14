package modelPackage;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Transaction {
    private Integer id, kilometrage, nbProprios, dureeGarantie;
    private Double prixAchat, prixVente, prixMin, prixDepart;
    private String etat, couleur, description;
    private boolean estTVARecup;
    private GregorianCalendar dateArrivee, dateVente;
    private Client client;
    private FicheVehicule ficheVehicule;
    private Commercial commercial;

    public Transaction(Integer id) {
         setId(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setNbProprios(Integer nbProprios){
        this.nbProprios = nbProprios;
    }

    public Integer getNbProprios() {
        return nbProprios;
    }

    public void setDureeGarantie(Integer dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    public Integer getDureeGarantie() {
        return dureeGarantie;
    }

    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Double getPrixAchat() {
        return prixAchat;
    }


    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixMin(Double prixMin){
        this.prixMin = prixMin;
    }

    public Double getPrixMin() {
        return prixMin;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Double getPrixDepart() {
        return prixDepart;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEstTVARecup(Integer estTVARecup) {
        this.estTVARecup = estTVARecup > 0;
    }

    public boolean isEstTVARecup() {
        return estTVARecup;
    }

    public void setDateArrivee(GregorianCalendar dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public GregorianCalendar getDateArrivee() {
        return dateArrivee;
    }

    public void setDateVente(GregorianCalendar dateVente) {
        this.dateVente = dateVente;
    }

    public GregorianCalendar getDateVente() {
        return dateVente;
    }

    public String getDateVenteStr() {
        SimpleDateFormat temp = new SimpleDateFormat("dd-MM-YYYY");
        temp.setCalendar(this.dateVente);
        return temp.format(this.dateVente.getTime());
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
