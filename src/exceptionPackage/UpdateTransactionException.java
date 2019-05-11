package exceptionPackage;

public class UpdateTransactionException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de la mise à jour d'une transaction");
    }
}
