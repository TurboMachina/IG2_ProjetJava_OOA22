package exceptionPackage;

public class MatriculeException extends Exception {
    @Override
    public String getMessage(){
        return ("Matricule inexistant");
    }
}
