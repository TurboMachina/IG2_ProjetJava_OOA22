package exceptionPackage;

public class RechercheException extends Exception {

    @Override
    public String getMessage() {
        return ("Erreur lors de l'obtention du résultat de la recherche");
    }
}
