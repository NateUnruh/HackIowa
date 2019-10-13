/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: PatientRequestGoogleAPI
 * Description of Class: Sets the pack type, longitude, and latitude of the request location based on an
 * input address string using google maps api. It is stored as a JSon point.
 */

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.GeolocationResult;
import com.mapbox.geojson.Point;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.OverQueryLimitException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.ExceptionsAllowedToRetry;
import com.google.maps.internal.UrlSigner;

import javax.xml.stream.Location;
import java.io.IOException;

//Creating class to link us to the google geocoding
public class PatientRequestGoogleAPI {
    private static String APIkey = "AIzaSyDZ-Kk-itsqd04Z5hJtmndjlYa1teL170s";
    private Point location;
    private int type;

    //Constructor using a string location
    PatientRequestGoogleAPI(String loc) throws InterruptedException, ApiException, IOException {
        GeocodingResult[] result = GeocodingApi.newRequest(new GeoApiContext.Builder().apiKey(APIkey).build()).address(loc).await();
        this.location = Point.fromLngLat(result[0].geometry.location.lat,result[0].geometry.location.lng);
        this.type = 0;
        System.out.println(location);
    }

    //Constructor using a string location and type of package
    PatientRequestGoogleAPI(String loc, int type) throws InterruptedException, ApiException, IOException {
        GeocodingResult[] result = GeocodingApi.newRequest(new GeoApiContext.Builder().apiKey(APIkey).build()).address(loc).await();
        this.location = Point.fromLngLat(result[0].geometry.location.lat,result[0].geometry.location.lng);
        this.type = 0;
        System.out.println(location);
    }

    //Constructor using a point and type of package
    PatientRequestGoogleAPI(Point point, int type){
        this.location = point;
        this.type = type;
    }

    //Constuctor using a point
    PatientRequestGoogleAPI(Point point){
        this.location = point;
        this.type = 0;
    }

    //returns the point
    public Point getLocation()
    {
        return location;
    }

    //returns the time it will take the drone to arrive
    public double timeToArrival(Drone d){
        return d.timeToArrival(location);
    }

    //returns the type
    public int getType(){
        return type;
    }

    //main we used to test
    public static void main (String [] args) throws InterruptedException, ApiException, IOException {
        PatientRequestGoogleAPI p = new PatientRequestGoogleAPI("707 S Dubuque St Iowa City");
    }
}
