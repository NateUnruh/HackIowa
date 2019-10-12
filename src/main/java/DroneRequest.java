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
            Drones.add(new Drone(60,Point.fromLngLat(longitude,latitude), 1000, new MedPack(ThreadLocalRandom.current().nextInt(0,2+1))));
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

    private Drone closestDrone(Point dest, int type){
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



    public static void main(String [] args){
        Point request = Point.fromLngLat(5,5);

        DroneRequest d = new DroneRequest(Point.fromLngLat(0,0),Point.fromLngLat(10,10), 10);
        for(Drone i : d.Drones){
            System.out.println(i.getCoords() + " Distance: " + i.distanceTo(request) + " Type of medPack: " + i.getMedPack().getPackageNum());
        }


        Drone closest = d.closestDrone(request,0);
        System.out.println("Closest");
        System.out.println(closest.getCoords() + " Distance: " + closest.distanceTo(request));

    }
}
