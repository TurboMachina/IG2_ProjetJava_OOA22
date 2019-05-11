package modelPackage;

import javax.swing.*;
import java.util.ArrayList;

public class AllClientsModel extends AbstractListModel implements ComboBoxModel {
    private String selectedItem;

    private ArrayList<Client> clients;

    public AllClientsModel(ArrayList<Client> clients){
        this.clients = clients;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        for(Client client : clients){
            selectedItem = client.getNom();
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return clients.size();
    }

    @Override
    public Object getElementAt(int index) {
        return clients.get(index).getNom();
    }
}