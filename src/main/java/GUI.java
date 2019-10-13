import com.google.maps.errors.ApiException;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class GUI extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JTextField Location;
    private JComboBox PackType;
    private JButton Send;
    private JPanel panel;

    public GUI(){
        setTitle("HELP!!!!");
        setVisible(true);
        label1 = new JLabel("Location");
        label2 = new JLabel("Pack Type");
        String[] options = {"Emergency","First Aid"};
        Location = new JTextField("",30);
        PackType = new JComboBox<>(options);
        Send = new JButton("Send Request");
        panel = new JPanel();
        panel.add(label1);
        panel.add(Location);
        panel.add(label2);
        panel.add(PackType);
        panel.add(Send);

        Send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                JOptionPane.showMessageDialog(null,"Your Help is on the way! Hold it there",null,JOptionPane.PLAIN_MESSAGE);
                PatientRequestGoogleAPI address = null;
                try {
                    address = new PatientRequestGoogleAPI(Location.getText());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(address.getLocation());
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        GUI temp = new GUI();
        temp.setSize(400,200);
        temp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
