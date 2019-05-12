package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.*;
import modelPackage.*;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AjoutPanel extends JPanel {
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
            lbNumChassis, lbClient, lbDateArrivee, lbDateVente, lbNbProprios, lbDureeGarantie, lbDescription, lbTVARecup;
    private JButton btnAjouter;
    private TransactionController controller;

    private ArrayList<Client> listeClients;
    private ArrayList<Commercial> listeCommerciaux;
    private ArrayList<FicheVehicule> listeNumChassis;
    private String[] listeEtat = {"attente","vendue"};

    public AjoutPanel(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
        setLayout(new GridLayout(8,4,200,20));

        try{
            listeCommerciaux = controller.getAllCommerciaux() ;
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

        //Components
        txtKilometrage = new JTextField();
        txtCouleur = new JTextField();
        txtPrixAchat = new JTextField();
        txtPrixDepart = new JTextField();
        txtPrixMin= new JTextField();
        txtPrixVente= new JTextField();;
        txtNbProprios = new JTextField();


        cbEtat = new JComboBox(listeEtat);
        cbCommercial = new JComboBox<>();
        cbCommercial.setModel(new DefaultComboBoxModel<>(listeCommerciaux.toArray(new Commercial[0])));
        cbNumChassis = new JComboBox<>();
        cbNumChassis.setModel(new DefaultComboBoxModel<>(listeNumChassis.toArray(new FicheVehicule[0])));
        cbClient = new JComboBox<>();
        cbClient.setModel(new DefaultComboBoxModel<>(listeClients.toArray(new Client[0])));

        //DateSpinner
        SpinnerDateModel spDateModel = new SpinnerDateModel();
        spDateArrivee = new JSpinner();
        spDateArrivee.setModel(spDateModel);
        JSpinner.DateEditor spDateEditor = new JSpinner.DateEditor(spDateArrivee, "dd.MM.yyyy");
        DateFormatter spDateFormatter = (DateFormatter)spDateEditor.getTextField().getFormatter();
        spDateFormatter.setAllowsInvalid(false);
        spDateFormatter.setOverwriteMode(true);
        spDateArrivee.setEditor(spDateEditor);

        SpinnerDateModel spDateModel2 = new SpinnerDateModel();
        spDateVente = new JSpinner();
        spDateVente.setModel(spDateModel2);
        JSpinner.DateEditor spDateEditor2 = new JSpinner.DateEditor(spDateVente, "dd.MM.yyyy");
        DateFormatter spDateFormatter2 = (DateFormatter)spDateEditor2.getTextField().getFormatter();
        spDateFormatter2.setAllowsInvalid(false);
        spDateFormatter2.setOverwriteMode(true);
        spDateVente.setEditor(spDateEditor2);
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

        taDescription = new JTextArea();

        cbxTVARecup = new JCheckBox();

        btnAjouter = new JButton("Ajouter la transaction");
        btnAjouter.addActionListener(new BtnAjouterListener());

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
        fc.add(this, BorderLayout.CENTER);
        fc.add(this.btnAjouter, BorderLayout.SOUTH);
        w.setTitle("Ajout d'une transaction");
        fc.repaint();
        fc.revalidate();
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }

    private class BtnAjouterListener implements ActionListener {
        AddTransactionFormException error = new AddTransactionFormException();
        Transaction transaction = new Transaction(0);
        int errorCount = 0;
        GregorianCalendar date = new GregorianCalendar();

        @Override
        public void actionPerformed(ActionEvent event){
            errorCount = 0;
            error.clear();

            //Kilometrage - PAS FACULTATIF - Integer
            if(!txtKilometrage.getText().equals("")) {
                if (controller.tryParseInt(txtKilometrage.getText()))
                    transaction.setKilometrage(Integer.parseInt(txtKilometrage.getText()));
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
                    transaction.setCouleur(txtCouleur.getText());
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
                    transaction.setPrixAchat(Float.parseFloat(txtPrixAchat.getText()));
                }
                else {
                    error.addError("- Votre prix d'achat n'est pas correct");
                    errorCount++;
                }
            }
            else{
                error.addError("- Votre prix d'achat est vide");
                errorCount++;
            }

            //prixDepart - PAS FACULTATIF - Float
            if(!txtPrixDepart.getText().equals("")) {
                if (controller.tryParseFloat(txtPrixDepart.getText()))
                    transaction.setPrixDepart(Float.parseFloat(txtPrixDepart.getText()));
                else {
                    error.addError("- Votre prix de depart n'est pas correct");
                    errorCount++;
                }
            }
            else {
                error.addError("- Votre prix de depart est vide");
                errorCount++;
            }

            //prixMin - FACULTATIF - Float
            if(!txtPrixMin.getText().equals("")) {
                if (controller.tryParseFloat(txtPrixMin.getText()))
                    transaction.setPrixMin(Float.parseFloat(txtPrixMin.getText()));
                else {
                    error.addError("- Votre prix minimum n'est pas correct");
                    errorCount++;
                }
            }

            //nbProprios - FACULTATIF - Integer
            if(!txtNbProprios.getText().equals("")) {
                if (controller.tryParseInt(txtNbProprios.getText()))
                    transaction.setNbProprios(Integer.parseInt(txtNbProprios.getText()));
                else {
                    error.addError("- Votre nombre de propriétaire(s) n'est pas correct");
                    errorCount++;
                }
            }

            //description - FACULTATIF - String
            if(!taDescription.getText().equals("")){
                transaction.setDescription(taDescription.getText());
            }

            //dateArrivee - PAS FACULTATIF - GregorianDate
            if(controller.checkDateIsPrior((Date)spDateArrivee.getValue())){
                date.setTime((Date)spDateArrivee.getValue());
                transaction.setDateArrivee(date);
            }
            else{
                error.addError("- La date d'arrivée est supérieure à la date du jour");
                errorCount++;
            }

            //dureeGarantie - PAS FACULTATIF - Integer
            transaction.setDureeGarantie((Integer)spDureeGarantie.getValue());

            //estTVARecup - PAS FACULTATIF - Boolean
            if(cbxTVARecup.isSelected())
                transaction.setEstTVARecup(1);

            //prixVente - PAS FACULTATIF - Float
            if(!txtPrixVente.getText().equals("")) {
                if (controller.tryParseFloat(txtPrixVente.getText()))
                    transaction.setPrixVente(Float.parseFloat(txtPrixVente.getText()));
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
                transaction.setDateVente(date);
            }
            else {
                error.addError("- La date de vente est supérieure à la date du jour");
                errorCount++;
            }

            //etat - PAS FACULTATIF - String
            transaction.setEtat((String)cbEtat.getSelectedItem());
            //Commercial (matricule) - PAS FACULTATIF - Integer
            transaction.setCommercial(new Commercial(listeCommerciaux.get(cbCommercial.getSelectedIndex()).getMatricule()));
            //numChassis - PAS FACULTATIF - String
            transaction.setFicheVehicule(new FicheVehicule(cbNumChassis.getSelectedItem().toString()));
            //Client (idClient) - PAS FACULTATIF - Integer
            transaction.setClient(new Client(listeClients.get(cbClient.getSelectedIndex()).getId()));
            if(errorCount == 0)
                try {
                    JOptionPane.showMessageDialog(w,controller.ajouteTransaction(transaction) + " transactions ajoutée", "Ajout à la BDD", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (ConnectionException | AddTransactionException e){
                    JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            else
                JOptionPane.showMessageDialog(w,error.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}