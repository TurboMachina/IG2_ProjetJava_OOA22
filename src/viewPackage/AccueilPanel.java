package viewPackage;

import controllerPackage.*;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetMarqueException;
import exceptionPackage.GetTransactionException;
import modelPackage.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilPanel extends JPanel {
    private PrincipalWindow w;
    private JButton btnList, btnAjout, btnDiscoFever, btnStats;
    private JTextField texteBienvenue;
    private JLabel lblBienvenue;
    private ConnectionController controller; // A renommer connecController BITCONNEEECT
    private StatistiqueController statController;
    private ThreadDisco discotime;
    public AccueilPanel(PrincipalWindow w){
        discotime = new ThreadDisco(w);
        setLayout(new GridLayout(4,1));
        setController(new ConnectionController());
        try {
            setStatController(new StatistiqueController());
        }
        catch(ConnectionException | GetTransactionException e){
            JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        this.w = w;
        lblBienvenue = new JLabel("<html> Bienvenue, veuillez choisir une option dans le menu ci-dessous. " +
                "<br/>Pour supprimer ou modifier une transacation vous devez passer par le listing </html>", SwingConstants.CENTER);
        texteBienvenue = new JTextField("Bienvenue, sélectionnez une option");
        btnList = new JButton("Lister les transactions (Donne accés à la modification/suppresion)");
        btnAjout = new JButton("Ajouter une transaction");
        btnStats = new JButton("Statistiques");
        btnDiscoFever = new JButton("Disco fever");
        btnList.addActionListener(new BtnListeListener());
        btnAjout.addActionListener(new BtnAjoutListener());
        btnStats.addActionListener(new BtnStatsListener());
        btnDiscoFever.addActionListener(new DiscoFeverButton());
        try{
            controller.checkConnection();
        }
        catch (ConnectionException e){
            btnList.setEnabled(false);
            btnAjout.setEnabled(false);
            JOptionPane.showMessageDialog(w,"Connection à la base de données impossible\n Verifier la connection puis redémarrer le programme", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        this.add(btnList);
        this.add(btnAjout);
        this.add(btnStats);
        this.add(btnDiscoFever);

    }

    private class BtnListeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            new ListingPanel(w).setPanel();
        }
    }
    private class BtnStatsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String stats = null;
            try{
                stats = statController.getResultats();
            }
            catch(ConnectionException | GetTransactionException | GetMarqueException e){
            JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(w, stats, "Statistiques", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private class BtnAjoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            new AjoutPanel(w).setPanel();
        }
    }

    public void setPanel(){
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

    public void setController(ConnectionController controller){
        this.controller = controller;
    }
    public void setStatController(StatistiqueController statController ) {this.statController = statController; }

    private class DiscoFeverButton implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            discotime.threadStart();
        }

    }
}
