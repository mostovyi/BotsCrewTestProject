package exceptions;

public class EmptyCommandLineException extends RuntimeException{

    public EmptyCommandLineException(String error) {
        super(error);
    }
}
