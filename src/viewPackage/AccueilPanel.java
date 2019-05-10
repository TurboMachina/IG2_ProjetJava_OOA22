package viewPackage;

import javax.swing.*;
import controllerPackage.*;
import modelPackage.*;

public class AccueilPanel extends JPanel {
    private PrincipalWindow w;
    private JButton btnList, btnAjout, btnRecherche, btwQuitter;
    private JTextField texteBienvenue;
    public AccueilPanel(PrincipalWindow w){
        this.w = w;
        texteBienvenue = new JTextField("Bienvenue, sélectionnez une option");


    }
}
