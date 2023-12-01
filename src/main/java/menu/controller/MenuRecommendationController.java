package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendationController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void RecommendMenu() {
        outputView.startRecommendMenu();
        List<String> coachNames = inputView.inputCoachName();
        Coaches coaches = getCoaches(coachNames);

        outputView.printResultMessage();
        outputView.printDayOfMonth();
        outputView.printCategoriesContent(coaches.getCategoriesContent());
        outputView.printRecommendContent(coaches.recommendMenusToCoaches());
        outputView.printCompleteRecommendMessage();
    }

    private Coaches getCoaches(List<String> coachNames) {
        List<Coach> coaches =
                coachNames.stream().map(inputView::inputCoachRestrictedMenu).collect(Collectors.toList());
        return new Coaches(coaches);
    }
}
