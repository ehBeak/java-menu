package menu.model;

import static menu.exception.ErrorMessage.COACH_SIZE_NOT_ALLOWED;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.ExceptionWithMessage;

public class Coaches {

    private static final int COACHES_MIN_SIZE = 2;
    private static final int COACHES_MAX_SIZE = 5;

    private final List<Coach> coaches;
    private final List<MenuCategory> categories;

    public Coaches(List<Coach> coaches) {
        validateCoach(coaches);
        this.coaches = coaches;
        this.categories = createMenuCategories();
    }

    private void validateCoach(List<Coach> coaches) {
        if (coaches.size() < COACHES_MIN_SIZE || coaches.size() > COACHES_MAX_SIZE) {
            throw new ExceptionWithMessage(COACH_SIZE_NOT_ALLOWED.toString());
        }
    }

    public List<String> recommendMenusToCoaches() {
        return coaches.stream()
                .map(coach -> coach.getRecommendMenus(categories))
                .collect(Collectors.toList());
    }

    private List<MenuCategory> createMenuCategories() {
        List<MenuCategory> menuCategories = new ArrayList<>();
        while (menuCategories.size() < 5) {
            MenuCategory menuCategory = randomCategory();
            if (isValidMenuCategory(menuCategories, menuCategory)) {
                menuCategories.add(menuCategory);
            }
        }
        return menuCategories;
    }

    private MenuCategory randomCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return MenuCategory.findMenuCategory(randomNumber);
    }

    private Boolean isValidMenuCategory(List<MenuCategory> categories, MenuCategory recommendCategory) {
        long count = categories.stream()
                .filter(category -> category.equals(recommendCategory))
                .count();
        return count <= 2;
    }

    public String getCategoriesContent() {
        List<String> categoriesFormat =
                categories.stream().map(MenuCategory::getName).collect(Collectors.toList());
        return String.join(" | ", categoriesFormat);
    }
}
