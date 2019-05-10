package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PrincipalWindow extends JFrame {
    Container frameContainer = this.getContentPane();
    public PrincipalWindow(){
        super("Accueil");
        setBounds(100,100,750,500);

        setVisible(true);
    }

    public Container getFrameContainer(){
        return this.frameContainer;
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
