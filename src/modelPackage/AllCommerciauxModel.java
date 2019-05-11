package modelPackage;

import javafx.collections.ObservableList;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.AbstractList;
import java.util.ArrayList;

public class AllCommerciauxModel extends AbstractListModel implements ComboBoxModel{
    private String selectedItem;

    private ArrayList<Commercial> commerciaux;

    public AllCommerciauxModel(ArrayList<Commercial> commerciaux){
        this.commerciaux = commerciaux;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        for(Commercial commercial : commerciaux){
            selectedItem = commercial.getNom();
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return commerciaux.size();
    }

    @Override
    public Object getElementAt(int index) {
        return commerciaux.get(index).getNom();
    }
}
