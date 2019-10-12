import com.mapbox.geojson.Point;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DroneRequest {

    private List<Drone> Drones;

    private Point leftBot;
    private Point rightTop;
    DroneRequest(Point leftBot, Point rightTop, int numDrones){
        for(int i = 0; i < numDrones; i++){
            double longitude = ThreadLocalRandom.current().nextDouble(leftBot.longitude(),rightTop.longitude());
            double latitude = ThreadLocalRandom.current().nextDouble(leftBot.latitude(),rightTop.latitude());
            Drones.add(new Drone(Point.fromLngLat(longitude,latitude), new MedPack()));
        }
    }

    public static void main(String [] args){
        DroneRequest d = new DroneRequest(Point.fromLngLat(-91.602601,41.633585),Point.fromLngLat(-91.481816,41.685183), 10);
        for(Drone i : d.Drones){
            System.out.println(i);
        }
    }
}
