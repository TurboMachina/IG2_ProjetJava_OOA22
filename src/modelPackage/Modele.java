package modelPackage;

import java.util.ArrayList;

public class Modele {
    private Integer cylindree, cylindre, vitesses, poidAVide, nbPortes, id;
    private Double consoMixte, consoUrbain, consoExtraUrbain;
    private String libelle, transmission, carburant;
    private Marque marque;
    private ArrayList<FicheVehicule> fichesVehicules = new ArrayList<>();

    public Modele(Integer id) {
        setId(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getID(){
        return this.id;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    public Integer getCylindree() {
        return this.cylindree;
    }

    public void setCylindre(int cylindre) {
        this.cylindre = cylindre;
    }

    public Integer getCylindre() {
        return this.cylindre;
    }

    public void setVitesses(int vitesses) {
        this.vitesses = vitesses;
    }

    public Integer getVitesses() {
        return this.vitesses;
    }

    public void setPoidAVide(int poidAVide) {
        this.poidAVide = poidAVide;
    }

    public Integer getPoidAVide() {
        return this.poidAVide;
    }


    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public Integer getNbPortes() {
        return this.nbPortes;
    }

    public void setConsoMixte(Double consoMixte) {
        this.consoMixte = consoMixte;
    }

    public Double getConsoMixte() {
        return this.consoMixte;
    }

    public void setConsoUrbain(Double consoUrbain) {
        this.consoUrbain = consoUrbain;
    }

    public Double getConsoUrbain() {
        return this.consoUrbain;
    }

    public void setConsoExtraUrbain(Double consoExtraUrbain) {
        this.consoExtraUrbain = consoExtraUrbain;
    }


    public Double getConsoExtraUrbain() {
        return this.consoExtraUrbain;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle.toLowerCase();
    }

    public String getLibelle(){return this.libelle;}

    public void setTransmission(String transmission) {
        this.transmission = transmission.toLowerCase();
    }

    public String getTransmission() {
        return this.transmission;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant.toLowerCase();
    }

    public String getCarburant() {
        return this.carburant;
    }


    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Marque getMarque(){return this.marque;}

    public void ajouteFicheVehicule (FicheVehicule newFicheVehicule){
        this.fichesVehicules.add(newFicheVehicule);
    }


    @Override
    public String toString(){
        return this.libelle;
    }
}
