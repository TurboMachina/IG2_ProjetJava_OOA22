package exceptionPackage;

public class CloseException extends Exception {
    @Override
    public String getMessage() {
        return ("Erreur lors de la fermeture de la base de données");
    }
}
