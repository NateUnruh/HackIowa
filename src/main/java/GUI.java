/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: GUI
 * Description of Class: This class is used to implement the Emergency request through the GUI application.
 * this is used to show the visuals from the JVM to the users of the software
 */

// Importing All Classes used in Class
import com.google.maps.errors.ApiException;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


//This class is used to implement the Emergency request through the application using JFrame
public class GUI extends JFrame {
    private DroneRequest Closest; //this holds the closest drone
    private JLabel label1; // this holds the label for location
    private JLabel label2; //this holds the Pack type
    private JTextField Location; // This gets the location from the user
    private JComboBox PackType; // this gets what pack the user chose
    private JButton Send; // to request help
    private JPanel panel; // the panel to hold all the GUI components
    private JLabel TOaddress; // the address to which the user requested help to
    private JLabel Fromaddress; // the address from where we are sending the drone from
    private JLabel ETA; // the estimated time for the drone to reach out to the user

    /*
    This is where we build the GUI to get the users input to request the drones
     */
    public GUI(){
        setTitle("HELP!!!!");
        setVisible(true);
        label1 = new JLabel("Location");
        label2 = new JLabel("Pack Type");
        String[] options = {"Emergency","First Aid"};
        Location = new JTextField("",30);
        PackType = new JComboBox<>(options);
        Send = new JButton("Send Request");
        TOaddress = new JLabel("");
        Fromaddress = new JLabel("");
        Closest = new DroneRequest();
        ETA = new JLabel("");
        panel = new JPanel();
        panel.add(label1);
        panel.add(Location);
        panel.add(label2);
        panel.add(PackType);
        panel.add(Send);
        panel.add(TOaddress);
        panel.add(Fromaddress);
        panel.add(ETA);

        Send.addActionListener(new ActionListener() {
            /*
            This is where we are making sure if the user actually pressed the button to request help. and taking appropriate actions to help out the person in need.
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Your Help is on the way! Hang in there",null,JOptionPane.PLAIN_MESSAGE);
                PatientRequestGoogleAPI address = null;
                Map temp =null;
                try {

                    address = new PatientRequestGoogleAPI(Location.getText());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    TOaddress.setText("To: " + Location.getText() +"     ");
                try {
                    Fromaddress.setText("Drone sent From: " + Closest.closestDrone(address.getLocation()).getAddresss());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                double time = address.timeToArrival(Closest.closestDrone(address.getLocation()));
                ETA.setText("ETA: " + (int)time +" mins " + (int)((time-(int)time)*60) + " sec" );
                    Send.setEnabled(false);
                    Location.setEnabled(false);
                    PackType.setEnabled(false);
            }

        });

        add(panel);
    }

/*
Used to create the GUI for the application.
 */
    public static void main(String[] args) {
        GUI temp = new GUI();
        temp.setSize(400,300);
        temp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
