import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;

public class Drone {
    private double mph = 60.0;



    private Point coords;
    private double batteryLife = 25;
    private MedPack medPack;
    private boolean home = false;
    private double maxPayLoad = 5; //measured in pounds
    private double operatingTempLow = 0;
    private double operatingTempHigh= 0;


    Drone(Point coords, MedPack medPack){
        this.coords = coords;
        this.medPack = medPack;
        this.home = true;
    }

    Drone(Point coords, MedPack medPack, double mph, double maxPayLoad, double operatingTempLow, double operatingTempHigh){
        this.coords = coords;
        this.medPack = medPack;
        this.home = true;
        this.mph = mph;
        this.maxPayLoad = maxPayLoad;
        this.operatingTempLow = operatingTempLow;
        this.operatingTempHigh = operatingTempHigh;
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

    public Point getCoords() {
        return coords;
    }

    //
    public void move(Point dest){
        home = false;
        batteryLife -= distanceTo(dest);
        this.coords = dest;
    }



    //testing main
    public static void main(String[] args){
        Drone d = new Drone(Point.fromLngLat(-91.532788,41.651897),new MedPack());
        System.out.println(d.timeToArrival(Point.fromLngLat(-91.5192,41.6765)));
    }
}
