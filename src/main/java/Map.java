import com.google.maps.GeoApiContext;
import com.google.maps.StaticMapsRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class Map {

    private static String APIkey = "AIzaSyDZ-Kk-itsqd04Z5hJtmndjlYa1teL170s";
    private DroneRequest drones;
    private List<PatientRequestGoogleAPI> patients;
    // Create a GeoJSON point representation of the locations.
    Map(){
        drones = new DroneRequest();
        patients = new ArrayList<>();

    }

    public Drone addPatient(String loc) throws InterruptedException, ApiException, IOException {
        PatientRequestGoogleAPI p = new PatientRequestGoogleAPI(loc);
        patients.add(p);
        return drones.closestDrone(p.getLocation());
    }

    public static void main(String[] args) throws InterruptedException, ApiException, IOException {
        Map m = new Map();
        Drone d = m.addPatient("707 S Dubuque St Iowa City, IA");
        System.out.println(d.getCoords().longitude() + " " + d.getCoords().latitude());
        StaticMapsRequest z = new StaticMapsRequest(new GeoApiContext.Builder().apiKey(APIkey).build()).size(new com.google.maps.model.Size(5,5));
        z.center(new LatLng(m.patients.get(0).getLocation().latitude(),m.patients.get(0).getLocation().longitude()));
        System.out.println(z.toString());
        JFrame test = new JFrame("Google Maps");

        try {
            String imageUrl = "http://maps.google.com/staticmap?center=40,26&zoom=1&size=150x112&maptype=satellite&key=" + APIkey + "&format=jpg";
            String destinationFile = "src/main/image.jpg";
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        test.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600,
                java.awt.Image.SCALE_SMOOTH))));

        test.setVisible(true);
        test.pack();

    }
}
