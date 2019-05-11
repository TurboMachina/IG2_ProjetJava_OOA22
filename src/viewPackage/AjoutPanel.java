package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetClientException;
import exceptionPackage.GetCommercialException;
import exceptionPackage.GetFicheVehException;
import javafx.scene.control.ComboBox;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AjoutPanel extends JPanel {
    private PrincipalWindow w;
    private JTextField txtKilometrage, txtCouleur, txtPrixAchat, txtPrixDepart, txtPrixMin, txtPrixVente;
    private JComboBox<String> cbEtat, cbCommercial, cbNumChassis, cbClient;
    private JSpinner spDateArrivee, spDateVente, spNbProprios, spDureeGarantie;
    private JTextArea taDescription;
    private JCheckBox cbTVARecup;
    private JLabel lbKilometrage, lbCouleur, lbPrixAchat, lbPrixDepart, lbPrixMin, lbPrixVente, lbEtat, lbCommercial,
            lbNumChassis, lbClient, lbDateArrivee, lbDateVente, lbNbProprios, lbDureeGarantie, lbDescription, lbTVARecup;
    private TransactionController controller;
    private AllCommerciauxModel modelCom;
    private AllClientsModel modelClient;
    private AllNumChassis modelNumChassis;

    private ArrayList<Client> listeClients;
    private ArrayList<Commercial> listeCommerciaux;
    private ArrayList<FicheVehicule> listeNumChassis;
    private String[] listeEtat = {"attente","vendue"};

    public AjoutPanel(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
        setLayout(new GridLayout(8,4));

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

        spDateArrivee = new JSpinner();
        spDateVente = new JSpinner();
        spNbProprios = new JSpinner();
        spDureeGarantie = new JSpinner();

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
    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.SOUTH);
        w.setTitle("Ajout d'une transaction");
        fc.repaint();
        fc.revalidate();
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }
}