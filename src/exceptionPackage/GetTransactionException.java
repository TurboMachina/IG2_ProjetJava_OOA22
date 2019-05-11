package exceptionPackage;

public class GetTransactionException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de l'obtention d'une ou plusieurs transactions");
    }
}
