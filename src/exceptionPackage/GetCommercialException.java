package exceptionPackage;

public class GetCommercialException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de l'obtention d'un ou plusieurs commerciaux");
    }
}
