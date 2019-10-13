/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: Drone
 * Description of Class: This class is for the creation of Drones. Drones contain a lot of important information and
 *  that must be stored for use. This class stores the Max Speed of Drone in MPH, Max Pay Load in Grams, and Max Battery
 *  Range in Miles. Each Drone also stores home location, if it is home, new coordinates, battery life, and the boundary
 *  box.
 */

// Importing MapBox and Google API's
import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;


import java.io.IOException;

// Importing Java ArrayList to store all drones

import java.util.ArrayList;

//Creating Drone Class
/** Drone Class that stores important information about Drone*/
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


    // Constructor of Drone Class
    Drone(Point homeCoords, double mph, double batteryRange, double maxPayLoad){
        this.homeCoords = homeCoords;
        this.coords = homeCoords;
        this.mph = mph;
        this.batteryRange = batteryRange;
        this.batteryLife = batteryRange;
        this.maxPayLoad = maxPayLoad;
        this.home = true;
    }

    // Return distance between drone and destination
    public double distanceTo(Point dest){
        return TurfMeasurement.distance(coords,dest, TurfConstants.UNIT_MILES);
    }

    // Return time to get to destination
    public double timeToArrival(Point dest){
        return (distanceTo(dest) / mph) * 60 + 1;
    }

    // Return the Current Coordinates
    public Point getCoords() {
        return coords;
    }

    // Return the Max Pay Load
    public double getMaxPayLoad() {
        return maxPayLoad;
    }

    // Return the Max MPH
    public double getMph() {
        return mph;
    }

    // Return the battery life
    public double getBatteryLife() {
        return batteryLife;
    }

    // Returns the current MedPack
    public MedPack getMedPack() {
        return medPack;
    }

    // Return if Drone is home
    public boolean isHome() {
        return home;
    }


    // Setting Destination Coords
    public void setCoords(Point coords) {
        this.coords = coords;
    }

    // Setting the Currently Battery Life
    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

    // Set the current Med Pack
    public void setMedPack(MedPack medPack) {
        this.medPack = medPack;
    }

    // Set if the Drone is home
    public void setHome(boolean home) {
        this.home = home;
    }

    // Setter of MaxPayLoad
    public void setMaxPayLoad(double maxPayLoad) {
        this.maxPayLoad = maxPayLoad;
    }

    // Gets Address of Destination
    public String getAddresss() throws InterruptedException, ApiException, IOException {
        GeocodingResult[] results = GeocodingApi.newRequest(new GeoApiContext.Builder().apiKey(APIkey).build()).latlng(new LatLng(coords.longitude(),coords.latitude())).await();
        return results[0].formattedAddress;
    }


    // Move Function to send Drone to destination
    public void move(Point dest){
        home = false;
        batteryLife -= distanceTo(dest);
        this.coords = dest;
    }

    //testing main
    public static void main(String[] args) throws InterruptedException, ApiException, IOException {
        DroneForce Array = new DroneForce();
        ArrayList<Drone> ArrayList = Array.getDronesList();
        for(Drone drone : ArrayList) {
            System.out.println(drone.timeToArrival(Point.fromLngLat(-91.5192, 41.6765)));
        }
        System.out.println(ArrayList.get(0).getAddresss());
    }
}
