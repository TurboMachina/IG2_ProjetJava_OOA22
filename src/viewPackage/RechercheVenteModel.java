package viewPackage;

import modelPackage.Transaction;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class RechercheVenteModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Transaction> contents;

    public RechercheVenteModel(ArrayList<Transaction> transactions){
        this.contents = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("ID de la transaction");
        columnNames.add("Numéro de chassis");
        columnNames.add("Prix de vente");
        columnNames.add("Date de vente");
        columnNames.add("Commercial");
        columnNames.add("Client");
        this.setContents(transactions);
    }

    private void setContents(ArrayList<Transaction> transactions){
        this.contents = transactions;
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column){return columnNames.get(column);}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaction transaction = contents.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return transaction.getId();
            case 1:
                return transaction.getFicheVehicule().getNumChassis();
            case 2:
                return transaction.getPrixVente() +" €";
            case 3:
                return transaction.getDateVenteStr();
            case 4:
                return transaction.getCommercial().getNom();
            case 5:
                return transaction.getClient().getNom();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        Class c;
        switch (columnIndex){
            case 0 : c = Integer.class;
                break;
            case 1 : c = String.class;
                break;
            case 2 : c = String.class;
                break;
            case 3 : c = String.class;
                break;
            case 4 : c = String.class;
                break;
            case 5 : c = String.class;
                break;
            default : c = String.class;
                break;
        }
        return c;
    }
}
