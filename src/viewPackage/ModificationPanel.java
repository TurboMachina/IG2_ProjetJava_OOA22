package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.*;
import modelPackage.*;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class ModificationPanel extends JPanel {
    private PrincipalWindow w;
    private JTextField txtKilometrage, txtCouleur, txtPrixAchat, txtPrixDepart, txtPrixMin, txtPrixVente, txtNbProprios;
    private JComboBox<String> cbEtat;
    private JComboBox<Commercial> cbCommercial;
    private JComboBox<Client> cbClient;
    private JComboBox<FicheVehicule> cbNumChassis;
    private JSpinner spDateArrivee, spDateVente, spDureeGarantie;
    private JTextArea taDescription;
    private JCheckBox cbxTVARecup;
    private JLabel lbKilometrage, lbCouleur, lbPrixAchat, lbPrixDepart, lbPrixMin, lbPrixVente, lbEtat, lbCommercial,
            lbNumChassis, lbClient, lbDateArrivee, lbDateVente, lbNbProprios, lbDureeGarantie, lbDescription, lbTVARecup, lbModify;
    private JButton btnModifier;
    private TransactionController controller;


    private ArrayList<Client> listeClients;
    private ArrayList<Commercial> listeCommerciaux;
    private ArrayList<FicheVehicule> listeNumChassis;
    private String[] listeEtat = {"attente","vendue"};

    private Transaction currentTransaction;

    public ModificationPanel(PrincipalWindow w, Transaction transaction){
        this.w = w;
        this.currentTransaction = transaction;
        setController(new TransactionController());
        setLayout(new GridLayout(8,4,20,20));

        try{
            listeCommerciaux = controller.getAllCommerciaux();
            listeClients = controller.getAllClients();
            listeNumChassis = controller.getAllNumChassis();
        }
        catch (GetClientException | ConnectionException | GetCommercialException | GetFicheVehException e){
            JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        //Label
        lbKilometrage = new JLabel("Kilometrage du vehicule : ");
        lbCouleur = new JLabel("Couleur du véhicule : ");
        lbPrixAchat = new JLabel ("Prix d'achat du véhicule par le garage : ");
        lbPrixDepart = new JLabel ("Prix de départ de la vente : ");
        lbPrixMin = new JLabel("Prix minimum accepté par le garage (facultatif) : ");
        lbPrixVente = new JLabel("Prix de vente du véhicule : ");
        lbEtat = new JLabel("Etat de la vente : ");
        lbCommercial = new JLabel("Commercial ayant réalisé la vente : ");
        lbNumChassis = new JLabel("Numéro de chassis du véhicule : ");
        lbClient = new JLabel ("Acheteur du véhicule : ");
        lbDateArrivee = new JLabel("Date d'arrivée au garage : ");
        lbDateVente = new JLabel("Date de vente : ");
        lbNbProprios = new JLabel("Nombre de propriétaires (facultatif) : ");
        lbDureeGarantie = new JLabel("Durée de la garantie (en mois) : ");
        lbDescription = new JLabel("Description/Commentaire de la vente (facultatif) : ");
        lbTVARecup = new JLabel("TVA Récuperable");
        lbModify = new JLabel("Modification d'une transaction");

        //Components
        txtKilometrage = new JTextField(currentTransaction.getKilometrage().toString());
        txtCouleur = new JTextField(currentTransaction.getCouleur());
        txtPrixAchat = new JTextField(currentTransaction.getPrixAchat().toString());
        txtPrixDepart = new JTextField(currentTransaction.getPrixDepart().toString());
        txtPrixMin = new JTextField();
        if (currentTransaction.getPrixMin() != null)
            txtPrixMin.setText(currentTransaction.getPrixMin().toString());
        txtPrixVente = new JTextField(currentTransaction.getPrixVente().toString());
        txtNbProprios = new JTextField();
        if (currentTransaction.getNbProprios() != null)
            txtNbProprios.setText(currentTransaction.getNbProprios().toString());


        cbEtat = new JComboBox<>(listeEtat);
        cbEtat.setSelectedItem(currentTransaction.getEtat());
        cbCommercial = new JComboBox<>();
        cbCommercial.setModel(new DefaultComboBoxModel<>(listeCommerciaux.toArray(new Commercial[0])));
        cbCommercial.setSelectedIndex(currentTransaction.getCommercial().getMatricule()-1);
        cbNumChassis = new JComboBox<>();
        cbNumChassis.setModel(new DefaultComboBoxModel<>(listeNumChassis.toArray(new FicheVehicule[0])));
        cbNumChassis.setSelectedIndex(getIndexChassis());
        cbClient = new JComboBox<>();
        cbClient.setModel(new DefaultComboBoxModel<>(listeClients.toArray(new Client[0])));
        cbClient.setSelectedIndex(currentTransaction.getClient().getId()-1);

        //DateSpinner
        SpinnerDateModel spDateModel = new SpinnerDateModel();
        spDateArrivee = new JSpinner();
        spDateArrivee.setModel(spDateModel);
        JSpinner.DateEditor spDateEditor = new JSpinner.DateEditor(spDateArrivee, "dd.MM.yyyy");
        DateFormatter spDateFormatter = (DateFormatter)spDateEditor.getTextField().getFormatter();
        spDateFormatter.setAllowsInvalid(false);
        spDateFormatter.setOverwriteMode(true);
        spDateArrivee.setEditor(spDateEditor);
        spDateArrivee.setValue(currentTransaction.getDateArrivee().getTime());

        SpinnerDateModel spDateModel2 = new SpinnerDateModel();
        spDateVente = new JSpinner();
        spDateVente.setModel(spDateModel2);
        JSpinner.DateEditor spDateEditor2 = new JSpinner.DateEditor(spDateVente, "dd.MM.yyyy");
        DateFormatter spDateFormatter2 = (DateFormatter)spDateEditor2.getTextField().getFormatter();
        spDateFormatter2.setAllowsInvalid(false);
        spDateFormatter2.setOverwriteMode(true);
        spDateVente.setEditor(spDateEditor2);
        spDateVente.setValue(currentTransaction.getDateVente().getTime());
        try{
            spDateModel.setStart(spDateEditor.getFormat().parse("01.01.1970"));
            spDateModel.setStart(spDateEditor2.getFormat().parse("01.01.1970"));
        }
        catch (ParseException e) {
            JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        //Simple Int Spinner
        SpinnerNumberModel spIntModel = new SpinnerNumberModel();
        spDureeGarantie = new JSpinner();
        spDureeGarantie.setModel(spIntModel);
        JSpinner.NumberEditor spIntEditor = new JSpinner.NumberEditor(spDureeGarantie);
        spIntEditor.getTextField().setEditable(false);
        spIntModel.setMinimum(0);
        spIntModel.setMaximum(24);
        spIntModel.setStepSize(6);
        spDureeGarantie.setEditor(spIntEditor);
        spDureeGarantie.setValue(currentTransaction.getDureeGarantie());

        taDescription = new JTextArea();
        taDescription.setLineWrap(true);
        taDescription.setWrapStyleWord(true);
        if (currentTransaction.getDescription() != null)
            taDescription.setText(currentTransaction.getDescription());

        cbxTVARecup = new JCheckBox();
        if (currentTransaction.isEstTVARecup())
            cbxTVARecup.setSelected(true);

        btnModifier = new JButton("Modifier la transaction");
        btnModifier.addActionListener(new BtnModifierListener());

        add(lbKilometrage);
        add(txtKilometrage);
        add(lbCouleur);
        add(txtCouleur);
        add(lbPrixAchat);
        add(txtPrixAchat);
        add(lbPrixDepart);
        add(txtPrixDepart);
        add(lbPrixMin);
        add(txtPrixMin);
        add(lbNbProprios);
        add(txtNbProprios);
        add(lbDescription);
        add(taDescription);
        add(lbDateArrivee);
        add(spDateArrivee);
        add(lbDureeGarantie);
        add(spDureeGarantie);
        add(lbTVARecup);
        add(cbxTVARecup);
        add(lbPrixVente);
        add(txtPrixVente);
        add(lbDateVente);
        add(spDateVente);
        add(lbEtat);
        add(cbEtat);
        add(lbCommercial);
        add(cbCommercial);
        add(lbNumChassis);
        add(cbNumChassis);
        add(lbClient);
        add(cbClient);
    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this.lbModify, BorderLayout.NORTH);
        fc.add(this, BorderLayout.CENTER);
        fc.add(this.btnModifier, BorderLayout.SOUTH);
        w.setSize(1500,500);
        w.setLocationRelativeTo(null);
        w.setTitle("Modification d'une transaction");
        fc.repaint();
        fc.revalidate();
    }

    public int getIndexChassis(){
        String currentChassis = this.currentTransaction.getFicheVehicule().getNumChassis();
        int indexChassis = 0;
        for (FicheVehicule ficheVeh : this.listeNumChassis){
            if (ficheVeh.getNumChassis().equals(currentChassis))
                indexChassis = listeNumChassis.indexOf(ficheVeh);
        }
        return indexChassis;
    }

    private class BtnModifierListener implements ActionListener {
        TransactionFormException error = new TransactionFormException();
        int errorCount;
        GregorianCalendar date = new GregorianCalendar();

        @Override
        public void actionPerformed(ActionEvent event){
            error.clear();
            errorCount = 0;

            //Kilometrage - PAS FACULTATIF - Integer
            if(!txtKilometrage.getText().equals("")) {
                if (controller.tryParseInt(txtKilometrage.getText())){
                    if(Integer.parseInt(txtKilometrage.getText()) < 0){
                        error.addError("Votre Kilométrage est inférieur à 0");
                        errorCount++;
                    }
                    else{
                        currentTransaction.setKilometrage(Integer.parseInt(txtKilometrage.getText()));
                    }
                }
                else {
                    error.addError("- Le kilométrage n'est pas un nombre");
                    errorCount++;
                }
            }
            else {
                error.addError("- Le kilométrage est vide");
                errorCount++;
            }

            //Couleur - PAS FACULTATIF - String
            if(!txtCouleur.getText().equals("")) {
                if (controller.checkIfMot(txtCouleur.getText()))
                    currentTransaction.setCouleur(txtCouleur.getText());
                else {
                    error.addError("- Votre couleur n'est pas un mot");
                    errorCount++;
                }
            }
            else {
                error.addError("- La couleur est vide");
                errorCount++;
            }

            //prixAchat - PAS FACULTATIF - Float
            if(!txtPrixAchat.getText().equals("")) {
                if (controller.tryParseFloat(txtPrixAchat.getText())) {
                    if(Float.parseFloat(txtPrixAchat.getText()) < 0){
                        error.addError("- Votre prix d'achat est inférieur à 0");
                        errorCount++;
                    }
                    else{
                        currentTransaction.setPrixAchat(Float.parseFloat(txtPrixAchat.getText()));
                    }
                }
                else {
                    error.addError("- Votre prix d'achat n'est pas un nombre");
                    errorCount++;
                }
            }
            else{
                error.addError("- Votre prix d'achat est vide");
                errorCount++;
            }

            //prixDepart - PAS FACULTATIF - Float
            if(!txtPrixDepart.getText().equals("")) {
                if (controller.tryParseFloat(txtPrixDepart.getText())){
                    if(Float.parseFloat(txtPrixDepart.getText()) < 0){
                        error.addError("- Votre prix est inférieur à 0");
                        errorCount++;
                    }
                    else{
                        currentTransaction.setPrixDepart(Float.parseFloat(txtPrixDepart.getText()));
                    }
                }
                else {
                    error.addError("- Votre prix de depart n'est pas un nombre");
                    errorCount++;
                }
            }
            else {
                error.addError("- Votre prix de depart est vide");
                errorCount++;
            }

            //prixMin - FACULTATIF - Float
            if(!txtPrixMin.getText().equals("")) {
                if (controller.tryParseFloat(txtPrixMin.getText())){
                    if(Float.parseFloat(txtPrixMin.getText()) < 0){
                        error.addError("- Votre prix minimum est inférieur à 0");
                        errorCount++;
                    }
                    else{
                        if(Float.parseFloat(txtPrixMin.getText()) > Float.parseFloat(txtPrixVente.getText())){
                            error.addError("- Votre prix de vente est plus petit que le prix minimum");
                        }

                        if(Float.parseFloat(txtPrixMin.getText()) > Float.parseFloat(txtPrixDepart.getText())){
                            error.addError("- Votre prix de départ est plus petit que le prix minimum");
                            errorCount++;
                        }

                        currentTransaction.setPrixMin(Float.parseFloat(txtPrixMin.getText()));
                    }
                }
                else {
                    error.addError("- Votre prix minimum n'est pas un nombre");
                    errorCount++;
                }
            }

            //nbProprios - FACULTATIF - Integer
            if(!txtNbProprios.getText().equals("")) {
                if (controller.tryParseInt(txtNbProprios.getText())){
                    if(Integer.parseInt(txtNbProprios.getText()) < 0){
                        error.addError("Votre nombre de propriétaire est inférieur à 0");
                        errorCount++;
                    }
                    else{
                        currentTransaction.setNbProprios(Integer.parseInt(txtNbProprios.getText()));
                    }
                }

                else {
                    error.addError("- Votre nombre de propriétaire(s) n'est pas un nombre");
                    errorCount++;
                }
            }

            //description - FACULTATIF - String
            if(!taDescription.getText().equals("")){
                currentTransaction.setDescription(taDescription.getText());
            }

            //dateArrivee - PAS FACULTATIF - GregorianDate
            if(controller.checkDateIsPrior((Date)spDateArrivee.getValue())){
                date.setTime((Date)spDateArrivee.getValue());
                currentTransaction.setDateArrivee(date);
            }
            else{
                error.addError("- La date d'arrivée est supérieure à la date du jour");
                errorCount++;
            }

            //dureeGarantie - PAS FACULTATIF - Integer
            currentTransaction.setDureeGarantie((Integer)spDureeGarantie.getValue());

            //estTVARecup - PAS FACULTATIF - Boolean
            if(cbxTVARecup.isSelected())
                currentTransaction.setEstTVARecup(1);

            //prixVente - PAS FACULTATIF - Float
            if(!txtPrixVente.getText().equals("")) {
                if (controller.tryParseFloat(txtPrixVente.getText())){
                    if(Float.parseFloat(txtPrixVente.getText()) < 0){
                        error.addError("- Votre prix de vente est inférieur à 0");
                        errorCount++;
                    }
                    else{
                        currentTransaction.setPrixVente(Float.parseFloat(txtPrixVente.getText()));
                    }
                }

                else {
                    error.addError("- Votre prix de vente n'est pas correct");
                    errorCount++;
                }
            }
            else {
                error.addError("- Votre prix de vente est vide");
                errorCount++;
            }

            //dateVente - PAS FACULTATIF - GregorianDate
            if(controller.checkDateIsPrior((Date)spDateVente.getValue())){
                date.setTime((Date)spDateVente.getValue());
                currentTransaction.setDateVente(date);
            }
            else {
                error.addError("- La date de vente est supérieure à la date du jour");
                errorCount++;
            }

            if((((Date) spDateVente.getValue()).compareTo((Date) spDateArrivee.getValue())) >= 0){
                date.setTime((Date)spDateVente.getValue());
                currentTransaction.setDateVente(date);
            }
            else {
                error.addError("- La date de vente est inférieure à la date d'arrivée");
                errorCount++;
            }

            //etat - PAS FACULTATIF - String
            currentTransaction.setEtat((String)cbEtat.getSelectedItem());
            //Commercial (matricule) - PAS FACULTATIF - Integer
            currentTransaction.setCommercial(new Commercial(listeCommerciaux.get(cbCommercial.getSelectedIndex()).getMatricule()));
            //numChassis - PAS FACULTATIF - String
            currentTransaction.setFicheVehicule(new FicheVehicule(cbNumChassis.getSelectedItem().toString()));
            //Client (idClient) - PAS FACULTATIF - Integer
            currentTransaction.setClient(new Client(listeClients.get(cbClient.getSelectedIndex()).getId()));
            if(errorCount == 0) {
                try {
                    controller.updateTransaction(currentTransaction);
                    JOptionPane.showMessageDialog(w, "Modification effectuée", "Ajout à la BDD", JOptionPane.INFORMATION_MESSAGE);
                } catch (ConnectionException | UpdateTransactionException | TransactionFormException e) {
                    JOptionPane.showMessageDialog(w, e.toString(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                new ListingPanel(w).setPanel();
            }
            else
                JOptionPane.showMessageDialog(w,error.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void setController(TransactionController controller){
        this.controller = controller;
    }
}
