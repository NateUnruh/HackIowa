import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;
public class Map {

    // Create a GeoJSON point representation of the locations.
    private static final Point TOWER_BRIDGE = Point.fromLngLat(-0.07515, 51.50551);
    private static final Point LONDON_EYE = Point.fromLngLat(-0.12043, 51.50348);

    // Run the points through the Turf Measurement method and receive the distance.;

    //MapboxGeocoding mapboxGeocoding = MapboxGeocoding.builder().accessToken("pk.eyJ1IjoibmF0ZXVucnVoIiwiYSI6ImNrMW5tODU2ZDAyM2EzZHBmeWYzNW9oNWwifQ.wMcNUd8CHVB6c_DIv6lXHg").query("707 South Dubuque St. Iowa City, IA").build();
    public static void main(String[] args){
        MapboxGeocoding mapboxGeocoding = MapboxGeocoding.builder().accessToken("pk.eyJ1IjoibmF0ZXVucnVoIiwiYSI6ImNrMW5tODU2ZDAyM2EzZHBmeWYzNW9oNWwifQ.wMcNUd8CHVB6c_DIv6lXHg").query("707 South Dubuque St. Iowa City, IA").build();
        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(retrofit2.Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();

                if (results.size() > 0) {

                    // Log the first results Point.
                    Point firstResultPoint = results.get(0).center();
                    System.out.println(firstResultPoint.coordinates());

                } else {

                    // No result for your request were found.
                    System.out.println("No response found");

                }
            }


            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }
}
