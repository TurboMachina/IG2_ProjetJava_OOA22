package businessPackage;

import dataAccessPackage.MarqueDBAccess;
import dataAccessPackage.MarqueDataAccess;
import dataAccessPackage.TransactionDBAccess;
import dataAccessPackage.TransactionDataAccess;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetMarqueException;
import exceptionPackage.GetTransactionException;
import modelPackage.Marque;
import modelPackage.Transaction;

import java.util.ArrayList;

public class StatistiqueManager {
    private static final Double TAUXTVA = 0.21;

    private TransactionDataAccess daoTransaction;
    private MarqueDataAccess daoMarque;
    private ArrayList<Transaction> transactions;
    private ArrayList<Marque> marques;

    private void setDAOTransaction(TransactionDataAccess daoTransaction){this.daoTransaction = daoTransaction;}
    private void setDAOMarques(MarqueDataAccess daoMarques){this.daoMarque = daoMarques;}


    public String getStatistiques() throws ConnectionException, GetTransactionException, GetMarqueException {
        String marqueCourante;
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
           stats.append(marqueCourante.toUpperCase()).append(": \n");
           stats.append( "- Total vendus : ").append(String.format("%d", nbVendu)).append("\n");
           stats.append("- Part de marché : ").append(String.format("%.2f", getPartDeMarche(nbVendu,nbVenduTot))).append("%\n");
           stats.append("- Prix moyen de vente HTVA : ").append(String.format("%.2f", getPrixMoyen(prixVenteTot - TVAMarque,nbVendu))).append("€\n");
           stats.append("- Total des achats : ").append(String.format("%.2f", prixAchatTot)).append("€\n");
           stats.append("- Total des ventes : ").append(String.format("%.2f", prixVenteTot)).append("€\n");
           stats.append("- Total TVA des ventes : ").append(String.format("%.2f", TVAMarque)).append("€\n");
           nbVendu = 0;
           TVAMarque =0.0;
           prixVenteTot = 0.0;
           prixAchatTot = 0.0;
       }
        return stats.toString();
    }

    private Double getPrixMoyen(Double prix, Integer nbVehicules){
        return (nbVehicules > 0) ? prix/nbVehicules : 0.0;
    }

    private Double getPartDeMarche(Integer nbVendu, Integer nbTot){

        return (nbVendu > 0) ? ((double)nbVendu/nbTot)*100 : 0.0;
    }

    private Double getTVA(Double prix){
        return prix*TAUXTVA;
    }
}
