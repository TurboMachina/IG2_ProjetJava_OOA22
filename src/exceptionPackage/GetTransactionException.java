package exceptionPackage;

public class GetTransactionException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur");
    }
}
