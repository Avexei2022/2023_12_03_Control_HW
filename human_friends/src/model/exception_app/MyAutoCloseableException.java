package model.exception_app;

public class MyAutoCloseableException extends ThisAppException{
    public MyAutoCloseableException(String message, String stack_trace) {
        super(message + ":\n" + stack_trace);

    }
}
