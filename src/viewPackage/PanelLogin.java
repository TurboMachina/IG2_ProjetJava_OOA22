package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLogin extends JPanel {
    private GestionnaireEcran ge;
    public PanelLogin(GestionnaireEcran ge){
        this.ge = ge;
        this.setLayout(new FlowLayout());
        JLabel identifier = new JLabel("Veuillez entrer votre matricule");
        JPasswordField pass = new JPasswordField();
        JButton btnOk = new JButton("Ok");

        ButtonOkListener listenerOk = new ButtonOkListener();
        btnOk.addActionListener(listenerOk);

        this.add(identifier);
        this.add(pass);
        this.add(btnOk);

    }

    class ButtonOkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ge.setPanel(new PanelBienvenue(ge), "Bienvenue");
            // S'occuper de la recup du matricule
        }
    }

}
