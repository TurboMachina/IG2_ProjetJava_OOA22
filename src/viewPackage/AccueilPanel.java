package viewPackage;

import javax.swing.*;
import controllerPackage.*;
import modelPackage.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilPanel extends JPanel {
    private PrincipalWindow w;
    private JButton btnList, btnAjout, btnRecherche;
    private JTextField texteBienvenue;
    private JLabel lblBienvenue;
    public AccueilPanel(PrincipalWindow w){
        setLayout(new GridLayout(3,1));
        this.w = w;
        lblBienvenue = new JLabel("<html> Bienvenue, veuillez choisir une option dans le menu ci-dessous. " +
                "<br/>Pour supprimer ou modifier une transacation vous devez passer par le listing </html>", SwingConstants.CENTER);
        texteBienvenue = new JTextField("Bienvenue, sélectionnez une option");
        btnList = new JButton("Lister les transactions");
        btnAjout = new JButton("Ajouter une transaction");
        btnRecherche = new JButton("Rechercher une transaction");
        btnList.addActionListener(new BtnListeListener());
        this.add(btnList);
        this.add(btnAjout);
        this.add(btnRecherche);
    }

    private class BtnListeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            new ListingPanel(w).setPanel();
        }
    }
    private class BtnAjoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

        }
    }
    private class BtnRechercheListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

        }
    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.SOUTH);
        fc.add(lblBienvenue, BorderLayout.CENTER);
        w.setTitle("Acceuil");
        repaint();
        revalidate();
    }


}
