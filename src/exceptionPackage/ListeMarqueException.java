package exceptionPackage;

public class ListeMarqueException  extends Exception{
    @Override
    public String getMessage(){
        return ("Liste de marque déjà existante");
    }
}
