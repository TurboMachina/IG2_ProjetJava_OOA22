package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class RechercheTransactionModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Transaction> contents;

    public RechercheTransactionModel(ArrayList<Transaction> transactions){
        this.contents = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("ID de la transaction");
        columnNames.add("Prix de vente (en €)");
        columnNames.add("Date de vente");
        columnNames.add("Marque");
        columnNames.add("Modèle");
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
                return transaction.getPrixVente();
            case 2:
                return transaction.getDateVenteStr();
            case 3:
                return transaction.getFicheVehicule().getModele().getMarque().getLibelle();
            case 4:
                return transaction.getFicheVehicule().getModele().getLibelle();
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
            case 1 : c = Double.class;
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
