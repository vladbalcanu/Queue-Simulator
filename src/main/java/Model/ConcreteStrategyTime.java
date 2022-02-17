package Model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteStrategyTime implements Strategy {
    @Override
    //METODA DE ADAUGAT CLIENTII IN COADA IN FUNCTIE DE CEL MAI MIC TIMP DINTRE COZI //
    public void addClient(List<ClientQueue> clientQueues, Client client) {
            AtomicInteger minPeriod=new AtomicInteger();
            minPeriod.set(100000);
            int poz=0;
            int mini=0;
            for(ClientQueue cq: clientQueues){
                if(cq.getWaitingPeriod().get()<minPeriod.get()){
                    minPeriod.set(cq.getWaitingPeriod().get());
                    mini=poz;
                }
                poz++;
            }
            clientQueues.get(mini).addClient(client);



        System.out.println("am adaugata clientul : " + client.getIdClient() + " " + client.getArrivalTime() + " in coada :" +mini);
    }
}
