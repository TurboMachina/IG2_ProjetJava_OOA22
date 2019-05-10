package dataAccessPackage;

import modelPackage.*;
import java.util.ArrayList;

public interface ClientDataAccess {
    Client getClient(Integer idClient);
    ArrayList<Client> getAllClients();
}
