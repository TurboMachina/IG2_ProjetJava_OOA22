package viewPackage;

import javax.swing.*;
import java.awt.*;
public class PanelAjout extends JPanel {
    private GestionnaireEcran ge;
        public PanelAjout(GestionnaireEcran ge){
            this.ge = ge;
            JLabel ligneBienvenue = new JLabel("Bienvenue.");
            this.setLayout(new GridLayout(6, 3));
            // + GROS CADRE DESCRIPTION JTextArea
            this.add(ligneBienvenue);
    }
}
