package springmvcauth.exceptions;


public class EmailExistsException extends Throwable {
    public EmailExistsException(String message) {
        super(message);
    }
}
