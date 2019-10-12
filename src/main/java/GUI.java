import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

        add(panel);
    }

    public static void main(String[] args) {
        GUI temp = new GUI();
        temp.setSize(400,200);
        temp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
