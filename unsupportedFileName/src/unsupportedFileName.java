public class unsupportedFileName extends Exception{
    public unsupportedFileName() {
    }

    public unsupportedFileName(String message) {
        super(message);
    }

    public unsupportedFileName(String message, Throwable cause) {
        super(message, cause);
    }

    public unsupportedFileName(Throwable cause) {
        super(cause);
    }

    public unsupportedFileName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
