package Model;

public class Client {
    private int idClient;
    private int arrivalTime;
    private int processingTime;
    private int finishTime;

    public Client(){
    }
    //CONSTRUCTORUL CLASEI//
    public Client(int idClient,int arrivalTime, int processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.idClient=idClient;
    }
    //GETTERE SI SETTERE PENTRU ATRIBUTE//
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
}
