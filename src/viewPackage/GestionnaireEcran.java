package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class GestionnaireEcran extends JFrame {

    // matriculeCommercialCourant

    public GestionnaireEcran() {
        setBounds(100, 100, 750, 500);
        // new PanelLogin
        this.setPanel(new PanelLogin(this), "login");

        GestionnaireEcran.ClosingWindow closer = new ClosingWindow();
        this.addWindowListener(closer);
        this.setVisible(true);
    }

    public void setPanel(JPanel panel, String title){
        getContentPane().removeAll();
        this.add(panel);
        setTitle(title); // Creer une interface panelTitle pour avoir la methode panel.getTitle() et une variable privée String title
        repaint();
        revalidate();
    }

    private class ClosingWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            // Connection.close();
            System.exit(0);
        }
    }

}
