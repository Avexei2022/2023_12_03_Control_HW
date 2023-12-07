package model.exception_app;

public class MyGeneralException extends ThisAppException{

    public MyGeneralException(String stack_trace) {
        super("Что-то пошло не так:\n" + stack_trace);
    }

}
