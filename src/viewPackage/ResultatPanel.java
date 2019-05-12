package viewPackage;

import controllerPackage.TransactionController;

import javax.swing.*;
import java.awt.*;

public class ResultatPanel {
    private PrincipalWindow w;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnRetour;
    private TransactionController controller;
    private ListSelectionModel listSelect;

    public ResultatPanel(PrincipalWindow w){
        this.w = w;
    }



    public void setPanel(){
        Container fc = w.getFrameContainer();
        fc.removeAll();
        w.setTitle("Listing");
        fc.repaint();
        fc.revalidate();
    }
}
