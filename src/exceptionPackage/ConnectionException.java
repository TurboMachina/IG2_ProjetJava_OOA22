package exceptionPackage;

public class ConnectionException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de la connection à la base de données");
    }
}
