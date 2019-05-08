package modelPackage;

import java.util.ArrayList;

public class Marque {
    private String libelle;
    private ArrayList<Modèle> modèles;
    public Marque(String libelle){
        this.libelle = libelle;
    }

    public void ajouteModèle(Modèle newModèle){
        modèles.add(newModèle);
    }

}
