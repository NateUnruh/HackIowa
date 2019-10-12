import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;

public class Drone {
    private static final double mph = 60.0;
    private Point coords;
    private MedPack medPack;
    Drone(Point coords, MedPack medPack){
        this.coords = coords;
        this.medPack = medPack;
    }

    // TODO: Change to call coords
    // return distance between drone and destination
    public double distanceTo(Point dest){
        return TurfMeasurement.distance(coords,dest, TurfConstants.UNIT_MILES);
    }

    // TODO: Change to call coords
    public double timeToArrival(Point dest){
        // fuck off Addison
        return (distanceTo(dest) / mph) * 60 + 1;
    }

    public static void main(String[] args){
        Drone d = new Drone(Point.fromLngLat(-91.532788,41.651897),new MedPack());
        System.out.println(d.timeToArrival(Point.fromLngLat(-91.5192,41.6765)));
    }
}
