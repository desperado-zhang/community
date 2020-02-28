package life.majiang.community.exception;

public class CustomizeException extends RuntimeException {

    private String message;

    public CustomizeException(ICustomizeErrorCOde errorCOde) {
        this.message = errorCOde.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
