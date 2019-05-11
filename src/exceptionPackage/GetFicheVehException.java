package exceptionPackage;

public class GetFicheVehException extends Exception {
    @Override
    public String getMessage(){
        return ("Erreur lors de l'obtention d'une ou plusieurs fiches de véhicule");
    }
}
