package exceptionPackage;

public class ThreadException extends Exception {
    @Override
    public String getMessage() {
        return ("Le thread a rencontré un probléme");
    }
}
