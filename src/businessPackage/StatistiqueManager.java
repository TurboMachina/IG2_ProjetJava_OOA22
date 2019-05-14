package businessPackage;

import dataAccessPackage.*;
import exceptionPackage.*;
import modelPackage.*;

import java.text.DecimalFormat;
import java.util.*;

public class StatistiqueManager {
    private TransactionDataAccess daoTransaction;
    private MarqueDataAccess daoMarque;
    private ArrayList<Transaction> transactions;
    private StringBuilder resultats;

    public StatistiqueManager() throws ConnectionException, GetTransactionException {
        TransactionDBAccess daoTransaction = new TransactionDBAccess();
        this.transactions = daoTransaction.getTransactionsAndMarques();
    }

    private void setDAOTransaction(TransactionDataAccess daoTransaction){this.daoTransaction = daoTransaction;}
    private void setDAOMarque(MarqueDataAccess dao){this.daoMarque = dao;}
    public String getResultats() throws ConnectionException, GetTransactionException, GetMarqueException {
        this.resultats = new StringBuilder();
        nombreVehiculeVendu();
        resultats.append("\n");
        prixMoyenPartMarche();
        resultats.append("\n");
        return resultats.toString();
    }

    private void nombreVehiculeVendu() throws ConnectionException, GetTransactionException {
        int nbVehiculeVendu = 0;
        for(Transaction transaction : transactions){
            if(transaction.getPrixVente() != null){
                nbVehiculeVendu++;
            }
        }
        resultats.append("Nombre de véhicules vendus : ").append(nbVehiculeVendu).append("\n");
    }

    private void prixMoyenPartMarche() throws ConnectionException, GetMarqueException {
        float prixTotal = 0;
        float moyenne = 0;
        float prixMoyen = 0;
        int nbVehicule = 0;
        float prixMarqueCourante = 0;
        String marqueCourante = null;
        for(Transaction transaction : transactions){
            prixTotal+=transaction.getPrixVente();
        }

        for(Transaction transaction : transactions){
            prixMarqueCourante+= transaction.getPrixVente();
            nbVehicule++;
            prixMoyen += transaction.getPrixVente();
            if(!transaction.getFicheVehicule().getModele().getMarque().getLibelle().equals(marqueCourante)){

                moyenne = (prixMarqueCourante/prixTotal)*100;
                resultats.append(transaction.getFicheVehicule().getModele().getMarque().getLibelle()).append("\n");
                resultats.append(prixMoyen / nbVehicule).append("€").append("\n");
                resultats.append(String.format("%.2f", moyenne));
                resultats.append(" %\n");

                prixMoyen = 0;
                nbVehicule = 1;
                prixMarqueCourante = 0;
                marqueCourante = transaction.getFicheVehicule().getModele().getMarque().getLibelle();
            }
        }
    }
}
