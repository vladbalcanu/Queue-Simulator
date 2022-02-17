package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scheduler {
    private List<ClientQueue> queues = Collections.synchronizedList(new ArrayList<>());
    private int maxNrOfQueues=1000;
    private int maxNrOfClientsPerQueue;
    private Strategy strategy= new ConcreteStrategyTime();

    //CONSTRUCTORUL CLASEI//
    public Scheduler(int maxNrOfQueues, int maxNrOfClientsPerQueue) {
        this.maxNrOfQueues = maxNrOfQueues;
        this.maxNrOfClientsPerQueue = maxNrOfClientsPerQueue;
        for(int i =0 ;i < this.maxNrOfQueues;i++) {
            ClientQueue cq = new ClientQueue(maxNrOfClientsPerQueue);
            this.queues.add(cq);
            Thread t = new Thread(cq);
            t.start();
        }
    }
    //METODA DE SCHIMBARE A STRATEGIEI//
    public void changeStrategy(SelectionPolicy policy) {
        if (policy == SelectionPolicy.SHORTEST_QUEUE) {
            strategy = new ConcreteStrategyQueue();
        }
        if (policy == SelectionPolicy.SHORTEST_TIME) {
            strategy = new ConcreteStrategyTime();
        }
    }
    //METODA DE TRIMITERE A CLIENTULUI LA STRATEGIE PENTRU A FI TRIMIS LA O COADA BUNA //
    public void dispatchClient(Client client){
        strategy.addClient(queues,client);
    }
    //GETTERE SI SETTERE PENTRU ATRIBUTE
    public List<ClientQueue> getQueues() {
        return queues;
    }

    public void setQueues(List<ClientQueue> queues) {
        this.queues = queues;
    }

    public int getMaxNrOfQueues() {
        return maxNrOfQueues;
    }

    public void setMaxNrOfQueues(int maxNrOfQueues) {
        this.maxNrOfQueues = maxNrOfQueues;
    }

    public int getMaxNrOfClientsPerQueue() {
        return maxNrOfClientsPerQueue;
    }

    public void setMaxNrOfClientsPerQueue(int maxNrOfClientsPerQueue) {
        this.maxNrOfClientsPerQueue = maxNrOfClientsPerQueue;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
