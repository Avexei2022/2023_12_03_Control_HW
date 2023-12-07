package model.exception_app;

public class MyIOException extends ThisAppException{

    public MyIOException(String message, String stack_trace) {
        super("Ошибка записи в файл " + message + "\n" + stack_trace);
    }

}
