package viewPackage;

import controllerPackage.*;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetMarqueException;
import exceptionPackage.GetTransactionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilPanel extends JPanel {
    private PrincipalWindow w;
    private JLabel lblBienvenue;
    private JButton btnDiscoFever;
    private ConnectionController connectionController;
    private ThreadDisco discotime;

    public AccueilPanel(PrincipalWindow w){
        this.discotime = new ThreadDisco(w);
        this.setLayout(new GridLayout(1,1));
        this.setConnectionController(new ConnectionController());
        this.w = w;
        lblBienvenue = new JLabel("<html> Bienvenue, veuillez choisir une option dans le menu ci-dessous. " +
                "<br/>Pour supprimer ou modifier une transacation vous devez passer par le listing </html>", SwingConstants.CENTER);
        btnDiscoFever = new JButton("[Thread] Disco fever");
        btnDiscoFever.addActionListener(new DiscoFeverButton());
        try{
            connectionController.checkConnection();
        }
        catch (ConnectionException e){
            JOptionPane.showMessageDialog(w,"Connection à la base de données impossible\n Verifier la connection puis redémarrer le programme", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        this.add(btnDiscoFever);

    }

    void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.SOUTH);
        fc.add(lblBienvenue, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        w.setTitle("Acceuil");
        w.setSize(500,500);
        w.setLocationRelativeTo(null);
        fc.repaint();
        fc.revalidate();
    }

    private void setConnectionController(ConnectionController connectionController){
        this.connectionController = connectionController;
    }
    private class DiscoFeverButton implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            discotime.threadStart();
        }

    }
}
