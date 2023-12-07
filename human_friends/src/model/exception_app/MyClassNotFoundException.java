package model.exception_app;

public class MyClassNotFoundException extends ThisAppException{

    public MyClassNotFoundException(String message, String stack_trace) {
        super("Файл " + message + " не содержит нужного объекта\n" + stack_trace);

    }
}
