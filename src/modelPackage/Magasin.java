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
        this.nom = nom;
    }

    @Override
    public String toString(){
        return this.nom;
    }
}
