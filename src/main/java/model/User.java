package model;

import exceptions.VehicleAlreadyExists;

import java.util.List;

public class User {
    private String name;
    private String gender;
    private int age;
    private List<Vehicle> vehicles;
    private List<Ride> sharedRides;
    private List<Ride> consumedRides;

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public List<Ride> getSharedRides() {
        return sharedRides;
    }

    public void setSharedRides(List<Ride> sharedRides) {
        this.sharedRides = sharedRides;
    }

    public List<Ride> getConsumedRides() {
        return consumedRides;
    }

    public void setConsumedRides(List<Ride> consumedRides) {
        this.consumedRides = consumedRides;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        if(vehicles.contains(vehicle)) {
            throw  new VehicleAlreadyExists();
        }
        vehicles.add(vehicle);
    }

    public boolean checkVehicle(String vehicleNumber) {
        for(Vehicle vehicle : vehicles) {
            if(vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return true;
            }
        }
        return false;
    }

    public void addConsumedRide(Ride ride)
    {
        consumedRides.add(ride);
    }
    public void addSharedRide(Ride ride)
    {
        sharedRides.add(ride);
    }

}
