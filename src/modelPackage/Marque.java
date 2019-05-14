package modelPackage;

public class Marque {
    private String libelle;
    public Marque(String libelle){
        setLibelle(libelle);
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle.toLowerCase();
    }

    public String getLibelle(){
        return this.libelle;
    }


    @Override
    public String toString(){
        return this.libelle;
    }

}
