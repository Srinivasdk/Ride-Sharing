package exceptions;

public class AlreadyRideExists extends RuntimeException {
    public AlreadyRideExists() {
        super("ride already exists");
    }
}
