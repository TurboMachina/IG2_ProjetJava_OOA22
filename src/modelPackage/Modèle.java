package modelPackage;

import java.util.ArrayList;

public class Modèle  {
    private static int id = 0;
    private int cylindree, cylindre, vitesses, poidAVide, nbPortes;
    private float consoMixte, consoUrbain, consoExtraUrbain;
    private String libelle, transmission, carburant;
    private Marque marque;
    private ArrayList<FicheVéhicule> fichesVéhicules;

    public Modèle(Marque marque, int cylindree, int cylindre, int vitesses, int poidAVide, int nbPortes, float consoMixte, float consoUrbain, float consoExtraUrbain, String libelle, String transmission, String carburant) {
        this.cylindree = cylindree;
        this.cylindre = cylindre;
        this.vitesses = vitesses;
        this.poidAVide = poidAVide;
        this.nbPortes = nbPortes;
        this.consoMixte = consoMixte;
        this.consoUrbain = consoUrbain;
        this.consoExtraUrbain = consoExtraUrbain;
        this.libelle = libelle;
        this.transmission = transmission;
        this.carburant = carburant;
        this.marque = setMarque(marque);
    }
    private Marque setMarque(Marque newMarque){
        return newMarque;
    }
    public void ajouteFicheVéhicule (FicheVéhicule newFicheVéhicule){
        fichesVéhicules.add(newFicheVéhicule);
    }
    public FicheVéhicule getFicheVéhicule(int index){
        return fichesVéhicules.get(index);
    }
}
