package exceptionPackage;

public class AddTransactionFormException extends Exception {
    StringBuilder error = new StringBuilder();

    @Override
    public String getMessage(){
        return ((error.equals("")) ? "Erreur dans le formulaire" : error.toString());
    }

    public void addError(String str){
        if (error.toString().equals(""))
            error.append("Les erreurs suivantes ont été detectée : ");
        error.append(System.getProperty("line.separator")).append(str);
    }

    public void clear(){
        error.setLength(0);
    }


}
