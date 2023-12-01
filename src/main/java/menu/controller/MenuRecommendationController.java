package menu.controller;

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
    }
}
