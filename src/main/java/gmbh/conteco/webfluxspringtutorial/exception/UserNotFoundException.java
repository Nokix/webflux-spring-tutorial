package gmbh.conteco.webfluxspringtutorial.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super("No User found for ids: " + id);
    }
}
