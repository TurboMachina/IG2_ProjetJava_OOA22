package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class AllTransactionsModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Transaction> contents;

    private ArrayList<Transaction> transactions;

    public AllTransactionsModel(ArrayList<Transaction> transactions){

        this.transactions = transactions;
        this.contents = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("ID");
        columnNames.add("Kilométrage");
        columnNames.add("Couleur");
        columnNames.add("Prix Achat (en €)");
        columnNames.add("Prix Départ (en €)");
        columnNames.add("Prix Min (en €)");
        columnNames.add("Nb Proprios");
        columnNames.add("Description");
        columnNames.add("Arrivée le");
        columnNames.add("Garantie (mois)");
        columnNames.add("TVA récupérée");
        columnNames.add("Prix Vente (en €)");
        columnNames.add("Vendue le");
        columnNames.add("Etat Vente");
        columnNames.add("Vendeur");
        columnNames.add("Num Chassis");
        columnNames.add("Client");
        this.setContents(transactions);
    }

    private void setContents(ArrayList<Transaction> transactions){
        contents = transactions;
    }

    @Override
    public int getRowCount() {
        return transactions.size();
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
                return transaction.getKilometrage() + " km";
            case 2:
                return transaction.getCouleur();
            case 3:
                return transaction.getPrixAchat() +" €" ;
            case 4:
                return transaction.getPrixDepart() +" €";
            case 5:
                return (transaction.getPrixMin() != null) ? transaction.getPrixMin() +" €" : "---";
            case 6:
                return (transaction.getNbProprios() != null) ? transaction.getNbProprios() : "---";
            case 7:
                return (transaction.getDescription() != null) ?  transaction.getDescription() : "---";
            case 8:
                return transaction.getDateArriveeStr();
            case 9:
                return transaction.getDureeGarantie();
            case 10:
                return (transaction.isEstTVARecup()) ? "Oui" : "Non";
            case 11:
                return transaction.getPrixVente();
            case 12:
                return transaction.getDateVenteStr();
            case 13:
                return transaction.getEtat();
            case 14 :
                return transaction.getCommercial();
            case 15 :
                return transaction.getFicheVehicule();
            case 16 :
                return transaction.getClient();
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
            case 6 : c = Integer.class;
                break;
            case 7 : c = String.class;
                break;
            case 8 : c = String.class;
                break;
            case 9 : c = Integer.class;
                break;
            case 10 : c = String.class;
                break;
            case 11 : c = Double.class;
                break;
            case 12 : c = String.class;
                break;
            case 13 : c = String.class;
                break;
            case 14 : c = Integer.class;
                break;
            case 15 : c = String.class;
                break;
            case 16 : c = String.class;
                break;
            default : c = String.class;
                break;
        }
        return c;
    }
}
