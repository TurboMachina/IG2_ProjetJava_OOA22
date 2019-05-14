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
        return this.libelle.substring(0,1).toUpperCase() + libelle.substring(1);
    }


    @Override
    public String toString(){
        return getLibelle();
    }

}
