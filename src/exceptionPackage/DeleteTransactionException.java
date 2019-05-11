package exceptionPackage;

public class DeleteTransactionException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de la suppresion de la transaction");
    }
}
