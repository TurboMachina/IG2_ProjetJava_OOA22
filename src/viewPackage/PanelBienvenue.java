package viewPackage;
import businessPackage.ConnexionManager;
import controllerPackage.*;
import modelPackage.*;

import javax.print.attribute.standard.JobMediaSheetsCompleted;
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
        try{
            panelAllPreparationOrders();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
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

    public void panelAllPreparationOrders() throws Exception{
        JTable transactions;
        JScrollPane scrollPane;
        AllTransactionsModel model;
        model = new AllTransactionsModel(controller.getAllTransactions());
        transactions = new JTable(model);
        scrollPane = new JScrollPane(transactions);
        add(scrollPane);
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