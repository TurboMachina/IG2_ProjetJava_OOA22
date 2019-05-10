package viewPackage;
import businessPackage.ConnexionManager;
import controllerPackage.*;
import modelPackage.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

public class PanelBienvenue extends JPanel {

    private GestionnaireEcran ge;
    private ConnexionController controller;

    PanelBienvenue(GestionnaireEcran ge){
        setController(new ConnexionController());
        this.setLayout(new FlowLayout());
        JLabel ligneBienvenue = new JLabel("Bienvenue.");
        JLabel ligneSelection = new JLabel("Selectionnez une action à effectuer, sélectionnez une transaction pour la modifier.");
        this.ge = ge;
        // this.add(new ListingTransaction(getAllTransactions()));
        this.add(ligneBienvenue);
        this.add(ligneSelection);
        this.add(new BottomButtonsPanel());
    }

    private void setController(ConnexionController controller){
        this.controller = controller;
    }

    class BottomButtonsPanel extends JPanel {

        BottomButtonsPanel(){
            JButton ajoutTransaction = new JButton("Ajouter une nouvelle transaction");
            JButton supprimerTransaction = new JButton("Supprimer une transaction");
            JButton modifierTransaction = new JButton("Modifier la transaction");
            JButton quitter = new JButton("Quitter");
            JTable transactions;
            JScrollPane transactions_scrollPane;

            ButtonAjoutListener listenerAjout = new ButtonAjoutListener();
            ajoutTransaction.addActionListener(listenerAjout);

            ButtonQuitterListener listenerQuitter = new ButtonQuitterListener();
            quitter.addActionListener(listenerQuitter);

            ButtonSupprimerListener listenerSupprimer = new ButtonSupprimerListener();
            supprimerTransaction.addActionListener(listenerSupprimer);

            ButtonModifierListener listenerModifier = new ButtonModifierListener();
            modifierTransaction.addActionListener(listenerModifier);

            //ButtonRechercheListener listenerRecherche = new ButtonRechercheListener();
            //recherche.addActionListener(listenerRecherche);


            this.setLayout(new GridLayout(2, 2)); // RESET

            this.add(ajoutTransaction);
            this.add(supprimerTransaction);
            this.add(modifierTransaction);
            this.add(quitter);
        }
    }

    private class ListingTransaction extends AbstractTableModel {

        private ArrayList<String> columnNames;
        private ArrayList<Transaction> contents;

        public ListingTransaction(ArrayList<Transaction> transactions){

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
            contents = transactions;
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
        public Object getValueAt(int rowIndex, int columnIndex) {
            return contents.get(rowIndex);
        }
    }


    class ButtonAjoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ge.setPanel(new PanelAjout(ge), "Ajout d'une transaction");
        }
    }

    class ButtonQuitterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            try{
                setController(new ConnexionController());
                controller.closeConnection();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
                System.exit(0);
        }
    }

    class ButtonSupprimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            //Suppresion dans la table
        }
    }

    class ButtonModifierListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            ge.setPanel(new PanelModifier(ge), "Modification d'une transaction");
        }
    }

    class ButtonRechercheListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            ge.setPanel(new PanelRecherche(ge), "Recherche dans la base de données");
        }
    }

}