package exceptionPackage;

public class GetModeleException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de l'obtention d'un ou plusieurs modeles");
    }
}
