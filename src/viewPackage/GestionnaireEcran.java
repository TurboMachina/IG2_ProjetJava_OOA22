package viewPackage;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class GestionnaireEcran extends JFrame {

    public GestionnaireEcran() {
        setBounds(100, 100, 750, 500);
        add(new PanelBienvenue(this));

        GestionnaireEcran.ClosingWindow closer = new ClosingWindow();
        this.addWindowListener(closer);
        this.setVisible(true);
    }

    public void setPanel(JPanel panel, String title){
        getContentPane().removeAll();
        this.add(panel);
        setTitle(title);
        repaint();
        revalidate();
    }

    private class ClosingWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

}
