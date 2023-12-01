package menu.exception;

public enum ErrorMessage {

    INPUT_FORMAT_NOT_ALLOWED("유효하지 않은 입력 형식입니다."),
    COACH_NAME_LENGTH_NOT_ALLOWED("코치 이름은 최소 2글자, 최대 4글자까지 가능합니다."),
    COACH_SIZE_NOT_ALLOWED("코치는 최소 2명에서 최대 5명까지 입력 가능합니다."),
    RESTRICTED_MENU_COUNT_NOT_ALLOWED("못 먹는 음식의 개수는 2개 이하가 되어야합니다."),
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
