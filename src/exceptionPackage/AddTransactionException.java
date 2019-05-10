package exceptionPackage;

public class AddTransactionException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur");
    }
}
