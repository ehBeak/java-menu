package menu.util;

import static menu.exception.ErrorMessage.INPUT_FORMAT_NOT_ALLOWED;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import menu.exception.ExceptionWithMessage;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String ORDER_FORMAT = "^[가-힣,]*$";

    public void validateCoachNamesFormat(String names) {
        validateBothEndsDelimiter(names);
        validateConsecutiveDelimiter(names);
        validateOrderFormat(names);
    }

    private void validateBothEndsDelimiter(String orders) {
        if (orders.startsWith(DELIMITER) || orders.endsWith(DELIMITER)) {
            throw new ExceptionWithMessage(INPUT_FORMAT_NOT_ALLOWED.toString());
        }
    }

    private void validateConsecutiveDelimiter(String orders) {
        if (orders.contains(DELIMITER + DELIMITER)) {
            throw new ExceptionWithMessage(INPUT_FORMAT_NOT_ALLOWED.toString());
        }
    }

    private void validateOrderFormat(String order) {
        Pattern pattern = Pattern.compile(ORDER_FORMAT);
        Matcher matcher = pattern.matcher(order);
        if (!matcher.matches()) {
            throw new ExceptionWithMessage(INPUT_FORMAT_NOT_ALLOWED.toString());
        }
    }
}
