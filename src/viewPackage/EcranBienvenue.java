package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EcranBienvenue extends JFrame {
    private Container frameContainer;
    private PanelLander pl;
    private BottomButtonsPanel bbp;

    public EcranBienvenue() {
        super("Acceuil");

        setBounds(100, 100, 750, 500);

        pl = new PanelLander();
        bbp = new BottomButtonsPanel();
        frameContainer = this.getContentPane();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(pl, BorderLayout.CENTER);
        frameContainer.add(bbp, BorderLayout.SOUTH);


        setVisible(true);
    }


    private class BottomButtonsPanel extends JPanel {
        private JButton ajoutVeh, vendreVeh, supprCommercial, listeTransac, listeVeh, listeClient;

        public BottomButtonsPanel() {
            ajoutVeh = new JButton("Ajouter un nouveau véhicule au catalogue");
            vendreVeh = new JButton("Vendre un véhicule disponible");
            supprCommercial = new JButton("Supprimer un commercial");
            listeTransac = new JButton("Lister les transactions effectuées");
            listeVeh = new JButton("Lister les véhicules en stock");
            listeClient = new JButton("Lister les clients précédents");

            this.setLayout(new GridLayout(2, 3));

            this.add(ajoutVeh);
            this.add(vendreVeh);
            this.add(supprCommercial);
            this.add(listeTransac);
            this.add(listeVeh);
            this.add(listeClient);
        }
    }

    private class PanelLander extends JPanel {
        private JLabel ligneBienvenue, ligneSelection;

        public PanelLander() {
            ligneBienvenue = new JLabel("Bienvenue.");
            ligneSelection = new JLabel("Selectionnez une action à effectuer.");
            this.setLayout(new FlowLayout());
            this.add(ligneBienvenue);
            this.add(ligneSelection);
        }

    }
}