package viewPackage;

import controllerPackage.ConnexionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLogin extends JPanel {
    private GestionnaireEcran ge;
    private ConnexionController controller;
    private JTextField matricule;
    PanelLogin(GestionnaireEcran ge){
        setController(new ConnexionController());
        this.ge = ge;
        this.setLayout(new FlowLayout());
        JLabel identifier = new JLabel("Veuillez entrer votre matricule");
        matricule = new JTextField();
        JButton btnOk = new JButton("Ok");

        ButtonOkListener listenerOk = new ButtonOkListener();
        btnOk.addActionListener(listenerOk);

        this.add(identifier);
        this.add(matricule);
        this.add(btnOk);

    }

    private void setController(ConnexionController controller){
        this.controller = controller;
    }

    class ButtonOkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent vent)  {
            ge.setPanel(new PanelBienvenue(ge), "Bienvenue");
            try{

                //Verifier le matricule
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
