package menu.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String COMPLETE_RECOMMEND_MESSAGE = "\n추천을 완료했습니다.";
    private static final String DAY_OF_WEEK_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_MESSAGE = "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]";
    private static final String RECOMMEND_MENU_FORMAT = "[ %s ]";

    public void startRecommendMenu() {
        System.out.println(START_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRecommendContent(List<String> menus) {
        System.out.println(DAY_OF_WEEK_MESSAGE);
        System.out.println(CATEGORY_MESSAGE);
        menus.forEach(menu -> System.out.println(String.format(RECOMMEND_MENU_FORMAT, menu)));
    }

    public void printCompleteRecommendMessage() {
        System.out.println(COMPLETE_RECOMMEND_MESSAGE);
    }

}
