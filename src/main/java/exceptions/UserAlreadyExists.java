package exceptions;

public class UserAlreadyExists extends RuntimeException {

    public UserAlreadyExists() {
        super("user Already exists");
    }
}
