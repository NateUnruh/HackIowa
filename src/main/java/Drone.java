import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;

public class Drone {
    private double mph = 60.0;
    private Point homeCoords;
    private Point coords;
    private double batteryRange = 25;
    private double batteryLife;
    private MedPack medPack;
    private boolean home = false;
    private double maxPayLoad = 5; //measured in pounds
    private double operatingTempLow = 0;
    private double operatingTempHigh = 0;


    Drone(Point coords, MedPack medPack){
        this.homeCoords = coords;
        this.coords = this.homeCoords;
        this.medPack = medPack;
        this.home = true;
    }

    Drone(Point coords, MedPack medPack, double mph, double maxPayLoad, double operatingTempLow, double operatingTempHigh, double batteryRange){
        this.coords = coords;
        this.medPack = medPack;
        this.home = true;
        this.mph = mph;
        this.maxPayLoad = maxPayLoad;
        this.operatingTempLow = operatingTempLow;
        this.operatingTempHigh = operatingTempHigh;
        this.batteryRange = batteryRange;
        this.batteryLife = batteryRange;
    }

    public Drone(double mph, Point homeCoords, double batteryRange, MedPack medPack) {
        this.mph = mph;
        this.home = true;
        this.coords = homeCoords;
        this.homeCoords = homeCoords;
        this.batteryRange= batteryRange;
        this.batteryLife = batteryRange;
        this.medPack = medPack;
    }

    public Drone(double mph, Point homeCoords, double batteryRange){
        this.mph = mph;
        this.home = true;
        this.coords = homeCoords;
        this.homeCoords = homeCoords;
        this.batteryRange = batteryRange;
        this.batteryLife = batteryRange;


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

    public double getOperatingTempLow() {
        return operatingTempLow;
    }

    public double getOperatingTempHigh() {
        return operatingTempHigh;
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

    public void setOperatingTempLow(double operatingTempLow) {
        this.operatingTempLow = operatingTempLow;
    }

    public void setOperatingTempHigh(double operatingTempHigh) {
        this.operatingTempHigh = operatingTempHigh;
    }

    //
    public void move(Point dest){
        home = false;
        batteryLife -= distanceTo(dest);
        this.coords = dest;
    }



    //testing main
    public static void main(String[] args){
        Drone d = new Drone(Point.fromLngLat(-91.532788,41.651897),new MedPack(2));
        System.out.println(d.timeToArrival(Point.fromLngLat(-91.5192,41.6765)));
    }
}
