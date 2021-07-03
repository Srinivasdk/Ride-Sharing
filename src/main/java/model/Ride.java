package model;

import enums.RideStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ride {
    private UUID id;
    private String sharedBy;
    private String origin;
    private int availableSeats;
    private String model;
    private String vehicleNumber;
    private String destination;
    private List<String> selectedBy;
    private RideStatus status;

    public Ride(String sharedBy, String origin, int availableSeats, String model, String vehicleNumber, String destination) {
        this.sharedBy = sharedBy;
        this.origin = origin;
        this.availableSeats = availableSeats;
        this.model = model;
        this.selectedBy = new ArrayList<>();
        this.vehicleNumber = vehicleNumber;
        this.destination = destination;
        this.status = RideStatus.ACITIVE;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<String> getSelectedBy() {
        return selectedBy;
    }

    public void setSelectedBy(List<String> selectedBy) {
        this.selectedBy = selectedBy;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void addPassenger(String passenger, int seats)
    {
        selectedBy.add(passenger);
        this.availableSeats-=seats;
    }

    public void endRide()
    {
        this.status= RideStatus.END;
    }
}
