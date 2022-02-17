package View;

import Controller.SimulationManager;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField txtClose;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JLabel lblNewLabel_1_1_4_1;


    public GUI() {
        initialize();
    }

    public void textFields(){
        textField = new JTextField();
        textField.setBounds(10, 37, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(117, 37, 86, 20);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(224, 37, 86, 20);
        frame.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(327, 37, 86, 20);
        frame.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(10, 83, 86, 20);
        frame.getContentPane().add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(117, 83, 86, 20);
        frame.getContentPane().add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(224, 83, 86, 20);
        frame.getContentPane().add(textField_6);

        textField_7 = new JTextField();
        textField_7.setBounds(10, 165, 426, 20);
        frame.getContentPane().add(textField_7);
        textField_7.setColumns(10);

        txtClose = new JTextField();
        txtClose.setText("CLOSED");
        txtClose.setBounds(71, 198, 122, 20);
        frame.getContentPane().add(txtClose);
        txtClose.setColumns(10);

        textField_8 = new JTextField();
        textField_8.setText("CLOSED");
        textField_8.setColumns(10);
        textField_8.setBounds(71, 229, 122, 20);
        frame.getContentPane().add(textField_8);

        textField_9 = new JTextField();
        textField_9.setText("CLOSED");
        textField_9.setColumns(10);
        textField_9.setBounds(71, 260, 122, 20);
        frame.getContentPane().add(textField_9);

        textField_10 = new JTextField();
        textField_10.setText("CLOSED");
        textField_10.setColumns(10);
        textField_10.setBounds(70, 291, 122, 20);
        frame.getContentPane().add(textField_10);
    }

    public void labels(){
        JLabel lblNewLabel = new JLabel("Number of Queues");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel.setBounds(10, 11, 103, 32);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNumberOfClients = new JLabel("Number of Clients");
        lblNumberOfClients.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNumberOfClients.setBounds(117, 11, 107, 32);
        frame.getContentPane().add(lblNumberOfClients);

        JLabel lblSimulationTime = new JLabel("Simulation Time");
        lblSimulationTime.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblSimulationTime.setBounds(224, 11, 87, 32);
        frame.getContentPane().add(lblSimulationTime);

        JLabel lblMaxProcessingTime = new JLabel("Max Processing Time");
        lblMaxProcessingTime.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblMaxProcessingTime.setBounds(321, 11, 97, 32);
        frame.getContentPane().add(lblMaxProcessingTime);

        JLabel lblMinProcessingTime = new JLabel("Min Processing Time");
        lblMinProcessingTime.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblMinProcessingTime.setBounds(10, 54, 97, 32);
        frame.getContentPane().add(lblMinProcessingTime);

        JLabel lblMaxArrivalTime = new JLabel("Max Arrival Time");
        lblMaxArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblMaxArrivalTime.setBounds(117, 54, 97, 32);
        frame.getContentPane().add(lblMaxArrivalTime);

        JLabel lblMinArrivalTime = new JLabel("Min Arrival Time");
        lblMinArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblMinArrivalTime.setBounds(224, 54, 97, 32);
        frame.getContentPane().add(lblMinArrivalTime);

        JLabel lblNewLabel_1 = new JLabel("Remaining Clients");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel_1.setBounds(10, 134, 87, 20);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Queue 0 : ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel_1_1.setBounds(9, 198, 52, 20);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Queue 1 : ");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel_1_1_1.setBounds(9, 229, 52, 20);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Queue 2 : ");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel_1_1_2.setBounds(10, 260, 51, 20);
        frame.getContentPane().add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("Queue 3 : ");
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel_1_1_3.setBounds(9, 291, 51, 20);
        frame.getContentPane().add(lblNewLabel_1_1_3);

        JLabel lblNewLabel_1_1_4 = new JLabel("TIMER :");
        lblNewLabel_1_1_4.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel_1_1_4.setBounds(9, 348, 52, 20);
        frame.getContentPane().add(lblNewLabel_1_1_4);

        lblNewLabel_1_1_4_1 = new JLabel("TIMER :");
        lblNewLabel_1_1_4_1.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel_1_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel_1_1_4_1.setBounds(71, 348, 52, 20);
        frame.getContentPane().add(lblNewLabel_1_1_4_1);

        frame.setVisible(true);

    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textFields();
        labels();

        JButton btnNewButton = new JButton("Start Simulation");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
        btnNewButton.setBounds(321, 68, 115, 40);
        btnNewButton.addActionListener(new ActionListener() {
            @Override // DACA SE APASA PE BUTON SE CREAZA UN THREAD NOU
            public void actionPerformed(ActionEvent e) {
                SimulationManager generator = new SimulationManager(getSimTime(), getMinArrivalTime(), getMaxArrivalTime(), getMaxProcessTime(), getMinProcessTime(), getNrQueues(), getNrClients(),new GUI());
                Thread t = new Thread(generator);
                t.start();
            }
        });
        frame.getContentPane().add(btnNewButton);
    }
    // METODE DE GET SI SET PENTRU A MANIPULA DATELE DIN INTERFATA
    public int getNrQueues(){
        return Integer.parseInt(textField.getText());
    }

    public int getNrClients(){
        return Integer.parseInt(textField_1.getText());
    }

    public int getSimTime(){
        return Integer.parseInt(textField_2.getText());
    }

    public int getMaxProcessTime(){
        return Integer.parseInt(textField_3.getText());
    }

    public int getMinProcessTime(){
        return Integer.parseInt(textField_4.getText());
    }

    public int getMaxArrivalTime(){
        return Integer.parseInt(textField_5.getText());
    }

    public int getMinArrivalTime(){
        return Integer.parseInt(textField_6.getText());
    }

    public void setWaitingClients(String nrOfClients){
        textField_7.setText(nrOfClients);
    }

    public void setQueue0(String nrOfClients){
        txtClose.setText(nrOfClients);
    }

    public void setQueue1(String nrOfClients){
        textField_8.setText(nrOfClients);
    }

    public void setQueue2(String nrOfClients){
        textField_9.setText(nrOfClients);
    }

    public void setQueue3(String nrOfClients){
        textField_10.setText(nrOfClients);
    }

    public void setTimer(String Timer){lblNewLabel_1_1_4_1.setText(Timer);}

    public static void main(String[] args) {
        new GUI();
    }
}
