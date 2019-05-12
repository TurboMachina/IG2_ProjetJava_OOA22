package modelPackage;

import java.util.ArrayList;

public class Modele {
    private Integer cylindree, cylindre, vitesses, poidAVide, nbPortes, id;
    private float consoMixte, consoUrbain, consoExtraUrbain;
    private String libelle, transmission, carburant;
    private Marque marque;
    private ArrayList<FicheVehicule> fichesVehicules;

    public Modele(Integer id) {
        setId(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    public void setCylindre(int cylindre) {
        this.cylindre = cylindre;
    }

    public void setVitesses(int vitesses) {
        this.vitesses = vitesses;
    }

    public void setPoidAVide(int poidAVide) {
        this.poidAVide = poidAVide;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public void setConsoMixte(float consoMixte) {
        this.consoMixte = consoMixte;
    }

    public void setConsoUrbain(float consoUrbain) {
        this.consoUrbain = consoUrbain;
    }

    public void setConsoExtraUrbain(float consoExtraUrbain) {
        this.consoExtraUrbain = consoExtraUrbain;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public void ajouteFicheVehicule (FicheVehicule newFicheVehicule){
    }
    public FicheVehicule getFicheVehicule(int index){
        return fichesVehicules.get(index);
    }

    public Integer getID(){
        return this.id;
    }

    public Marque getMarque(){return this.marque;}

    @Override
    public String toString(){
        return this.libelle;
    }
}
