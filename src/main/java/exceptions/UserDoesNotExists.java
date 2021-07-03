package exceptions;

public class UserDoesNotExists extends RuntimeException {

    public UserDoesNotExists() {
        super("specified user Doesnot exists");
    }
}
