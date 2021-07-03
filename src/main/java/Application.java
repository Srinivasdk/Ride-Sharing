import exceptions.InvalidVehicle;
import exceptions.NoRideFound;
import manager.RideManager;
import manager.UserManager;
import model.MostVacantStrategy;
import model.PreferredVehicleStrategy;
import model.Ride;
import model.SelectionStrategyType;
import model.User;
import model.Vehicle;

import java.util.Collection;
import java.util.List;

public class Application {
    private UserManager userManager;
    private RideManager rideManager;

    public Application() {
        this.userManager = new UserManager();
        this.rideManager = new RideManager();

    }



    public void add_user(String name, String gender, int age) {
        User user = new User(name, gender, age);
        userManager.addUser(user);
    }

    public void add_vehicle(String name, String model, String vehicleNumber) {
        Vehicle vehicle = new Vehicle(name, model, vehicleNumber);
        User user = userManager.getUser(vehicle.getName());
        user.addVehicle(vehicle);
        System.out.println("added vehicle to user succesfully");
    }

    public void offer_ride(String name , String origin, int availableSeats, String model, String vehicleNumber, String destination) {
        try {
            Ride ride  = new Ride(name, origin, availableSeats, model, vehicleNumber, destination);
            User user = userManager.getUser(name);
            if(!user.checkVehicle(vehicleNumber))
                throw new InvalidVehicle();
            rideManager.addOfferRide(ride);
            System.out.println("Ride offered by "+name+" from "+origin+" to "+destination+". Available Seats "+
                    availableSeats+" vehicle "+vehicleNumber+ " vehicleNumber "+vehicleNumber);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public Ride select_ride(String userName, String origin, String destination, int seats, SelectionStrategyType strategy, String vehicle)
    {
        Ride ride=null;
        try{
            if(strategy.equals(SelectionStrategyType.PREFFERED))
            {
                PreferredVehicleStrategy st=new PreferredVehicleStrategy();
                ride=st.findRides(origin, destination, seats, rideManager,vehicle );
            }
            else if(strategy.equals(SelectionStrategyType.MOST_VACANT))
            {
                MostVacantStrategy st=new MostVacantStrategy();
                ride= st.findRides(origin, destination, seats, rideManager,vehicle);
            }
            if(ride!=null)
            {
                ride.addPassenger(userName, seats);
            }
            else
                throw new NoRideFound();
            System.out.println(ride.toString());
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }
        return ride;
    }



    public void end_ride(String userName,String origin, int availableSeats, String vehicleModel ,String vehicleNumber, String destination)
    {
        Ride ride=rideManager.endRide(vehicleNumber);
        ride.endRide();
        String sharedBy=ride.getSharedBy();
        List<String> passengers=ride.getSelectedBy();

        User user=userManager.getUser(sharedBy);
        user.addSharedRide(ride);

        for(String s: passengers)
        {
            user=userManager.getUser(s);
            user.addConsumedRide(ride);
        }
    }

    public void print_ride_status()
    {
        Collection<User> users=userManager.getUsers();
        users.forEach((user) -> {
            System.out.println(user.getName()+": "+user.getConsumedRides().size()+" Taken "+user.getSharedRides().size()+" Offered");
        });
    }

}
