package model.exception_app;

public class NullValueException extends ThisAppException{
    public NullValueException(String message) {
        super(message + "\n");
    }
}
