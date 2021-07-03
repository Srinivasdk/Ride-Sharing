package exceptions;

public class NoRideFound extends RuntimeException {
    public NoRideFound() {
        super("No ride found");
    }
}
