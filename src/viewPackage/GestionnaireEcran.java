package viewPackage;

import controllerPackage.ConnexionController;
import dataAccessPackage.SingletonConnexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class GestionnaireEcran extends JFrame {

    // matriculeCommercialCourant
    private ConnexionController controller;

    public GestionnaireEcran() {
        setController(new ConnexionController());
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
        setTitle(title); // Creer une interface panelTitle pour avoir la methode panel.getTitle() et une variable privée String title + bouton retour
        repaint();
        revalidate();
    }

    private void setController(ConnexionController controller){
        this.controller = controller;
    }

    private class ClosingWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            try{
                controller.closeConnexion();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            finally {
                System.exit(0);
            }
        }
    }

}
