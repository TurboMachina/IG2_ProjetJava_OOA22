package viewPackage;
import modelPackage.Transaction;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelBienvenue extends JPanel {

    private GestionnaireEcran ge;

    PanelBienvenue(GestionnaireEcran ge) {
        this.setLayout(new FlowLayout());
        JLabel ligneBienvenue = new JLabel("Bienvenue.");
        JLabel ligneSelection = new JLabel("Selectionnez une action à effectuer, sélectionnez une transaction pour la modifier.");
        this.ge = ge;
        // this.add(new ListingTransaction(getAllTransactions()));
        this.add(ligneBienvenue);
        this.add(ligneSelection);
        this.add(new BottomButtonsPanel());
    }

    class BottomButtonsPanel extends JPanel {

        BottomButtonsPanel() {
            JButton ajoutTransaction = new JButton("Ajouter une nouvelle transaction");
            JButton supprimerTransaction = new JButton("Supprimer une transaction");
            JButton modifierTransaction = new JButton("Modifier la transaction");
            JButton quitter = new JButton("Quitter");

            ButtonAjoutListener listenerAjout = new ButtonAjoutListener();
            ajoutTransaction.addActionListener(listenerAjout);
            ButtonQuitterListener listenerQuitter = new ButtonQuitterListener();
            quitter.addActionListener(listenerQuitter);


            this.setLayout(new GridLayout(2, 2)); // RESET

            this.add(ajoutTransaction);
            this.add(supprimerTransaction);
            this.add(modifierTransaction);
            this.add(quitter);
        }
    }

    private class ListingTransaction extends AbstractTableModel {

        private ArrayList<String> columnNames;
        private ArrayList<Transaction> transactions;

        public ListingTransaction(ArrayList<String> contents){

            columnNames.add("idTransaction");
            columnNames.add("idClient");
            columnNames.add("Numéro de chassis");
            columnNames.add("idCommercial");
            columnNames.add("Kilométrage");
            columnNames.add("Prix d'achat");
            columnNames.add("Prix de départ");
            columnNames.add("Prix minimum");
            columnNames.add("Nombre de proprios");
            columnNames.add("Durée de la garantie");
            columnNames.add("Prix de vente");
            columnNames.add("Couleur");
            columnNames.add("Description");
            columnNames.add("TVA récupérable");
            columnNames.add("Date d'arrivée");
            columnNames.add("Date de vente");
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
        public Object getValueAt(int rowIndex, int columnIndex) {
            return transactions.get(rowIndex);
        }
    }


    class ButtonAjoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ge.setPanel(new PanelAjout(ge), "Ajout d'un véhicule");
        }
    }

    class ButtonQuitterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Connection.close();
            System.exit(0);
        }
    }

}