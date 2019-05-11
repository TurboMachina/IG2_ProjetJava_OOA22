package modelPackage;

import javax.swing.*;
import java.util.ArrayList;

public class AllNumChassis  extends AbstractListModel implements ComboBoxModel {
    private String selectedItem;

    private ArrayList<FicheVehicule> ficheVehicules;

    public AllNumChassis(ArrayList<FicheVehicule> ficheVehicules){
        this.ficheVehicules = ficheVehicules;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        for(FicheVehicule ficheVehicule : ficheVehicules){
            selectedItem = ficheVehicule.getNumChassis();
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return ficheVehicules.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ficheVehicules.get(index).getNumChassis();
    }
}
