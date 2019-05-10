package exceptionPackage;

public class ClientException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de la récupération du client");
    }
}
