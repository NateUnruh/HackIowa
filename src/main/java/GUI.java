import com.google.maps.errors.ApiException;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class GUI extends JFrame {
    private DroneRequest Closest;
    private JLabel label1;
    private JLabel label2;
    private JTextField Location;
    private JComboBox PackType;
    private JButton Send;
    private JPanel panel;
    private JLabel TOaddress;
    private JLabel Fromaddress;
    private JLabel ETA;

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
                    Fromaddress.setText("Drone sent From: " + "");
                    ETA.setText("ETA: " + address.timeToArrival(Closest.closestDrone(address.getLocation())));
                    Send.setEnabled(false);
                    Location.setEnabled(false);
                    PackType.setEnabled(false);
            }

        });

        add(panel);
    }

    public static void main(String[] args) {
        GUI temp = new GUI();
        temp.setSize(400,300);
        temp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
