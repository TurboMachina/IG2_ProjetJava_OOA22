package viewPackage;

import controllerPackage.TransactionController;
import exceptionPackage.ConnectionException;
import exceptionPackage.RechercheException;
import modelPackage.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
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
    private AbstractTableModel model;

    public ResultatPanel(PrincipalWindow w, Integer matricule, String marque){
        this.w = w;
        nbTrouves = 0;
        setController(new TransactionController());
        setLayout(new BorderLayout());
        try {
            listeResultat = controller.rechercheTransaction(matricule, marque);
        }
        catch (ConnectionException | RechercheException e){
            JOptionPane.showMessageDialog(w,e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if(listeResultat.size() != 0){
            nbTrouves = listeResultat.size();
            lblNbTrouves = new JLabel(nbTrouves.toString() + " résultat(s) trouvé(s)");
            model = new RechercheTransactionModel(listeResultat);
            add(creationTable(model), BorderLayout.CENTER);
            setPanel();
        }
        else{
            JOptionPane.showMessageDialog(w, "Aucune transaction trouvée", "Recherche Resultat", JOptionPane.INFORMATION_MESSAGE);
            new AccueilPanel(w).setPanel();
        }
    }

    public ResultatPanel(PrincipalWindow w, Integer idModele, Integer idMagasin ){

        this.w = w;
        nbTrouves = 0;
        setController(new TransactionController());
        setLayout(new BorderLayout());
        try {
            listeResultat = controller.rechercheModel(idModele, idMagasin);
        }
        catch (ConnectionException | RechercheException e){
            JOptionPane.showMessageDialog(w,e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if(listeResultat.size() != 0){
            nbTrouves = listeResultat.size();
            lblNbTrouves = new JLabel(nbTrouves.toString() + " résultat(s) trouvé(s) | PAV = Poids à vide en kg | PV = Prix de Vente en € | MC = Mise en Circulation | CU = Consommation Urbaine | CM = Consommation Mixte | CEU = Consommation Extra Urbaine");
            model = new RechercheModeleModel(listeResultat);
            add(creationTable(model), BorderLayout.CENTER);
            setPanel();
        }
        else{
            JOptionPane.showMessageDialog(w, "Aucun modéle trouvé", "Recherche Resultat", JOptionPane.INFORMATION_MESSAGE);
            new AccueilPanel(w).setPanel();
        }
    }

    public ResultatPanel(PrincipalWindow w, GregorianCalendar dateDebut, GregorianCalendar dateFin, Integer idModele, Integer idMagasin){
        this.w = w;
        nbTrouves = 0;
        setController(new TransactionController());
        setLayout(new BorderLayout());
        try {
            listeResultat = controller.rechercheVente(dateDebut, dateFin, idModele, idMagasin);
        }
        catch (ConnectionException | RechercheException e){
            JOptionPane.showMessageDialog(w,e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if(listeResultat.size() != 0){
            nbTrouves = listeResultat.size();
            lblNbTrouves = new JLabel(nbTrouves.toString() + " résultat(s) trouvé(s)");
            model = new RechercheVenteModel(listeResultat);
            add(creationTable(model), BorderLayout.CENTER);
            setPanel();
        }
        else{
            JOptionPane.showMessageDialog(w, "Aucune vente trouvée", "Recherche Resultat", JOptionPane.INFORMATION_MESSAGE);
            new AccueilPanel(w).setPanel();
        }
    }

    private JScrollPane creationTable(AbstractTableModel model){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        int iColumn = 0;
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionInterval(0,0);
        listeSelect = table.getSelectionModel();
        while (iColumn < table.getColumnModel().getColumnCount()){
            table.getColumnModel().getColumn(iColumn).setCellRenderer(centerRenderer);
            iColumn++;
        }
        scrollPane = new JScrollPane(table);
        return scrollPane;
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }



    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.CENTER);
        fc.add(this.lblNbTrouves, BorderLayout.NORTH);
        w.pack();
        w.setTitle("Resultat de la recherche");
        w.setSize(1900,500);
        w.setLocationRelativeTo(null);
        fc.repaint();
        fc.revalidate();
    }
}
