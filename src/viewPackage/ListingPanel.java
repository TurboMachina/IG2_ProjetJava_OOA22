package viewPackage;

import javax.swing.*;

import controllerPackage.*;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetTransactionException;
import modelPackage.*;

import java.awt.*;

public class ListingPanel extends JPanel {
    private PrincipalWindow w;
    private AllTransactionsModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnModifier,btnSupprimer;
    private TransactionController controller;
    private ListSelectionModel listSelect;

    public ListingPanel(PrincipalWindow w){
        setController(new TransactionController());
        this.w = w;
        setLayout(new GridLayout(1,2));
        btnModifier = new JButton("Modifier une transaction");
        btnSupprimer = new JButton("Supprimer une transaction");
        try{
            model = new AllTransactionsModel(controller.getAllTransactions());
        }
        catch (ConnectionException | GetTransactionException e){
        JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        listSelect = table.getSelectionModel();
        scrollPane = new JScrollPane(table);
        add(btnModifier);
        add(btnSupprimer);
    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.SOUTH);
        fc.add(this.scrollPane, BorderLayout.CENTER);
        w.setTitle("Listing");
        fc.repaint();
        fc.revalidate();
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }
}
