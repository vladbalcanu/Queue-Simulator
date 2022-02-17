package Model;

import Model.Client;
import Model.ClientQueue;

import java.util.List;

public interface Strategy {
    public void addClient(List<ClientQueue> clientQueues, Client client);
}
