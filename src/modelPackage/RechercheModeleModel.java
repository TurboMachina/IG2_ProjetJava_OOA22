package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class RechercheModeleModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Transaction> contents;


    public RechercheModeleModel(ArrayList<Transaction> transactions){

        this.contents = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("ID transaction");
        columnNames.add("Kilométrage");
        columnNames.add("Couleur");
        columnNames.add("PV");
        columnNames.add("Durée garantie");
        columnNames.add("TVA Récupérable");
        columnNames.add("Etat");
        columnNames.add("Date de MC");
        columnNames.add("Modéle");
        columnNames.add("Cylindré");
        columnNames.add("Cylindres");
        columnNames.add("Transmission");
        columnNames.add("Vitesses");
        columnNames.add("PAV");
        columnNames.add("Carburant");
        columnNames.add("CM");
        columnNames.add("CU");
        columnNames.add("CEU");
        columnNames.add("Nb portes");
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
                return transaction.getKilometrage();
            case 2:
                return transaction.getCouleur();
            case 3:
                return transaction.getPrixVente();
            case 4:
                return transaction.getDureeGarantie();
            case 5:
                return (transaction.isEstTVARecup()) ? "Oui" : "Non";
            case 6:
                return transaction.getEtat();
            case 7:
                return transaction.getFicheVehicule().getDateMiseCircu();
            case 8 :
                return transaction.getFicheVehicule().getModele().getLibelle();
            case 9 :
                return transaction.getFicheVehicule().getModele().getCylindree();
            case 10 :
                return transaction.getFicheVehicule().getModele().getCylindre();
            case 11 :
                return transaction.getFicheVehicule().getModele().getTransmission();
            case 12 :
                return transaction.getFicheVehicule().getModele().getVitesses();
            case 13 :
                return transaction.getFicheVehicule().getModele().getPoidAVide();
            case 14 :
                return  transaction.getFicheVehicule().getModele().getCarburant();
            case 15 :
                return transaction.getFicheVehicule().getModele().getConsoMixte();
            case 16 :
                return transaction.getFicheVehicule().getModele().getConsoUrbain();
            case 17 :
                return transaction.getFicheVehicule().getModele().getConsoExtraUrbain();
            case 18 :
                return transaction.getFicheVehicule().getModele().getNbPortes();

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
            case 1 : c = Integer.class;
                break;
            case 2 : c = String.class;
                break;
            case 3 : c = Float.class;
                break;
            case 4 : c = Integer.class;
                break;
            case 5 : c = String.class;
                break;
            case 6 : c = String.class;
                break;
            case 7 : c = String.class;
                break;
            case 8 : c = String.class;
                break;
            case 9 : c = Integer.class;
                break;
            case 10 : c = Integer.class;
                break;
            case 11 : c = String.class;
                break;
            case 12 : c = Integer.class;
                break;
            case 13 : c = Integer.class;
                break;
            case 14 : c = String.class;
                break;
            case 15 : c = Float.class;
                break;
            case 16 : c = Float.class;
                break;
            case 17 : c = Float.class;
                break;
            case 18 : c = Integer.class;
                break;
            default : c = String.class;
                break;
        }
        return c;
    }
}
