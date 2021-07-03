package exceptions;

public class VehicleAlreadyExists extends RuntimeException {
    public VehicleAlreadyExists() {
        super("vehicle already exists");
    }
}
