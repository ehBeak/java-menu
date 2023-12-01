package menu;

import menu.controller.MenuRecommendationController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuRecommendationController menuRecommendationController
                = new MenuRecommendationController(new InputView(), new OutputView());
        menuRecommendationController.RecommendMenu();
    }
}
