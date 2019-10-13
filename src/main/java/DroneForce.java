/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: DroneForce
 * Description of Class: This Class Stores all Drones in a Array List. Creates Two drones per station. There are
 *  14 different stations.
 */

// Importing Mapbox and Google APIs
import com.mapbox.geojson.Point;

// Importing Array List
import java.util.ArrayList;

// Creating Drone Force Class
/**This Class Stores all Drones in a Array List. Creates Two drones per station. There are 14 different stations.*/
public class DroneForce {

    // Private Array List that stores the Drones
    private ArrayList<Drone> DronesList;

    // Constructor of DroneForce Class
    public DroneForce(){

        // All Locations with their respective Longitude and Latitude
        final Point MercyH = Point.fromLngLat(41.664240, -91.528365);
        final Point UIowaHCRiverLanding = Point.fromLngLat(41.681955, -91.564041);
        final Point VAHospital = Point.fromLngLat(41.663993,-91.547788);
        final Point UIowaHospital = Point.fromLngLat(41.658977,-91.548274);
        final Point UHeightsPolice = Point.fromLngLat(41.655997, -91.559997);
        final Point FireStation2 = Point.fromLngLat(41.655364, -91.564856);
        final Point CareAmbulance = Point.fromLngLat(41.640012,-91.541433);
        final Point ICPoliceSubstation = Point.fromLngLat(41.640712,-91.521152);
        final Point FireStation3 = Point.fromLngLat(41.640929, -91.505735);
        final Point JohnsonAmbulance = Point.fromLngLat(41.651773, -91.532835);
        final Point JohnsonSheriffsOffice = Point.fromLngLat(41.654967,-91.53640);
        final Point UIowaPolice = Point.fromLngLat( 41.658638,-91.535923);
        final Point ICPolice = Point.fromLngLat(41.660262, -91.529752);
        final Point FireStation4 = Point.fromLngLat(41.680848, -91.507113);

        // Matrice 600 Pro Drone Data
        final double MatriceMph = 40.0;
        final double MatriceBatteryRange = 18.0;
        final double MatriceMaxPayLoad = 5500;

        // Inspire 2 Drone Data
        final double InspireMph = 58.0;
        final double InspireBatteryRange = 27.0;
        final double InspireMaxPayLoad = 21360.78;

        // Creating the List of Drones
        DronesList = new ArrayList<>();

        /* Adding DJI Matrice 600 Pro Drones*/
        DronesList.add(new Drone(MercyH, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UIowaHCRiverLanding, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(VAHospital, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UIowaHospital, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UHeightsPolice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(FireStation2, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(CareAmbulance, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(ICPoliceSubstation, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(FireStation3, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(JohnsonAmbulance, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(JohnsonSheriffsOffice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UIowaPolice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(ICPolice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(FireStation4, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));

        /* Adding DJI Inspire 2 Drones*/
        DronesList.add(new Drone(MercyH, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UIowaHCRiverLanding, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(VAHospital, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UIowaHospital, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UHeightsPolice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(FireStation2, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(CareAmbulance, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(ICPoliceSubstation, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(FireStation3, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(JohnsonAmbulance, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(JohnsonSheriffsOffice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UIowaPolice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(ICPolice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(FireStation4, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
    }

    // Returns the DroneList
    public ArrayList<Drone> getDronesList() {
        return DronesList;
    }
}
