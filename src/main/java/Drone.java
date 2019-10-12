import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfMeasurement;

public class Drone {
    private Point coords;
    private MedPack medPack;
    Drone(Point coords, MedPack medPack){
        this.coords = coords;
        this.medPack = medPack;
    }

    public double distanceTo(Point dest){
        return TurfMeasurement.distance(coords,dest,"FEET");
    }
}
