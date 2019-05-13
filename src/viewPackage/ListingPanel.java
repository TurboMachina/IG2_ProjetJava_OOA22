package viewPackage;

import javax.swing.*;
import javax.swing.plaf.SeparatorUI;
import javax.swing.table.DefaultTableCellRenderer;

import controllerPackage.*;
import exceptionPackage.ConnectionException;
import exceptionPackage.DeleteFormException;
import exceptionPackage.DeleteTransactionException;
import exceptionPackage.GetTransactionException;
import modelPackage.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListingPanel extends JPanel {
    private PrincipalWindow w;
    private AllTransactionsModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnModifier,btnSupprimer;
    private JLabel lblListing;
    private TransactionController controller;
    private ListSelectionModel listSelect;
    private ArrayList<Transaction> transactions;

    public ListingPanel(PrincipalWindow w){
        setController(new TransactionController());
        this.w = w;
        setLayout(new GridLayout(1,2));
        btnModifier = new JButton("Modifier une transaction");
        btnModifier.addActionListener(new BtnModifierListener());
        btnSupprimer = new JButton("Supprimer une transaction");
        btnSupprimer.addActionListener(new BtnSupprimerListener());

        lblListing = new JLabel("Listing de la table Transactions, permet la suppresion et la modification");
        try{
            transactions = controller.getAllTransactions();
            model = new AllTransactionsModel(transactions);
        }
        catch (ConnectionException | GetTransactionException e){
            JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        int iColumn = 0;
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionInterval(0,0);
        listSelect = table.getSelectionModel();
        while (iColumn < table.getColumnModel().getColumnCount()){
            table.getColumnModel().getColumn(iColumn).setCellRenderer(centerRenderer);
            iColumn++;
        }
        scrollPane = new JScrollPane(table);
        add(btnModifier);
        add(btnSupprimer);
    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this.lblListing, BorderLayout.NORTH);
        fc.add(this, BorderLayout.SOUTH);
        fc.add(new JSeparator(SwingConstants.HORIZONTAL));
        fc.add(this.scrollPane, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        w.setSize(1700,500);
        w.setLocationRelativeTo(null);
        w.setTitle("Listing");
        fc.repaint();
        fc.revalidate();
    }

    public int getSelectedIndex(){
        return listSelect.getMinSelectionIndex();
    }

    private class BtnModifierListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            new ModificationPanel(w,transactions.get(getSelectedIndex())).setPanel();
        }
    }

    private class BtnSupprimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            try{
                controller.deleteTransaction(transactions.get(getSelectedIndex()).getId());
                JOptionPane.showMessageDialog(w, "Transaction supprimée", "Suppresion", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (ConnectionException | DeleteTransactionException | DeleteFormException e){
                JOptionPane.showMessageDialog(w,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            new ListingPanel(w).setPanel();
        }
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }
}
