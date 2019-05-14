package modelPackage;

public class Magasin {
    private Integer id;
    private String nom;

    public Magasin(Integer id) {
        setId(id);
    }

    public void setId(Integer id){ this.id = id; }

    public Integer getId(){return this.id;}

    public void setNom(String nom){
        this.nom = nom.toLowerCase();
    }

    public String getNom(){ return this.nom.substring(0,1).toUpperCase() + nom.substring(1);}

    @Override
    public String toString(){
        return getNom();
    }
}
