package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetClientException;
import exceptionPackage.GetCommercialException;
import exceptionPackage.GetFicheVehException;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

public class ModificationPanel extends JPanel {
    private PrincipalWindow w;
    private JTextField txtKilometrage, txtCouleur, txtPrixAchat, txtPrixDepart, txtPrixMin, txtPrixVente;
    private JComboBox<String> cbEtat, cbCommercial, cbNumChassis, cbClient;
    private JSpinner spDateArrivee, spDateVente, spNbProprios, spDureeGarantie;
    private JTextArea taDescription;
    private JCheckBox cbxTVARecup;
    private JLabel lbKilometrage, lbCouleur, lbPrixAchat, lbPrixDepart, lbPrixMin, lbPrixVente, lbEtat, lbCommercial,
            lbNumChassis, lbClient, lbDateArrivee, lbDateVente, lbNbProprios, lbDureeGarantie, lbDescription, lbTVARecup;
    private JButton btnAjouter;
    private TransactionController controller;
    private AllCommerciauxModel modelCom;
    private AllClientsModel modelClient;
    private AllNumChassis modelNumChassis;

    private ArrayList<Client> listeClients;
    private ArrayList<Commercial> listeCommerciaux;
    private ArrayList<FicheVehicule> listeNumChassis;
    private String[] listeEtat = {"attente","vendue"};

    public ModificationPanel(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
        setLayout(new GridLayout(8,4,200,20));

        try{
            modelCom = new AllCommerciauxModel(controller.getAllCommerciaux()) ;
            modelClient = new AllClientsModel(controller.getAllClients());
            modelNumChassis = new AllNumChassis(controller.getAllNumChassis());
        }
        catch (GetClientException | ConnectionException | GetCommercialException | GetFicheVehException e){
            JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        //Label
        lbKilometrage = new JLabel("Kilometrage du vehicule : ");
        lbCouleur = new JLabel("Couleur du véhicule : ");
        lbPrixAchat = new JLabel ("Prix d'achat du véhicule par le garage : ");
        lbPrixDepart = new JLabel ("Prix de départ de la vente : ");
        lbPrixMin = new JLabel("Prix minimum accepté par le garage : ");
        lbPrixVente = new JLabel("Prix de vente du véhicule : ");
        lbEtat = new JLabel("Etat de la vente : ");
        lbCommercial = new JLabel("Commercial ayant réalisé la vente : ");
        lbNumChassis = new JLabel("Numéro de chassis du véhicule : ");
        lbClient = new JLabel ("Acheteur du véhicule : ");
        lbDateArrivee = new JLabel("Date d'arrivée au garage : ");
        lbDateVente = new JLabel("Date de vente : ");
        lbNbProprios = new JLabel("Nombre de propriétaires : ");
        lbDureeGarantie = new JLabel("Durée de la garantie : ");
        lbDescription = new JLabel("Description/Commentaire de la vente : ");
        lbTVARecup = new JLabel("TVA Récuperable");

        //Components
        txtKilometrage = new JTextField();
        txtCouleur = new JTextField();
        txtPrixAchat = new JTextField();
        txtPrixDepart = new JTextField();
        txtPrixMin= new JTextField();
        txtPrixVente= new JTextField();;


        cbEtat = new JComboBox(listeEtat);
        cbCommercial = new JComboBox(modelCom);
        cbNumChassis = new JComboBox(modelNumChassis);
        cbClient = new JComboBox(modelClient);

        //DateSpinner
        SpinnerDateModel spDateModel = new SpinnerDateModel();
        spDateArrivee = new JSpinner();
        spDateArrivee.setModel(spDateModel);
        JSpinner.DateEditor spDateEditor1 = new JSpinner.DateEditor(spDateArrivee, "dd-MM-yyyy");
        spDateArrivee.setEditor(spDateEditor1);
        spDateVente = new JSpinner();
        spDateVente.setModel(spDateModel);
        JSpinner.DateEditor spDateEditor2 = new JSpinner.DateEditor(spDateArrivee, "dd-MM-yyyy");
        spDateVente.setEditor(spDateEditor2);
        try{
            spDateModel.setStart(spDateEditor1.getFormat().parse("01-01-1970"));
            spDateModel.setStart(spDateEditor2.getFormat().parse("01-01-1970"));
        }
        catch (ParseException e) {
            JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        //Simple Int Spinner
        SpinnerNumberModel spIntModel = new SpinnerNumberModel();
        spNbProprios = new JSpinner();
        spNbProprios.setModel(spIntModel);
        JSpinner.NumberEditor spIntEditor1 = new JSpinner.NumberEditor(spNbProprios);
        spNbProprios.setEditor(spIntEditor1);
        spDureeGarantie = new JSpinner();
        spDureeGarantie.setModel(spIntModel);
        JSpinner.NumberEditor spIntEditor2 = new JSpinner.NumberEditor(spNbProprios);
        spDureeGarantie.setEditor(spIntEditor2);

        taDescription = new JTextArea();

        cbxTVARecup = new JCheckBox();

        btnAjouter = new JButton("Modifier la transaction");

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
        add(spNbProprios);
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
        w.setTitle("Modification d'une transaction");
        fc.repaint();
        fc.revalidate();
    }

    private class BtnModifierListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            new ModificationPanel(w).setPanel();
        }
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }
}
