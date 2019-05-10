package modelPackage;

import java.util.ArrayList;

public class Modele {
    private static int id = 0;
    private int cylindree, cylindre, vitesses, poidAVide, nbPortes;
    private float consoMixte, consoUrbain, consoExtraUrbain;
    private String libelle, transmission, carburant;
    private Marque marque;
    private ArrayList<FicheVehicule> fichesVehicules;

    public Modele(Marque marque, int cylindree, int cylindre, int vitesses, int poidAVide, int nbPortes, float consoMixte, float consoUrbain, float consoExtraUrbain, String libelle, String transmission, String carburant) {
        setMarque(marque);
        setCylindree(cylindree);
        setCylindre(cylindre);
        setVitesses(vitesses);
        setPoidAVide(poidAVide);
        setNbPortes(nbPortes);
        setConsoMixte(consoMixte);
        setConsoUrbain(consoUrbain);
        setConsoExtraUrbain(consoExtraUrbain);
        setLibelle(libelle);
        setTransmission(transmission);
        setCarburant(carburant);
    }

    public static void setId(int id) {
        Modele.id = id;
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
        fichesVehicules.add(newFicheVehicule);
    }
    public FicheVehicule getFicheVehicule(int index){
        return fichesVehicules.get(index);
    }
}
