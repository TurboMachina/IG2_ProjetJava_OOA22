package viewPackage;

import java.util.ArrayList;
import java.util.Date;
import modelPackage.*;

import javax.swing.table.AbstractTableModel;

public class AllTransactionsModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Transaction> contents;

    public AllTransactionsModel(ArrayList<Transaction> transactions){

        columnNames.add("idTransaction");
        columnNames.add("Kilométrage");
        columnNames.add("Couleur");
        columnNames.add("Prix d'achat");
        columnNames.add("Prix de départ");
        columnNames.add("Prix minimum");
        columnNames.add("Nombre de proprios");
        columnNames.add("Description");
        columnNames.add("Date d'arrivée");
        columnNames.add("Durée de la garantie");
        columnNames.add("TVA récupérable");
        columnNames.add("Prix de vente");
        columnNames.add("Date de vente");
        columnNames.add("Etat de la vente");
        columnNames.add("idCommercial");
        columnNames.add("Numéro de chassis");
        columnNames.add("idClient");

        contents = transactions;
    }

    public int getRowCount() {
        return contents.size();
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public String getColumnName(int column){return columnNames.get(column);}

    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaction transaction = contents.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return transaction.getId();
            case 1:
                return transaction.getKilometrage();
            case 2:
                return transaction.getCouleur();
            case 3:
                return transaction.getPrixAchat();
            case 4:
                return transaction.getPrixDepart();
            case 5:
                return transaction.getPrixMin();
            case 6:
                return transaction.getNbProprios();
            case 7:
                return transaction.getDescription();
            case 8:
                return transaction.getDateArrivee();
            case 9:
                return transaction.getDureeGarantie();
            case 10:
                return transaction.isEstTVARecup();
            case 11:
                return transaction.getPrixVente();
            case 12:
                return transaction.getDateVente();
            case 13:
                return transaction.getEtat();
            case 14:
                return transaction.getCommercial().getMatricule();
            case 15:
                return transaction.getFicheVehicule().getNumChassis();
            case 16:
                return transaction.getClient().getId();
            default:
                return null;
        }
    }

    public Class getColumnClass(int columnIndex) {
        Class c;
        switch (columnIndex){
            case 0 : c = Integer.class;
                break;
            case 1 : c = Integer.class;
                break;
            case 2 : c = String.class;
                break;
            case 3 : c = Float.class;
                break;
            case 4 : c = Float.class;
                break;
            case 5 : c = Float.class;
                break;
            case 6 : c = Integer.class;
                break;
            case 7 : c = String.class;
                break;
            case 8 : c = Date.class;
                break;
            case 9 : c = Integer.class;
                break;
            case 10 : c = Boolean.class;
                break;
            case 11 : c = Float.class;
                break;
            case 12 : c = Date.class;
                break;
            case 13 : c = String.class;
                break;
            case 14 : c = Integer.class;
                break;
            case 15 : c = String.class;
                break;
            case 16 : c = Integer.class;
                break;
            default : c = String.class;
                break;
        }
        return c;
    }
}
