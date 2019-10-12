import com.mapbox.geojson.Point;

public class PatientRequest {
    private Point location;
    private int type;

    PatientRequest(Point location, int type){
        this.location = location;
        this.type = type;
    }

    PatientRequest(Point location){
        this.location = location;
        this.type = 0;
    }

    public Point getLocation(){
        return this.location;
    }

    public int getType(){
        return type;
    }
}
