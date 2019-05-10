package modelPackage;

import java.util.ArrayList;

public class Marque {
    private String libelle;
    private ArrayList<Modele> modeles;
    public Marque(String libelle){
        setLibelle(libelle);
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void ajouteModele(Modele newModele){
        newModele.setMarque(this);
        modeles.add(newModele);
    }

    public String getLibelle(){
        return this.libelle;
    }

    public ArrayList<Modele> getModeles(){
        return this.modeles;
    }

}
