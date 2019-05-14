package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetMagasinException;
import exceptionPackage.GetMarqueException;
import exceptionPackage.GetModeleException;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RechercheModele extends JPanel {
    private TransactionController controller;
    private PrincipalWindow w;
    private JButton btnRecherche;
    private JComboBox<Marque> cbMarque;
    private JComboBox<Modele> cbModele;
    private JComboBox<Magasin> cbMagasin;
    private ArrayList<Marque> listeMarques;
    private ArrayList<Modele> listeModeles;
    private ArrayList<Magasin> listeMagasins;
    private JLabel lblMarque, lblModele, lblMagasin, lblObjectif;

    public RechercheModele(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
        setLayout(new GridLayout(3,3));
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

        btnRecherche = new JButton("Effectuer la recherche");
        btnRecherche.addActionListener(new BtnRechercheListener());
        lblObjectif = new JLabel("Rechercher les véhicules d'un certain modéle vendu dans un magasin choisis");

    }

    private class BtnRechercheListener implements ActionListener {
        Integer idModele;
        Integer idMagasin;
        @Override
        public void actionPerformed(ActionEvent event) {
            idModele = cbModele.getItemAt(cbModele.getSelectedIndex()).getID();
            idMagasin = cbMagasin.getItemAt(cbMagasin.getSelectedIndex()).getId();
            new ResultatPanel(w,idModele, idMagasin);
        }
    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this.lblObjectif, BorderLayout.NORTH);
        fc.add(this, BorderLayout.CENTER);
        fc.add(this.btnRecherche, BorderLayout.SOUTH);
        w.setTitle("Recherche des transactions");
        w.setSize(500,300);
        w.setLocationRelativeTo(null);
        fc.repaint();
        fc.revalidate();
        filtering();
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }

    private class CbMarqueAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            filtering();
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
