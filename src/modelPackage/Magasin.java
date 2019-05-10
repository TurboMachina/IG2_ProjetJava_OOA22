package modelPackage;

import java.util.ArrayList;

public class Magasin {
    private Integer id;
    private String nom, adresse;
    private ArrayList<Commercial> commercials;
    public Magasin(Integer id,String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setAdresse(String adresse){
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
