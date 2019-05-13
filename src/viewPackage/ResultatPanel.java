package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.ConnectionException;
import exceptionPackage.RechercheException;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ResultatPanel extends JPanel{
    private PrincipalWindow w;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnRetour;
    private TransactionController controller;
    private ListSelectionModel listeSelect;
    private ArrayList<Transaction> listeResultat;
    private JLabel lblNbTrouves;
    private Integer nbTrouves;

    public ResultatPanel(PrincipalWindow w, Integer matricule, String marque){
        Model model = new RechercheTransactionModel();
        this.w = w;
        nbTrouves = 0;
        try {
            listeResultat = controller.rechercheTransaction(matricule, marque);
        }
        catch (ConnectionException | RechercheException e){
            JOptionPane.showMessageDialog(w,e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if(listeResultat != null){
            nbTrouves = listeResultat.size();
            lblNbTrouves = new JLabel(nbTrouves.toString());
        }
        else{

        }
    }

    public ResultatPanel(PrincipalWindow w, Integer idModele, Integer idMagasin ){
        Model model = new RechercheModeleModel();
        this.w = w;
        nbTrouves = 0;
        try {
            listeResultat = controller.rechercheModel(idModele, idMagasin);
        }
        catch (ConnectionException | RechercheException e){
            JOptionPane.showMessageDialog(w,e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if(listeResultat != null){
            nbTrouves = listeResultat.size();
            lblNbTrouves = new JLabel(nbTrouves.toString());
        }
        else{

        }
    }

    public ResultatPanel(PrincipalWindow w, GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin){
        Model model = new RechercheVenteModel();
        this.w = w;
        nbTrouves = 0;
        try {
            listeResultat = controller.rechercheVente(dateDebut, dateFin, idModele, idMagasin);
        }
        catch (ConnectionException | RechercheException e){
            JOptionPane.showMessageDialog(w,e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if(listeResultat != null){
            nbTrouves = listeResultat.size();
            lblNbTrouves = new JLabel(nbTrouves.toString());
        }
        else{

        }
    }



    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        w.setTitle("Resultat de la recherche");
        w.setSize(1700,500);
        w.setLocationRelativeTo(null);
        fc.repaint();
        fc.revalidate();
    }
}
