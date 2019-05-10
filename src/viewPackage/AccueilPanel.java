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
    public AccueilPanel(PrincipalWindow w){
        setLayout(new GridLayout(2,2));
        this.w = w;
        texteBienvenue = new JTextField("Bienvenue, sélectionnez une option");
        btnList = new JButton("Lister les transactions");
        btnAjout = new JButton("Ajouter une transaction");
        btnRecherche = new JButton("Rechercher une transaction");
        this.add(btnList);
        this.add(btnAjout);
        this.add(btnRecherche);
    }

    private class BtnListeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

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
        w.setTitle("Acceuil");
        repaint();
        revalidate();
    }


}
