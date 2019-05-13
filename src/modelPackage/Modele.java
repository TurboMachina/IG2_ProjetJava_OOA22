package modelPackage;

import java.util.ArrayList;

public class Modele {
    private Integer cylindree, cylindre, vitesses, poidAVide, nbPortes, id;
    private float consoMixte, consoUrbain, consoExtraUrbain;
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
        return cylindree;
    }

    public void setCylindre(int cylindre) {
        this.cylindre = cylindre;
    }

    public Integer getCylindre() {
        return cylindre;
    }

    public void setVitesses(int vitesses) {
        this.vitesses = vitesses;
    }

    public Integer getVitesses() {
        return vitesses;
    }

    public void setPoidAVide(int poidAVide) {
        this.poidAVide = poidAVide;
    }

    public Integer getPoidAVide() {
        return poidAVide;
    }


    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public Integer getNbPortes() {
        return nbPortes;
    }

    public void setConsoMixte(float consoMixte) {
        this.consoMixte = consoMixte;
    }

    public float getConsoMixte() {
        return consoMixte;
    }

    public void setConsoUrbain(float consoUrbain) {
        this.consoUrbain = consoUrbain;
    }

    public float getConsoUrbain() {
        return consoUrbain;
    }

    public void setConsoExtraUrbain(float consoExtraUrbain) {
        this.consoExtraUrbain = consoExtraUrbain;
    }


    public float getConsoExtraUrbain() {
        return consoExtraUrbain;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle(){return this.libelle;}

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getCarburant() {
        return carburant;
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
