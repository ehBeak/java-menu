package menu.exception;

public enum ErrorMessage {

    INPUT_FORMAT_NOT_ALLOWED("유효하지 않은 입력 형식입니다."),
    ERROR_MESSAGE("[ERROR]");

    ErrorMessage(String message) {
        this.message = message;
    }

    private final String message;

    @Override
    public String toString() {
        return String.join(" ", ERROR_MESSAGE.message, message);
    }
}
