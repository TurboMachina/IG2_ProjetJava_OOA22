package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RecherchePanel extends JPanel {
    private PrincipalWindow w;
    private ButtonGroup rbGroup;
    private JRadioButton bTr, bVh, bMo;
    private PanelChampsRecherche pcr;
    public RecherchePanel(PrincipalWindow w){
        this.w = w;
        JLabel message = new JLabel("Sélectionnez un critère à rechercher :");
        bTr = new JRadioButton("Transaction");
        bVh = new JRadioButton("Véhicule");
        bMo = new JRadioButton("Modèle");

        this.add(message);
        this.add(bTr);
        this.add(bVh);
        this.add(bMo);
        rbGroup = new ButtonGroup();
        rbGroup.add(bTr);
        rbGroup.add(bVh);
        rbGroup.add(bMo);
        RadioButtonListener listener = new RadioButtonListener();
        bTr.addItemListener(listener);
        bVh.addItemListener(listener);
        bMo.addItemListener(listener);

        pcr = new PanelChampsRecherche();
        this.add(pcr, BorderLayout.SOUTH);

    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.CENTER);
        w.setTitle("Recherche");
        repaint();
        revalidate();
    }

    private class RadioButtonListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == bTr && event.getStateChange()== ItemEvent.SELECTED){

            }
            if (event.getSource() == bVh && event.getStateChange()== ItemEvent.SELECTED){

            }
            if (event.getSource() == bMo && event.getStateChange()== ItemEvent.SELECTED){

            }
        }
    }

    private class PanelChampsRecherche extends JPanel{
        private JLabel matricule, adresseMag, libMarque, titreModèle, dateVente;
        private JTextField jtMatricule;
        private JComboBox jcAdresseMag, jcLibelléMarque, jcTitreModèle;
        private JSpinner jsDateVente;
        public PanelChampsRecherche(){
            this.setLayout(new GridLayout(4,2,5,5));
            matricule = new JLabel("Matricule ");
            adresseMag = new JLabel("Adresse du magasin ");
            libMarque = new JLabel("Libellé marque ");
            titreModèle = new JLabel("Titre modèle ");
            dateVente = new JLabel("Date de vente ");
            jtMatricule = new JTextField();
            jcAdresseMag = new JComboBox();
            jcLibelléMarque = new JComboBox();
            jcTitreModèle = new JComboBox();
            jsDateVente = new JSpinner();
            this.add(matricule);
            this.add(jtMatricule);
            this.add(adresseMag);
            this.add(jcAdresseMag);
            this.add(libMarque);
            this.add(jcLibelléMarque);
            this.add(titreModèle);
            this.add(jcTitreModèle);
            this.add(dateVente);
            this.add(jsDateVente);
        }
    }
/*
    private class ChampsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == matricule){

            }
            if (event.getSource() == jcAdresseMag){

            }
            if (event.getSource() == jcLibelléMarque){

            }
            if (event.getSource() == matricule){

            }
        }
    }*/

}
