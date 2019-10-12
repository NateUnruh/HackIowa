import com.mapbox.geojson.Point;

import java.util.ArrayList;

public class DroneForce {

    private ArrayList<Drone> DronesList;


    public DroneForce(){
        final Point MercyH = Point.fromLngLat( -91.528365,41.664240);
        final Point UIowaHCRiverLanding = Point.fromLngLat( -91.564041,41.681955);
        final Point VAHospital = Point.fromLngLat(-91.547788, 41.663993);
        final Point UIowaHospital = Point.fromLngLat(-91.548274, 41.658977);
        final Point UHeightsPolice = Point.fromLngLat( -91.559997,41.655997);
        final Point FireStation2 = Point.fromLngLat( -91.564856, 41.655364);
        final Point CareAmbulance = Point.fromLngLat(-91.541433,41.640012);
        final Point ICPoliceSubstation = Point.fromLngLat(-91.521152, 41.640712);
        final Point FireStation3 = Point.fromLngLat( -91.505735, 41.640929);
        final Point JohnsonAmbulance = Point.fromLngLat( -91.532835, 41.651773);
        final Point JohnsonSherriffsOffice = Point.fromLngLat(-91.53640, 41.654967);
        final Point UIowaPolice = Point.fromLngLat( -91.535923, 41.658638);
        final Point ICPolice = Point.fromLngLat( -91.529752, 41.660262);
        final Point FireStation4 = Point.fromLngLat( -91.507113, 41.680848);
        double MatriceMph = 40.0;
        double MatriceBatteryRange = 18.0;
        double MatriceMaxPayLoad = 12.1254;

        double InspireMph = 58.0;
        double InspireBatteryRange = 27.0;
        double InspireMaxPayLoad = 2.0;

        DronesList = new ArrayList<>();
        //Drone(Point homeCoords, double mph, double batteryRange, double maxPayLoad)
        /* Adding DJI Matrice 600 Pro Drones*/
        DronesList.add(new Drone(MercyH, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UIowaHCRiverLanding, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(VAHospital, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UIowaHospital, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UHeightsPolice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(FireStation2, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(CareAmbulance, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(ICPoliceSubstation, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(FireStation3, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(JohnsonAmbulance, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(JohnsonSherriffsOffice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(UIowaPolice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(ICPolice, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));
        DronesList.add(new Drone(FireStation4, MatriceMph, MatriceBatteryRange, MatriceMaxPayLoad));

        /* Adding DJI Inspire 2 Drones*/
        DronesList.add(new Drone(MercyH, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UIowaHCRiverLanding, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(VAHospital, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UIowaHospital, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UHeightsPolice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(FireStation2, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(CareAmbulance, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(ICPoliceSubstation, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(FireStation3, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(JohnsonAmbulance, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(JohnsonSherriffsOffice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(UIowaPolice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(ICPolice, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
        DronesList.add(new Drone(FireStation4, InspireMph, InspireBatteryRange, InspireMaxPayLoad));
    }

    public ArrayList<Drone> getDronesList() {
        return DronesList;
    }
}
