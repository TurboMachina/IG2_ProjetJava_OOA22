package dataAccessPackage;

import modelPackage.*;
import java.util.ArrayList;

public interface ClientDataAccess {
    Client getClient();
    ArrayList<Client> getAllClient();
    void deleteClient(Client client);

}
