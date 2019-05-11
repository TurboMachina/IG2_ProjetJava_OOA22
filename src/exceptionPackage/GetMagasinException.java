package exceptionPackage;

public class GetMagasinException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de l'obtention d'un ou plusieurs magasins");
    }
}
