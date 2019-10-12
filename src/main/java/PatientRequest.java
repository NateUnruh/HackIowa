import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class PatientRequest {
    private Point location;
    private int type;

    private static final String accessToken = "pk.eyJ1IjoibmF0ZXVucnVoIiwiYSI6ImNrMW5tODU2ZDAyM2EzZHBmeWYzNW9oNWwifQ.wMcNUd8CHVB6c_DIv6lXHg";
    PatientRequest(Point location, int type){
        this.location = location;
        this.type = type;
    }

    PatientRequest(Point location){
        this.location = location;
        this.type = 0;
    }
    PatientRequest(String request){

        MapboxGeocoding mapboxGeocoding = MapboxGeocoding.builder().accessToken(accessToken).query(request).build();

        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(retrofit2.Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();

                if (results.size() > 0) {

                    // Log the first results Point.
                    Point firstResultPoint = results.get(0).center();
                    System.out.println(firstResultPoint);
                    location = firstResultPoint;
                    System.out.println(location);

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

    }

    PatientRequest(String request, int type){
        MapboxGeocoding mapboxGeocoding = MapboxGeocoding.builder().accessToken("pk.eyJ1IjoibmF0ZXVucnVoIiwiYSI6ImNrMW5tODU2ZDAyM2EzZHBmeWYzNW9oNWwifQ.wMcNUd8CHVB6c_DIv6lXHg").query(request).build();
        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(retrofit2.Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();

                if (results.size() > 0) {

                    // Log the first results Point.
                    Point firstResultPoint = results.get(0).center();
                    System.out.println(firstResultPoint);

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

    public Point getLocation(){
        return this.location;
    }

    public int getType(){
        return type;
    }

    public void setLocation(Point point){
        this.location = point;
    }

    public static void main(String[] args){
        PatientRequest p = new PatientRequest("707 S Dubuque St Iowa City, IA");
        System.out.println(p.getLocation());
    }

}
