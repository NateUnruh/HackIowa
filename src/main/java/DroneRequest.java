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
        // Drones.add(DroneForce.AmazonAirPrime);
        for(int i = 0; i < numDrones; i++){
            double longitude = ThreadLocalRandom.current().nextDouble(leftBot.longitude(),rightTop.longitude());
            double latitude = ThreadLocalRandom.current().nextDouble(leftBot.latitude(),rightTop.latitude());
            Drones.add(new Drone(60,Point.fromLngLat(longitude,latitude), 1000, new MedPack(ThreadLocalRandom.current().nextInt(0,1+1))));
        }
    }

    // TODO: Add medpack validation
    private Drone closestDrone(Point dest){
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



    // TODO: Iowa City bounding box
    public static void main(String [] args){
        Point dest = Point.fromLngLat(5,5);
        PatientRequest request = new PatientRequest(dest,0);

        DroneRequest d = new DroneRequest(Point.fromLngLat(0,0),Point.fromLngLat(10,10), 10);
        for(Drone i : d.Drones){
            System.out.println(i.getCoords() + " Distance: " + i.distanceTo(request.getLocation()) + " Type of medPack: " + i.getMedPack().getPackageNum());
        }


        Drone closest = d.closestDrone(request);
        System.out.println("Closest");
        System.out.println(closest.getCoords() + " Distance: " + closest.distanceTo(request.getLocation()));

    }
}
