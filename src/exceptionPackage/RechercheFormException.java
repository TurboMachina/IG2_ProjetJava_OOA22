package exceptionPackage;

public class RechercheFormException extends Exception {
    private StringBuilder error = new StringBuilder();

    @Override
    public String getMessage(){
        return ((error.length() == 0) ? "Erreur dans le formulaire de recherche" : error.toString());
    }

    public void addError(String str){
        if (error.length() == 0)
            error.append("Les erreurs suivantes ont été detectée : ");
        error.append(System.getProperty("line.separator")).append(str);
    }

    public void clear(){
        error.setLength(0);
    }
}
