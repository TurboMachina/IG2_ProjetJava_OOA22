package viewPackage;

import javax.swing.*;
import javax.swing.border.Border;

import controllerPackage.*;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetTransactionException;
import modelPackage.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListingPanel extends JPanel {
    private PrincipalWindow w;
    private AllTransactionsModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton modifier,supprimer;
    private TransactionController controller;

    public ListingPanel(PrincipalWindow w){
        setController(new TransactionController());
        this.w = w;
        setLayout(new BorderLayout());
        try{
            model = new AllTransactionsModel(controller.getAllTransactions());
            table = new JTable(model);
            scrollPane = new JScrollPane(table);
        }
        catch (ConnectionException | GetTransactionException e){
            System.out.println(e.getMessage());
        }

    }

    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        fc.add(this, BorderLayout.CENTER);
        w.setTitle("Listing");
        repaint();
        revalidate();
    }

    public void setController(TransactionController controller){
        this.controller = controller;
    }
}
