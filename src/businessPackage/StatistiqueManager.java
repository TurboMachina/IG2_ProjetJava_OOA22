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
        prixMoyenMarque();
        resultats.append("\n");
        partDeMarche();
        resultats.append("\n");
        return resultats.toString();
    }

    private void prixMoyenMarque(){
        float prixMoyen = 0;
        int nbVehicule = 0;
        String marqueCourante = transactions.get(0).getFicheVehicule().getModele().getMarque().getLibelle();
        resultats.append(marqueCourante).append(" ");
        for(Transaction transaction : transactions){
            if(transaction.getFicheVehicule().getModele().getMarque().getLibelle() != marqueCourante){
                resultats.append(marqueCourante).append(" : ");
                resultats.append(prixMoyen / nbVehicule).append("€").append("\n");
                prixMoyen = 0;
                nbVehicule = 1;
                marqueCourante = transaction.getFicheVehicule().getModele().getMarque().getLibelle();
            }
            nbVehicule++;
            prixMoyen += transaction.getPrixVente();
        }
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
    private void partDeMarche() throws ConnectionException, GetMarqueException {
        float prixTotal = 0;
        float moyenne;
        for(Transaction transaction : transactions){
            prixTotal+=transaction.getPrixVente();
        }
        float prixMarqueCourante = 0;
        String marqueCourante = transactions.get(0).getFicheVehicule().getModele().getMarque().getLibelle();
        for(Transaction transaction : transactions){
            if(transaction.getFicheVehicule().getModele().getMarque().getLibelle() != marqueCourante){
                moyenne = (prixMarqueCourante/prixTotal)*100;
                resultats.append(transaction.getFicheVehicule().getModele().getMarque().getLibelle()).append(" ");
                resultats.append(String.format("%.2f", moyenne));
                resultats.append(" %\n");
                prixMarqueCourante = 0;
                marqueCourante = transaction.getFicheVehicule().getModele().getMarque().getLibelle();
            }
                prixMarqueCourante+= transaction.getPrixVente();
        }
    }

}
