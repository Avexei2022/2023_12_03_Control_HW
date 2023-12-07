package model.exception_app;

public class MyInvalidClassException extends ThisAppException{

    public MyInvalidClassException(String message, String stack_trace) {
        super(message + "\n" + stack_trace);

    }
}
