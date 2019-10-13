import com.google.maps.errors.ApiException;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Map {

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
    }
}
