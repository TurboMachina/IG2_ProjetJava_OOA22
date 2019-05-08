package modelPackage;

import java.util.ArrayList;

public class Magasin {
    private String nom, adresse;
    private ArrayList<Commercial> commercials;
    public Magasin(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }
    public void ajouteCommercial(Commercial newCommercial){
        commercials.add(newCommercial);
        newCommercial.setMagasin(this);
    }
    public Commercial getCommercial(int index){
        return commercials.get(index);
    }
}
