package modelPackage;

public class Magasin {
    private Integer id;
    private String nom;

    public Magasin(Integer id) {
        setId(id);
    }

    public void setId(Integer id){ this.id = id; }

    public void setNom(String nom){
        this.nom = nom;
    }

    public Integer getId(){return this.id;}

    @Override
    public String toString(){
        return this.nom;
    }
}
