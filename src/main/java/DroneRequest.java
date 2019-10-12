import com.mapbox.geojson.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DroneRequest {

    private List<Drone> Drones;

    private Point leftBot;
    private Point rightTop;
    DroneRequest(Point leftBot, Point rightTop, int numDrones){
        Drones = new ArrayList<>();
        for(int i = 0; i < numDrones; i++){
            double longitude = ThreadLocalRandom.current().nextDouble(leftBot.longitude(),rightTop.longitude());
            double latitude = ThreadLocalRandom.current().nextDouble(leftBot.latitude(),rightTop.latitude());
            Drones.add(new Drone(Point.fromLngLat(longitude,latitude), new MedPack()));
        }
    }

    // TODO: Add medpack validation
    private Drone closestDrone(Point dest){
        double time = Double.MAX_VALUE;
        Drone closest = null;
        for(Drone i : Drones){
            if(i.distanceTo(dest) < time){
                closest = i;
                time = closest.distanceTo(dest);
            }
        }
        if (time == Double.MAX_VALUE){
            throw new IllegalArgumentException("No drone available in bounding box (Iowa City).");
        }
        return closest;
    }

    public static void main(String [] args){
        Point request = Point.fromLngLat(45,15);

        DroneRequest d = new DroneRequest(Point.fromLngLat(0,0),Point.fromLngLat(150,41.685183), 10);
        for(Drone i : d.Drones){
            System.out.println(i.getCoords() + " Distance: " + i.distanceTo(request));
        }


        Drone closest = d.closestDrone(request);
        System.out.println("Closest");
        System.out.println(closest.getCoords() + " Distance: " + closest.distanceTo(request));

    }
}
