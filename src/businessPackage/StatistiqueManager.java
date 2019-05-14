package businessPackage;

import dataAccessPackage.*;
import exceptionPackage.*;
import modelPackage.*;

import java.text.DecimalFormat;
import java.util.*;

public class StatistiqueManager {
    private static final Double TAUXTVA = 0.21;

    private TransactionDataAccess daoTransaction;
    private MarqueDataAccess daoMarque;
    private ArrayList<Transaction> transactions;
    private ArrayList<Marque> marques;

    private void setDAOTransaction(TransactionDataAccess daoTransaction){this.daoTransaction = daoTransaction;}
    private void setDAOMarques(MarqueDataAccess daoMarques){this.daoMarque = daoMarques;}


    public String getStatistiques() throws ConnectionException, GetTransactionException, GetMarqueException{
        String marqueCourante = "";
        StringBuilder stats = new StringBuilder();
        Integer nbVenduTot;
        Integer nbVendu = 0;
        Double TVAMarque = 0.0;
        Double prixVenteTot = 0.0;
        Double prixAchatTot = 0.0;

        setDAOTransaction(new TransactionDBAccess());
        setDAOMarques(new MarqueDBAccess());

        this.transactions = daoTransaction.getTransactionsAndMarques();
        this.marques = daoMarque.getAllMarques();

        nbVenduTot = transactions.size();

       for(Marque marque : marques){
           marqueCourante = marque.getLibelle();
           for(Transaction transaction : transactions){
               if(marqueCourante.equals(transaction.getFicheVehicule().getModele().getMarque().getLibelle())){
                   nbVendu++;
                   TVAMarque += getTVA((transaction.isEstTVARecup()) ? transaction.getPrixVente() : 0);
                   prixVenteTot += transaction.getPrixVente();
                   prixAchatTot += transaction.getPrixAchat();
               }
           }
           stats.append(marqueCourante.toUpperCase() + ": \n" +
                   "- Total vendus : " + String.format("%d", nbVendu) + "\n" +
                   "- Part de marché : " + String.format("%.2f", getPartDeMarché(nbVendu,nbVenduTot)) + "%\n" +
                   "- Prix moyen HTVA d'un véhicule de la marque : " + String.format("%.2f", getPrixMoyen(prixVenteTot - TVAMarque,nbVendu)) + "€\n" +
                   "- Total des achats : " + String.format("%.2f", prixAchatTot) + "€\n" +
                   "- Total des ventes : " + String.format("%.2f", prixVenteTot) + "€\n" +
                   "- Total TVA des ventes : " + String.format("%.2f", TVAMarque) + "€\n");
           nbVendu = 0;
           TVAMarque =0.0;
           prixVenteTot = 0.0;
           prixAchatTot = 0.0;
       }
        return stats.toString();
    }

    public Double getPrixMoyen(Double prix, Integer nbVehicules){
        return (nbVehicules > 0) ? prix/nbVehicules : 0.0;
    }

    public Double getPartDeMarché(Integer nbVendu, Integer nbTot){

        return (nbVendu > 0) ? ((double)nbVendu/nbTot)*100 : 0.0;
    }

    public Double getTVA(Double prix){
        return prix*TAUXTVA;
    }
}
