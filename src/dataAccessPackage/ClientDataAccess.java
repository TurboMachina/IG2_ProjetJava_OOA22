package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;
import java.util.ArrayList;

public interface ClientDataAccess {
    Client getClient(Integer idClient) throws ConnectionException, GetClientException;
    ArrayList<Client> getAllClients() throws ConnectionException, GetClientException;
    ArrayList<Client> getAllLinkedClients() throws ConnectionException, GetClientException;
}
