package viewPackage;

import javax.swing.*;
import java.awt.*;

public class PrincipalWindow extends JFrame {
    Container frameContainer = this.getContentPane();
    public PrincipalWindow(){
        super("Hello");
        setBounds(100,100,750,500);
        setVisible(true);
    }

    public Container getFrameContainer(){return this.frameContainer;}
}
