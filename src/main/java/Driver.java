import model.Ride;
import model.SelectionStrategyType;

public class Driver {

    public  static void main(String[] args) {
        Application application = new Application();

        application.add_user("Rohan", "M", 36);
        application.add_vehicle("Rohan", "Swift", "KA-01-12345");

        application.add_user("Shashank", "M", 29);
        application.add_vehicle("Shashank", "Baleno", "TS-05-62395");

        application.add_user("Nandini", "M", 29);

        application.add_user("Shipra", "M", 27);
        application.add_vehicle("Shipra", "Polo", "KA-05-41491");
        application.add_vehicle("Shipra", "Activa", "KA-12-12332");

        application.add_user("Gaurav", "M", 29);

        application.add_user("Rahul", "M", 35);
        application.add_vehicle("Rahul", "XUV", "KA-05-1234");

        application.offer_ride("Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");



        Ride ride1=application.select_ride("Nandini", "Bangalore", "Mysore", 1, SelectionStrategyType.MOST_VACANT, "None");
        Ride ride2=application.select_ride("Gaurav", "Bangalore", "Mysore", 1, SelectionStrategyType.PREFFERED, "Activa");
        Ride ride3=application.select_ride("Rohan", "Mumbai", "Bangalore", 1, SelectionStrategyType.PREFFERED, "Baleno");
        Ride ride4=application.select_ride("Rohan", "Hyderabad", "Bangalore", 1, SelectionStrategyType.PREFFERED, "Baleno");
        Ride ride5=application.select_ride("Shashank", "Hyderabad", "Bangalore", 1, SelectionStrategyType.PREFFERED, "Polo");
    }
}
