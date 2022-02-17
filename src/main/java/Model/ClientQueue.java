package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientQueue implements Runnable{
    private BlockingQueue<Client> clients= new LinkedBlockingQueue<>();
    private AtomicInteger waitingPeriod;
    private int maxNrOfClientsInQueue=1000;
    //CONSTRUCTORUL CLASEI//
    public ClientQueue(int maxNrOfClientsInQueue) {
        this.waitingPeriod= new AtomicInteger(0);
        this.maxNrOfClientsInQueue=maxNrOfClientsInQueue;
    }
    //GETTERE SI SETTERE PENTRU ATRIBURTE//
    public int getMaxNrOfClientsInQueue() {
        return maxNrOfClientsInQueue;
    }

    public void setMaxNrOfClientsInQueue(int maxNrOfClientsInQueue) {
        this.maxNrOfClientsInQueue = maxNrOfClientsInQueue;
    }

    public BlockingQueue<Client> getClients() {
        return clients;
    }

    public void setClients(BlockingQueue<Client> clients) {
        this.clients = clients;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }
    //METODA DE ADAUGARE CLIENT INTR-O COADA??
    public void addClient(Client newClient){
        newClient.setFinishTime(newClient.getArrivalTime()+newClient.getProcessingTime()+this.waitingPeriod.get());
        this.clients.add(newClient);
        this.waitingPeriod.set(this.waitingPeriod.get()+ newClient.getProcessingTime());
    }
    //METODA RUN //
    @Override
    public void run() {
        while(true){
            try {
                for(Client cl : this.clients){
                Thread.sleep(cl.getProcessingTime()* 1000);
                this.waitingPeriod.set(this.waitingPeriod.get()- cl.getProcessingTime());
                this.clients.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
