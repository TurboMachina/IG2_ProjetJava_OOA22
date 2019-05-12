package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetCommercialException;
import exceptionPackage.GetMarqueException;
import modelPackage.Commercial;
import modelPackage.Marque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RechercheTransaction extends JPanel {
    private TransactionController controller;
    private PrincipalWindow w;
    private JLabel lbCommercial, lbMarque, lblObjectif;
    private JComboBox<Commercial> cbCommercial;
    private JComboBox<Marque> cbMarque;
    private JButton btnRecherche;
    private ArrayList<Commercial> listeCommerciaux;
    private ArrayList<Marque> listeMarque;

    public RechercheTransaction(PrincipalWindow w){
        this.w = w;
        setController(new TransactionController());
        setLayout(new GridLayout(2,2));
        try{
            listeCommerciaux = controller.getAllCommerciaux();
            listeMarque = controller.getAllMarques();
        }catch (ConnectionException | GetMarqueException | GetCommercialException e){
            JOptionPane.showMessageDialog(w,e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
        }

        lbCommercial = new JLabel("Choisissez un commercial :");
        cbCommercial = new JComboBox<>();
        cbCommercial.setModel(new DefaultComboBoxModel<>(listeCommerciaux.toArray(new Commercial[0])));
        cbCommercial.setMaximumSize(new Dimension(20,20));

        lbMarque = new JLabel("Choisissez une marque :");
        cbMarque = new JComboBox<>();
        cbMarque.setModel(new DefaultComboBoxModel<>(listeMarque.toArray(new Marque[0])));

        add(lbCommercial);
        add(cbCommercial);
        add(lbMarque);
        add(cbMarque);

        btnRecherche = new JButton("Effectuer la recherche");
        btnRecherche.addActionListener(new BtnRechercheListener());
        lblObjectif = new JLabel("Rechercher les transactions effectuées par un commercial et une marque donnée");

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
        w.setLocationRelativeTo(null);
        fc.repaint();
        fc.revalidate();

    }

    private class BtnRechercheListener implements ActionListener {
        private Integer matricule;
        private String marque;
        @Override
        public void actionPerformed(ActionEvent event) {
            matricule = listeCommerciaux.get(cbCommercial.getSelectedIndex()).getMatricule();
            marque = (String)cbMarque.getSelectedItem();
            new ResultatPanel(w, matricule, marque).setPanel();
        }
    }



    public void setController(TransactionController controller){
        this.controller = controller;
    }

}
