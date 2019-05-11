package modelPackage;

import java.util.ArrayList;

public class Magasin {
    private Integer id;
    private String nom, adresse;
    private ArrayList<Commercial> commercials;

    public Magasin(Integer id) {
        setId(id);
    }

    public void setId(Integer id){ this.id = id; }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public void ajouteCommercial(Commercial newCommercial){
    }
    public Commercial getCommercial(int index){
        return commercials.get(index);
    }
}
