package model;

import manager.RideManager;

public interface SelectionStrategy {

    public Ride findRides(String origin, String destination, int seats, RideManager rideManager, String vehicleNumber);
}
