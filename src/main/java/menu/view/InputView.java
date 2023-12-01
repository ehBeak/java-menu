package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.InputValidator;

public class InputView {

    private static String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";


    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public List<String> inputCoachName() {
        System.out.println(INPUT_COACH_NAME);
        String input = Console.readLine();
        inputValidator.validateCoachNamesFormat(input);
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
