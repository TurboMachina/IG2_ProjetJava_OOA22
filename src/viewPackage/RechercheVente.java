package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.*;
import modelPackage.Magasin;
import modelPackage.Marque;
import modelPackage.Modele;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class RechercheVente extends JPanel {
    private TransactionController controller;
    private PrincipalWindow w;
    private JSpinner spDateDebut, spDateFin;
    private JComboBox<Modele> cbModele;
    private JComboBox<Magasin> cbMagasin;
    private JComboBox<Marque> cbMarque;
    private ArrayList<Modele> listeModeles;
    private ArrayList<Magasin> listeMagasins;
    private ArrayList<Marque> listeMarques;
    private JButton btnRecherche;
    private JLabel lblMarque, lblModele, lblMagasin, lblDateDeb, lblDateFin, lblObjectif;

    public RechercheVente(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
        setLayout(new GridLayout(5,3));
        try{
            listeMarques = controller.getAllMarques();
            listeModeles = controller.getAllModeles();
            listeMagasins = controller.getAllMagasins();

        }
        catch (ConnectionException | GetMarqueException | GetModeleException | GetMagasinException e){
            JOptionPane.showMessageDialog(w, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        lblMagasin = new JLabel("Choisissez un magasin :");
        lblMarque = new JLabel("Choisissez une marque :");
        lblModele = new JLabel("Choisissez un modele :");
        lblDateDeb = new JLabel("Choisissez une date de départ :");
        lblDateFin = new JLabel("Choisissez une date de fin :");

        SpinnerDateModel spDateModel = new SpinnerDateModel();
        spDateDebut = new JSpinner();
        spDateDebut.setModel(spDateModel);
        JSpinner.DateEditor spDateEditor = new JSpinner.DateEditor(spDateDebut, "dd.MM.yyyy");
        DateFormatter spDateFormatter = (DateFormatter)spDateEditor.getTextField().getFormatter();
        spDateFormatter.setAllowsInvalid(false);
        spDateFormatter.setOverwriteMode(true);
        spDateDebut.setEditor(spDateEditor);

        SpinnerDateModel spDateModel2 = new SpinnerDateModel();
        spDateFin = new JSpinner();
        spDateFin.setModel(spDateModel2);
        JSpinner.DateEditor spDateEditor2 = new JSpinner.DateEditor(spDateFin, "dd.MM.yyyy");
        DateFormatter spDateFormatter2 = (DateFormatter)spDateEditor2.getTextField().getFormatter();
        spDateFormatter2.setAllowsInvalid(false);
        spDateFormatter2.setOverwriteMode(true);
        spDateFin.setEditor(spDateEditor2);


        cbMagasin = new JComboBox<>();
        cbMagasin.setModel(new DefaultComboBoxModel<>(listeMagasins.toArray(new Magasin[0])));
        cbMarque = new JComboBox<>();
        cbMarque.setModel(new DefaultComboBoxModel<>(listeMarques.toArray(new Marque[0])));
        cbMarque.addActionListener(new CbMarqueAction());
        cbModele = new JComboBox<>();
        cbModele.setEnabled(false);

        add(lblMagasin);
        add(cbMagasin);
        add(lblMarque);
        add(cbMarque);
        add(lblModele);
        add(cbModele);
        add(lblDateDeb);
        add(spDateDebut);
        add(lblDateFin);
        add(spDateFin);


        btnRecherche = new JButton("Effectuer la recherche");
        btnRecherche.addActionListener(new BtnRechercheListener());
        lblObjectif = new JLabel("Rechercher les véhicules vendus dans un magasins spécifique entre deux dates");
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }

    public void setPanel(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this.lblObjectif, BorderLayout.NORTH);
        fc.add(this, BorderLayout.CENTER);
        fc.add(this.btnRecherche, BorderLayout.SOUTH);
        w.setTitle("Recherche des transactions");
        w.setSize(500,300);
        w.setLocationRelativeTo(null);;
        fc.repaint();
        fc.revalidate();
        filtering();
    }

    private class CbMarqueAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            filtering();
        }
    }

    private class BtnRechercheListener implements ActionListener {
        Integer idModele, idMagasin, errorCount;
        GregorianCalendar dateDebut = new GregorianCalendar();
        GregorianCalendar dateFin = new GregorianCalendar();
        RechercheFormException error = new RechercheFormException();
        @Override
        public void actionPerformed(ActionEvent event) {
            errorCount = 0;
            error.clear();

            idModele = cbModele.getItemAt(cbModele.getSelectedIndex()).getID();
            idMagasin = cbMagasin.getItemAt(cbMagasin.getSelectedIndex()).getId();

            //DateDebut aprés DateJour
            if(controller.checkDateIsPrior((Date)spDateDebut.getValue())){
                dateDebut.setTime((Date)spDateDebut.getValue());
            }
            else{
                error.addError("- La date de début est supérieure à la date du jour");
                errorCount++;
            }
            //DateFin après DateJour
            if(controller.checkDateIsPrior((Date)spDateFin.getValue())){
                dateFin.setTime((Date)spDateFin.getValue());
            }
            else{
                error.addError("- La date de fin est supérieure à la date du jour");
                errorCount++;
            }
            //DateFin avant DateDébut
            if((((Date) spDateFin.getValue()).compareTo((Date) spDateDebut.getValue())) > 0){
                dateFin.setTime((Date)spDateFin.getValue());
            }
            else{
                error.addError("- La date de fin est inférieure à la date de début");
                errorCount++;
            }
            if (errorCount == 0){
                new ResultatPanel(w,idModele, idMagasin);
            }
            else
                JOptionPane.showMessageDialog(w,error.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);


            if(errorCount == 0){
                new ResultatPanel(w,dateDebut, dateFin, idModele, idMagasin);
            }
        }
    }

    private void filtering(){
        String currentMarque = listeMarques.get(cbMarque.getSelectedIndex()).getLibelle();
        cbModele.removeAllItems();
        cbModele.setModel(new DefaultComboBoxModel<>(listeModeles.toArray(new Modele [0])));
        for(Modele modele : listeModeles){
            if (!modele.getMarque().getLibelle().equals(currentMarque)){
                cbModele.removeItem(modele);
            }
        }
        cbModele.setEnabled(true);
    }

}
