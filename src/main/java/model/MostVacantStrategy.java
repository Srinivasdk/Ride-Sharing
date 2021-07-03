package model;

import exceptions.NoRideFound;
import manager.RideManager;

import java.util.Map;
import java.util.UUID;

public class MostVacantStrategy implements SelectionStrategy {
    @Override
    public Ride findRides(String origin, String destination, int seats, RideManager rideManager, String vehicle) {
        Map<UUID, Ride> activeRides=rideManager.getActiveRides();

        Ride potentialRide=null;
        int maxAvailabilty=0;
        for(Ride r: activeRides.values())
        {
            if(r.getDestination().equals(destination) && r.getOrigin().equals(origin) && r.getAvailableSeats()>=seats)
            {
                if(r.getAvailableSeats()>maxAvailabilty)
                {
                    maxAvailabilty=r.getAvailableSeats();
                    potentialRide=r;
                }
            }
        }
        if(potentialRide.equals(null))
            throw new NoRideFound();

        return potentialRide;
    }
}
