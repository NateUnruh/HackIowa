/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: DroneRequest
 * Description of Class: This Class Requests the Drones that are able to make it to the Destination
 */

// Importing Mapbox and Google API's
import com.mapbox.geojson.Point;

// Importing essential Java classes
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Creating DroneRequest Class
/** This Class tests the Drone Class to make sure that it all working. */
public class DroneRequest extends DroneForce{

    // Creating the List of Drones
    private List<Drone> Drones;

    // Grabbing the List of Drones from DroneForce
    DroneRequest(){
        Drones = new DroneForce().getDronesList();
    }

    // Method to find the closest Drone related to the Destination
    // TODO: Add medpack validation
    public Drone closestDrone(Point dest){
        double time = Double.MAX_VALUE;
        Drone closest = null;
        for(Drone i : Drones){
            if(i.isHome()){
                if(i.getBatteryLife() > i.distanceTo(dest)*2){
                    if(i.distanceTo(dest) < time){
                        closest = i;
                        time = closest.distanceTo(dest);
                    }
                }
            }

        }
        if (time == Double.MAX_VALUE){
            throw new IllegalArgumentException("No drone available in bounding box (Iowa City).");
        }
        return closest;
    }

    // Find closest available drone that can make it there and back and has relevant med pack.
    private Drone closestDrone(PatientRequest request){
        Point dest = request.getLocation();
        int type = request.getType();
        double time = Double.MAX_VALUE;
        Drone closest = null;
        for(Drone i : Drones){
            if(i.isHome()){
                if(i.getBatteryLife() > i.distanceTo(dest)*2){
                    if(i.getMedPack().getPackageNum() <= type){
                        if(i.distanceTo(dest) < time){
                            closest = i;
                            time = closest.distanceTo(dest);
                        }
                    }

                }
            }

        }
        if (time == Double.MAX_VALUE){
            throw new IllegalArgumentException("No drone available in bounding box (Iowa City).");
        }
        return closest;
    }

    // Testing Main Class
    public static void main(String [] args){
        Point dest = Point.fromLngLat(-91.55,41.65);
        PatientRequest request = new PatientRequest(dest,0);

        DroneRequest d = new DroneRequest();
        for(Drone i : d.Drones){
            System.out.println(i.getCoords() + " Distance: " + i.distanceTo(request.getLocation()) + " Type of medPack: " + i.getMedPack().getPackageNum());
        }

        Drone closest = d.closestDrone(request);
        System.out.println("Closest");
        System.out.println(closest.getCoords() + " Distance: " + closest.distanceTo(request.getLocation()));

    }
}
