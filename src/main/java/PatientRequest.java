/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: PatientRequest
 * Description of Class: Uses MapBox JSon to find the closest drone distance
 */

import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//Class to represent PatientRequest
public class PatientRequest {
    public static DroneRequest drones = new DroneRequest();
    private Point location;
    private int type;

    //out mapbox access token
    private static final String accessToken = "pk.eyJ1IjoibmF0ZXVucnVoIiwiYSI6ImNrMW5tODU2ZDAyM2EzZHBmeWYzNW9oNWwifQ.wMcNUd8CHVB6c_DIv6lXHg";
    PatientRequest(Point location, int type){
        this.location = location;
        this.type = type;
    }

    //Create a patient request with a point
    PatientRequest(Point location){
        this.location = location;
        this.type = 0;
    }

    //Create a patient request with a string
    PatientRequest(String request){

        MapboxGeocoding mapboxGeocoding = MapboxGeocoding.builder().accessToken(accessToken).query(request).build();

        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(retrofit2.Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();

                if (results.size() > 0) {

                    // Log the first results Point.
                    Point firstResultPoint = results.get(0).center();
                    System.out.println(firstResultPoint.coordinates());
                    drones.closestDrone(firstResultPoint).move(firstResultPoint);


                } else {

                    // No result for your request were found.
                    throw new IllegalArgumentException("Invalid request.");
                }
            }


            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        System.out.println(mapboxGeocoding.toString());
    }

    //Create a patient request with a string request and package type
    PatientRequest(String request, int type){
        MapboxGeocoding mapboxGeocoding = MapboxGeocoding.builder().accessToken("pk.eyJ1IjoibmF0ZXVucnVoIiwiYSI6ImNrMW5tODU2ZDAyM2EzZHBmeWYzNW9oNWwifQ.wMcNUd8CHVB6c_DIv6lXHg").query(request).build();
        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(retrofit2.Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();

                if (results.size() > 0) {

                    // Log the first results Point.
                    Point firstResultPoint = results.get(0).center();
                    BufferedWriter out = null;
                    try {
                        out = new BufferedWriter(new FileWriter("src/main/request.txt"));
                        out.write(Double.toString(firstResultPoint.latitude()));
                        out.write(Double.toString(firstResultPoint.longitude()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    // No result for your request were found.
                    throw new IllegalArgumentException("Invalid request.");
                }
            }
            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        this.type = type;
    }

    //return the location
    public Point getLocation(){
        return this.location;
    }

    //return the type
    public int getType(){
        return type;
    }

    //set the location to a new point
    public void setLocation(Point point){
        this.location = point;
    }

    //main used for testing
    public static void main(String[] args){
        PatientRequest p = new PatientRequest("707 S Dubuque St Iowa City, IA");
        System.out.println(p.getLocation());
        for(Drone i : p.drones.getDronesList()){
            System.out.println(i.getCoords() + " Battery life: " + i.getBatteryLife());
        }
    }

}
