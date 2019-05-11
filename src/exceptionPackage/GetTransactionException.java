package exceptionPackage;

public class GetTransactionException extends Exception {
    @Override
    public String getMessage(){
        return ("Impossible de recuperer la ou les transaction(s)");
    }
}
