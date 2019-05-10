package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import controllerPackage.*;
import modelPackage.*;


public class PrincipalWindow extends JFrame {
    Container frameContainer = this.getContentPane();
    public PrincipalWindow(){
        super("Accueil");
        setBounds(100,100,750,500);
        setFrameContainer(new AccueilPanel(this), "Accueil");
        setVisible(true);
    }

    public Container getFrameContainer(){
        return this.frameContainer;
    }

    public void setFrameContainer(JPanel panel, String title){
        frameContainer.removeAll();
        this.add(panel);
        setTitle(title);
        repaint();
        revalidate();
    }

    private class ClosingWindow extends WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            try{
                // utilityController.closeConnection();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.exit(0);
        }
    }

}
