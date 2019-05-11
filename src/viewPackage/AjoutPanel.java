package viewPackage;

import javax.swing.*;
import java.awt.*;

public class AjoutPanel extends JPanel {
    PrincipalWindow w;

    public AjoutPanel(PrincipalWindow w){
        this.w = w;
    }


    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.SOUTH);
        w.setTitle("Acceuil");
        repaint();
        revalidate();
    }
}
