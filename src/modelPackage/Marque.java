package modelPackage;

import java.util.ArrayList;

public class Marque {
    private String libelle;
    private ArrayList<Modele> modèles;
    public Marque(String libelle){
        setLibelle(libelle);
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void ajouteModèle(Modele newModèle){
        modèles.add(newModèle);
    }

}
