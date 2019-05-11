package exceptionPackage;

public class GetClientException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de l'obtention d'un ou plusieurs clients");
    }
}
