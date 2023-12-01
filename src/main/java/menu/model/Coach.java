package menu.model;

import static menu.exception.ErrorMessage.COACH_NAME_LENGTH_NOT_ALLOWED;

import menu.exception.ExceptionWithMessage;

public class Coach {

    private static final int NAME_MAX_LENGTH = 2;
    private static final int NAME_MIN_LENGTH = 4;

    private String name;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < NAME_MAX_LENGTH || name.length() > NAME_MIN_LENGTH) {
            throw new ExceptionWithMessage(COACH_NAME_LENGTH_NOT_ALLOWED.toString());
        }
    }
}
