package modelPackage;

import exceptionPackage.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;


public class ListeMarque {
    private static ArrayList<Marque> listeMarques;

    private ListeMarque(){

    }

    public static ArrayList<Marque> getListeMarques() throws ConnectionException {
        if(listeMarques == null){
            try{
                listeMarques = new ArrayList<>();
            }
            catch (Exception e){
                throw new ConnectionException();
            }
        }
        return listeMarques;
    }

    public static void addMarque(Marque marque){
      listeMarques.add(marque);
    }
}
