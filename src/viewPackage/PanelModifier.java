package viewPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PanelModifier extends JPanel {
    private GestionnaireEcran ge;
    PanelModifier(GestionnaireEcran ge){
        this.ge = ge;
        JButton btnRetour = new JButton("Retour");

        PanelModifier.ButtonRetourListener listenerRetour = new PanelModifier.ButtonRetourListener();
        btnRetour.addActionListener(listenerRetour);

        this.add(btnRetour);
        //Même chose que panel ajout
    }


    class ButtonRetourListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ge.setPanel(new PanelBienvenue(ge), "Bienvenue");
        }
    }
}
