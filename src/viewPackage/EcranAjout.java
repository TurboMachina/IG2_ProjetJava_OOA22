package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EcranAjout extends JFrame {
        public EcranAjout() {
            super("Ajout d'un véhicule");
            setBounds(100, 100, 750, 500);
            Container frameContainer = this.getContentPane();
            frameContainer.setLayout(new BorderLayout());
            EcranAjout.ClosingWindow closer = new ClosingWindow();
            this.addWindowListener(closer);

            ChampsAjoutPannel cap = new ChampsAjoutPannel();
            frameContainer.add(cap);

            setVisible(true);
        }

        private class ChampsAjoutPannel extends JPanel {
            public ChampsAjoutPannel(){
                JLabel ligneBienvenue = new JLabel("Bienvenue.");
                this.setLayout(new GridLayout(6, 3));
                // + GROS CADRE DESCRIPTION JTextArea
                this.add(ligneBienvenue);
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
