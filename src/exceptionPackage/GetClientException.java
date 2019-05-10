package exceptionPackage;

public class GetClientException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur");
    }
}
