package exceptionPackage;

public class DeleteTransactionException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur");
    }
}
