package model.exception_app;

public class MyClassNotFoundException extends ThisAppException{

    public MyClassNotFoundException(String message, String stack_trace) {
        super("Файл не найден:" + message + "\n" + stack_trace);

    }
}
