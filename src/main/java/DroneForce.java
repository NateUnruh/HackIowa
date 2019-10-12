import com.mapbox.geojson.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DroneForce {
    private List<Drone> Drones;

    private Point leftBot;
    private Point rightTop;
    DroneForce(Point leftBot, Point rightTop, int numDrones){
        Drones = new ArrayList<>();
        for(int i = 0; i < numDrones; i++){
            double longitude = ThreadLocalRandom.current().nextDouble(leftBot.longitude(),rightTop.longitude());
            double latitude = ThreadLocalRandom.current().nextDouble(leftBot.latitude(),rightTop.latitude());
            Drones.add(new Drone(60,Point.fromLngLat(longitude,latitude), 1000, new MedPack(ThreadLocalRandom.current().nextInt(0,2+1))));
        }
    }

}
