package modelPackage;

import javafx.collections.ObservableList;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Vector;

public class AllCommerciauxModel extends DefaultComboBoxModel{

    public ArrayList<Commercial> commerciaux;

    public AllCommerciauxModel(ArrayList<Commercial> commerciaux){
        this.commerciaux = commerciaux;
        for (Commercial commercial : commerciaux){
            addElement(commercial);
        }
    }

    @Override
    public void setSelectedItem(Object anObject) {

    }

    @Override
    public Object getSelectedItem() {
        return null;
    }

    @Override
    public int getSize() {
        return commerciaux.size();
    }

    @Override
    public Object getElementAt(int index) {
        return commerciaux.get(index);
    }

    @Override
    public int getIndexOf(Object anObject) {
        return super.getIndexOf(anObject);
    }

    public void addElement(Commercial commercial) {
        super.addElement(commercial.getNom());
    }
}
