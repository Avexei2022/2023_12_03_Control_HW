package model.exception_app;

public class MyFileNotFoundException extends ThisAppException{

    public MyFileNotFoundException(String message, String stack_trace) {
        super("Файл не найден:" + message + "\n" + stack_trace);

    }
}
