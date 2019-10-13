import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;

import java.io.IOException;
import java.util.ArrayList;

public class Drone{
    private static final String APIkey =  "AIzaSyDZ-Kk-itsqd04Z5hJtmndjlYa1teL170s";
    private double mph = 30.0; // in mph
    private Point homeCoords;
    private Point coords;
    private double batteryRange; // in miles
    private double batteryLife; // in miles
    private MedPack medPack = new MedPack(0);
    private boolean home = false; // is it home?
    private double maxPayLoad = 5; //measured in pounds
    private final Point LeftBot = Point.fromLngLat( -91.611807, 41.629109); //Left Bottom Corner of Box
    private final Point RightTop = Point.fromLngLat( -91.462394, 41.693394); //Right Top Corner of Box

    Drone(Point homeCoords, double mph, double batteryRange, double maxPayLoad){
        this.homeCoords = homeCoords;
        this.coords = homeCoords;
        this.mph = mph;
        this.batteryRange = batteryRange;
        this.batteryLife = batteryRange;
        this.maxPayLoad = maxPayLoad;
        this.home = true;
    }

    // TODO: Change to call coords
    // return distance between drone and destination
    public double distanceTo(Point dest){
        return TurfMeasurement.distance(coords,dest, TurfConstants.UNIT_MILES);
    }

    // TODO: Change to call coords
    public double timeToArrival(Point dest){
        return (distanceTo(dest) / mph) * 60 + 1;
    }

    public Point getCoords() {
        return coords;
    }

    public double getMaxPayLoad() {
        return maxPayLoad;
    }

    public double getMph() {
        return mph;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public MedPack getMedPack() {
        return medPack;
    }

    public boolean isHome() {
        return home;
    }

    public void setMph(double mph) {
        this.mph = mph;
    }

    public void setHomeCoords(Point homeCoords) {
        this.homeCoords = homeCoords;
    }

    public void setCoords(Point coords) {
        this.coords = coords;
    }

    public void setBatteryRange(double batteryRange) {
        this.batteryRange = batteryRange;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void setMedPack(MedPack medPack) {
        this.medPack = medPack;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public void setMaxPayLoad(double maxPayLoad) {
        this.maxPayLoad = maxPayLoad;
    }

    public String getAddresss() throws InterruptedException, ApiException, IOException {
        GeocodingResult[] results = GeocodingApi.newRequest(new GeoApiContext.Builder().apiKey(APIkey).build()).latlng(new LatLng(coords.longitude(),coords.latitude())).await();
        return results[0].formattedAddress;
    }

    public void move(Point dest){
        home = false;
        batteryLife -= distanceTo(dest);
        this.coords = dest;
    }



    //testing main
    public static void main(String[] args) throws InterruptedException, ApiException, IOException {
//        Drone d = new Drone(Point.fromLngLat(-91.532788,41.651897),new MedPack(2));
        DroneForce Array = new DroneForce();
        ArrayList<Drone> ArrayList = Array.getDronesList();
        for(Drone drone : ArrayList) {
            System.out.println(drone.timeToArrival(Point.fromLngLat(-91.5192, 41.6765)));
        }
        System.out.println(ArrayList.get(0).getAddresss());
    }
}
