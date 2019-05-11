package exceptionPackage;

public class GetMarqueException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de l'obtention d'une ou plusieurs marques");
    }
}
