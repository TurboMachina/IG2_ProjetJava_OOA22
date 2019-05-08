package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EcranBienvenue extends JFrame {

    public EcranBienvenue() {
        super("Acceuil");
        setBounds(100, 100, 750, 500);

        Container frameContainer = this.getContentPane();
        PanelLander pl = new PanelLander();
        BottomButtonsPanel bbp = new BottomButtonsPanel();
        frameContainer.setLayout(new BorderLayout());

        frameContainer.add(pl, BorderLayout.CENTER);
        frameContainer.add(bbp, BorderLayout.SOUTH);

        ClosingWindow closer = new ClosingWindow();
        this.addWindowListener(closer);

        setVisible(true);
    }


    private class BottomButtonsPanel extends JPanel {

        BottomButtonsPanel() {
            JButton ajoutVeh = new JButton("Ajouter un nouveau véhicule au catalogue");
            JButton vendreVeh = new JButton("Vendre un véhicule disponible");
            JButton modifierTransaction = new JButton("Modifier la transaction.");
            JButton quitter = new JButton("Quitter");


            this.setLayout(new GridLayout(2, 2)); // RESET

            this.add(ajoutVeh);
            this.add(vendreVeh);
            this.add(modifierTransaction);
            this.add(quitter);
        }
    }

    private class PanelLander extends JPanel {

        PanelLander() {
            this.setLayout(new FlowLayout());
            JLabel ligneBienvenue = new JLabel("Bienvenue.");
            JLabel ligneSelection = new JLabel("Selectionnez une action à effectuer, sélectionnez une transaction pour la modifier.");
            String [][] valuesTest = { {"Oui", "Non", "Laurent", "Antoine", "Bourgeur"},{"Oui", "Non", "Laurent", "Antoine", "Bourgeur"} };
            String [] valuesTest2 = {"Oui quoi", "Non bonjoure", "Laurent ruquier", "Antoine canard", "Bourgeur de maison"};
            JTable tableList = new JTable(valuesTest, valuesTest2);

            // https://stackoverflow.com/questions/14974228/java-swing-multi-column-autocomplete-combobox


            this.add(tableList);
            this.add(ligneBienvenue);
            this.add(ligneSelection);
        }

    }

    private class ClosingWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

}