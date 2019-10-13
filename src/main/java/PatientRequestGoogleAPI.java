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

import java.io.IOException;

public class PatientRequestGoogleAPI {

    private static String APIkey = "AIzaSyDZ-Kk-itsqd04Z5hJtmndjlYa1teL170s\n";
    private Point location;
    private int type;
    PatientRequestGoogleAPI(String loc) throws InterruptedException, ApiException, IOException {
        GeocodingResult[] result = GeocodingApi.newRequest(new GeoApiContext.Builder().apiKey(APIkey).build()).address(loc).await();
        this.location = Point.fromLngLat(result[0].geometry.location.lat,result[0].geometry.location.lng);
        this.type = 0;
        System.out.println(location);
    }

    PatientRequestGoogleAPI(String loc, int type) throws InterruptedException, ApiException, IOException {
        GeocodingResult[] result = GeocodingApi.newRequest(new GeoApiContext.Builder().apiKey(APIkey).build()).address(loc).await();
        this.location = Point.fromLngLat(result[0].geometry.location.lat,result[0].geometry.location.lng);
        this.type = 0;
        System.out.println(location);
    }

    PatientRequestGoogleAPI(Point point, int type){
        this.location = point;
        this.type = type;
    }

    PatientRequestGoogleAPI(Point point){
        this.location = point;
        this.type = 0;
    }



    public static void main (String [] args) throws InterruptedException, ApiException, IOException {
        PatientRequestGoogleAPI p = new PatientRequestGoogleAPI("1600 West Pennsylvania Avenue");
    }
}
