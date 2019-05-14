package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;
import java.util.ArrayList;

public interface ClientDataAccess {
    ArrayList<Client> getAllClients() throws ConnectionException, GetClientException;
}
