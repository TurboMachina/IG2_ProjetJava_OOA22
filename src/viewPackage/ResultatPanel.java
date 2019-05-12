package viewPackage;

import controllerPackage.TransactionController;
import modelPackage.Model;
import modelPackage.RechercheModeleModel;
import modelPackage.RechercheTransactionModel;
import modelPackage.RechercheVenteModel;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class ResultatPanel {
    private PrincipalWindow w;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnRetour;
    private TransactionController controller;
    private ListSelectionModel listSelect;

    public ResultatPanel(PrincipalWindow w, Integer matricule, String marque){
        Model model = new RechercheTransactionModel();
        this.w = w;
    }

    public ResultatPanel(PrincipalWindow w, Integer idModele, Integer idMagasin ){
        Model model = new RechercheModeleModel();
        this.w = w;
    }

    public ResultatPanel(PrincipalWindow w, GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin){
        Model model = new RechercheVenteModel();
        this.w = w;
    }



    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        w.setTitle("Listing");
        w.setSize(1700,500);
        w.setLocationRelativeTo(null);
        fc.repaint();
        fc.revalidate();
    }
}
