package Controller;

import Model.Client;
import Model.ClientQueue;
import Model.OrderQueue;
import Model.Scheduler;
import View.GUI;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulationManager implements Runnable {
    public int timeLimit;
    public int minArrivalTime;
    public int maxArrivalTime;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int numberOfQueues;
    public int numberOfClients;
    public int peakHour;
    public GUI gui;
    private Scheduler scheduler;
    private List<Client> generatedClients = Collections.synchronizedList(new ArrayList<>());
    //CONSTRUCTORUL CLASEI //
    public SimulationManager(int timeLimit, int minArrivalTime, int maxArrivalTime, int maxProcessingTime, int minProcessingTime, int numberOfQueues, int numberOfClients, GUI gui) {
        this.timeLimit = timeLimit;
        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.numberOfQueues = numberOfQueues;
        this.numberOfClients = numberOfClients;
        this.gui = gui;
        scheduler = new Scheduler(this.numberOfQueues, 100);
        generateNRandomClients();
    }
    //GETTERE SI SETTERE PENTRU ATRIBUTELE CLASEI //
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMaxProcessingTime() {
        return maxProcessingTime;
    }

    public void setMaxProcessingTime(int maxProcessingTime) {
        this.maxProcessingTime = maxProcessingTime;
    }

    public int getMinProcessingTime() {
        return minProcessingTime;
    }

    public void setMinProcessingTime(int minProcessingTime) {
        this.minProcessingTime = minProcessingTime;
    }

    public int getNumberOfQueues() {
        return numberOfQueues;
    }

    public void setNumberOfQueues(int numberOfQueues) {
        this.numberOfQueues = numberOfQueues;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public List<Client> getGeneratedClients() {
        return generatedClients;
    }

    public void setGeneratedClients(List<Client> generatedClients) {
        this.generatedClients = generatedClients;
    }

    //METODA DE GENERARE A CLIENTILOR ALEATORIU//
    private void generateNRandomClients() {
        Random clientRandom = new Random();
        for (int i = 1; i <= this.numberOfClients; i++) {
            int processTime = clientRandom.nextInt(this.maxProcessingTime);
            if (processTime < this.minProcessingTime) {
                processTime = this.minProcessingTime;
            }
            int arrivalTime = clientRandom.nextInt(this.maxArrivalTime);
            if (arrivalTime < this.minArrivalTime) {
                arrivalTime = this.minArrivalTime;
            }

            this.generatedClients.add(new Client(i, arrivalTime, processTime));

        }
        OrderQueue orderQueue = new OrderQueue();
        Collections.sort(this.generatedClients, orderQueue);
        for (Client client : this.generatedClients)
            System.out.println(client.getIdClient() + "   " + client.getArrivalTime());

    }
    //METODA RUN //
    @Override
    public void run() {
        try {
            FileWriter writer = new FileWriter("C:\\PT2021_30221_Balcanu_Vlad_Assignment_2\\QueueSimulation.txt", true); // Crearea Variabilei instanta de tip FileWriter pentru a scrie in fisier
            int maxNrOfClients=0; // numarul maxim de clienti care au fost prezenti in toate cozile la acelasi moment
            double averageWaitingTime=0; // timpul mediu de asteptare per client
            int nrOfClients=this.generatedClients.size(); // numarul initial de clienti generati
            double averageProcessingTime=0; // timpul mediu de procesare / servire per client

            int currentTime = 0; //timpul current
            while (currentTime < timeLimit) { // cat timp nu s-a terminat simularea
                gui.setTimer(currentTime + ""); // setam timer-ul in interfata
                String waitingClientsToBeDispatched = "";
                writer.write("Time :" + currentTime + "\n");
                writer.write("Waiting clients : ");
                for (int i = 0; i < this.generatedClients.size(); i++) { //parcurgem toti clientii generati ramasi
                    if (this.generatedClients.get(i).getArrivalTime() == currentTime) { // daca timpul lor de sosire este egal cu timpul curent
                        scheduler.dispatchClient(this.generatedClients.get(i)); // folosim metoda dispatchClient pentru ai trimite intr-o coada disponibila
                        averageWaitingTime=averageWaitingTime+this.generatedClients.get(i).getFinishTime()-this.generatedClients.get(i).getProcessingTime()-this.generatedClients.get(i).getArrivalTime();
                        averageProcessingTime=averageProcessingTime+this.generatedClients.get(i).getProcessingTime(); // calculam averageWaitingTime-ul si averageProcessingTime-ul
                        this.generatedClients.remove(i); // scoatem clientul din coada de clienti generati
                        i--; // ne intoarcem pe pozitia precedenta
                    } else { // altfel adaugam clientul la stringul waitingClientsToBeDispatched si il afisam in fisier si in interfata
                        waitingClientsToBeDispatched = waitingClientsToBeDispatched + "(" + this.generatedClients.get(i).getIdClient() + "," + this.generatedClients.get(i).getArrivalTime() + "," + this.generatedClients.get(i).getProcessingTime() +");";
                        gui.setWaitingClients(waitingClientsToBeDispatched);
                        writer.write("(" + this.generatedClients.get(i).getIdClient() + "," + this.generatedClients.get(i).getArrivalTime() + "," + this.generatedClients.get(i).getProcessingTime() + ");");
                    }
                }
                if(waitingClientsToBeDispatched==""){ // daca nu mai avem clienti ramasi sa nu se mai afiseze nimic in interfata
                    gui.setWaitingClients("");
                }
                writer.write("\n");

                int i = 0;
                int nrOfClientsAtThisMoment=0;
                for (ClientQueue queue : scheduler.getQueues()) { // la fiecare moment adunam toti clientii din toate cozile la nrOfClientsAtThisMoment
                    writer.write(" COADA " + i + ": ");
                    nrOfClientsAtThisMoment=nrOfClientsAtThisMoment+queue.getClients().size();


                    for (Client client : queue.getClients()) {
                        writer.write("(" + client.getIdClient() + "," +client.getArrivalTime() + "," + client.getProcessingTime() + "," + client.getFinishTime()+");");
                    }
                    String ClientsInQueue = "";
                    if(queue.getClients().size() > 0) {
                        for (int j = 0; j < queue.getClients().size(); j++)
                            ClientsInQueue = ClientsInQueue + '*'; // SE ADAUGA STELUTE CATI CLIENTI SE AFLA IN COADA RESPECTIVA LA MOMENTUL RESPECTIV
                    }else{
                        ClientsInQueue = "CLOSED";
                    }
                    if(i == 0) // IN FUNCTIE DE NUMARUL COZII SE AFISEAZA IN INTERFATA GRAFICA
                        gui.setQueue0(ClientsInQueue);
                    if(i == 1)
                        gui.setQueue1(ClientsInQueue);
                    if(i == 2)
                        gui.setQueue2(ClientsInQueue);
                    if(i == 3)
                        gui.setQueue3(ClientsInQueue);

                    i++;
                    writer.write("\n");

                }
                if(nrOfClientsAtThisMoment>maxNrOfClients){ // daca numarul de clienti la momentul acesta este mai mare decat maximul schimbam maximul si peakhour-ul devine acest currentTime
                    maxNrOfClients=nrOfClientsAtThisMoment;
                    peakHour=currentTime;
                }
                currentTime++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writer.write("\n");

            }
            //afisam pe ecran si in fisier timpul mediu de asteptare/procesare si peak hour-ul cu cat clienti au fost
            averageWaitingTime=averageWaitingTime/nrOfClients;
            averageProcessingTime=averageProcessingTime/nrOfClients;
            System.out.println("The average waiting time is :" +averageWaitingTime+"\n");
            System.out.println("The peak hour was : "+peakHour +" with :" + maxNrOfClients +" Clients");
            System.out.println("The average processing time is : "+averageProcessingTime+"\n");
            writer.write("The average Waiting time is : " +averageWaitingTime+"\n");
            writer.write("The peak hour was : "+peakHour +" with : " + maxNrOfClients +" Clients\n");
            writer.write("The average processing time is : "+averageProcessingTime+"\n");


            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

