package manager;

import exceptions.AlreadyRideExists;
import model.Ride;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RideManager {
    private Map<UUID, Ride> activeRides;

    public RideManager() {
        activeRides = new HashMap<>();
    }
    public Map<UUID,Ride> getActiveRides() {
        return activeRides;
    }

    public void addOfferRide(Ride ride) {
        for(Ride r: activeRides.values())
        {
            if(r.getVehicleNumber().equals(ride.getVehicleNumber()))
                throw new AlreadyRideExists();
        }
        activeRides.put(ride.getId(), ride);
    }


    public Ride endRide(String vehicleNumber)
    {
        for(Ride r: activeRides.values())
        {
            if(r.getVehicleNumber().equals(vehicleNumber))
                return r;
        }
        return null;
    }

}
