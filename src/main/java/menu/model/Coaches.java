package menu.model;

import static menu.exception.ErrorMessage.COACH_SIZE_NOT_ALLOWED;

import java.util.List;
import java.util.stream.Collectors;
import menu.exception.ExceptionWithMessage;

public class Coaches {

    private static final int COACHES_MIN_SIZE = 2;
    private static final int COACHES_MAX_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCoach(coaches);
        this.coaches = coaches;
    }

    private void validateCoach(List<Coach> coaches) {
        if (coaches.size() < COACHES_MIN_SIZE || coaches.size() > COACHES_MAX_SIZE) {
            throw new ExceptionWithMessage(COACH_SIZE_NOT_ALLOWED.toString());
        }
    }

    public List<String> recommendMenusToCoaches() {
        return coaches.stream().map(Coach::getRecommendMenusOfCoach).collect(Collectors.toList());
    }
}
