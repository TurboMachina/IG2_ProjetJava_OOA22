package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAjout extends JPanel {
    private GestionnaireEcran ge;
        public PanelAjout(GestionnaireEcran ge){
            this.ge = ge;
            JLabel ligneBienvenue = new JLabel("Bienvenue.");
            JButton btnRetour = new JButton("Retour");

            PanelAjout.ButtonRetourListener listenerRetour = new PanelAjout.ButtonRetourListener();
            btnRetour.addActionListener(listenerRetour);

            this.setLayout(new GridLayout(6, 3));
            // + GROS CADRE DESCRIPTION JTextArea
            this.add(ligneBienvenue);
            this.add(btnRetour);
    }

    class ButtonRetourListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ge.setPanel(new PanelBienvenue(ge), "Bienvenue");
        }
    }
}
