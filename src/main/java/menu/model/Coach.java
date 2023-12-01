package menu.model;

import static menu.exception.ErrorMessage.COACH_NAME_LENGTH_NOT_ALLOWED;
import static menu.exception.ErrorMessage.RESTRICTED_MENU_COUNT_NOT_ALLOWED;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.ExceptionWithMessage;

public class Coach {

    private static final int NAME_MAX_LENGTH = 2;
    private static final int NAME_MIN_LENGTH = 4;

    private final String name;
    private final List<Menu> restrictedMenus;

    public Coach(String name, List<Menu> restrictedMenus) {
        validateName(name);
        validateRestrictedMenusSize(restrictedMenus);
        this.name = name;
        this.restrictedMenus = restrictedMenus;
    }

    private void validateName(String name) {
        if (name.length() < NAME_MAX_LENGTH || name.length() > NAME_MIN_LENGTH) {
            throw new ExceptionWithMessage(COACH_NAME_LENGTH_NOT_ALLOWED.toString());
        }
    }

    private void validateRestrictedMenusSize(List<Menu> menus) {
        if (menus.size() > 2) {
            throw new ExceptionWithMessage(RESTRICTED_MENU_COUNT_NOT_ALLOWED.toString());
        }
    }

    public List<Menu> recommendMenus() {
        List<Menu> recommendMenus = new ArrayList<>();
        while (recommendMenus.size() <= 5) {
            Menu recommendMenu = recommendMenu();
            if (isValidRecommendMenu(recommendMenus, recommendMenu)) {
                recommendMenus.add(recommendMenu);
            }
        }
        return recommendMenus;
    }

    private Menu recommendMenu() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return MenuCategory.getRandomMenuInCategory(randomNumber);
    }

    private Boolean isValidRecommendMenu(List<Menu> menus, Menu menu) {
        return notRestrictedMenu(menu)
                && notDuplicatedMenu(menus, menu)
                && notExceedsCategoryDuplicates(menus, menu);
    }

    private Boolean notRestrictedMenu(Menu menu) {
        return !restrictedMenus.contains(menu);
    }

    private Boolean notExceedsCategoryDuplicates(List<Menu> menus, Menu recommendMenu) {
        MenuCategory menuCategory = MenuCategory.findMenuCategory(recommendMenu);
        long categoryCount = getDuplicatedCategoryCount(menus, menuCategory);
        return categoryCount <= 2;
    }

    private long getDuplicatedCategoryCount(List<Menu> menus, MenuCategory menuCategory) {
        return menus.stream()
                .filter(menu -> MenuCategory.findMenuCategory(menu).equals(menuCategory))
                .count();
    }

    private Boolean notDuplicatedMenu(List<Menu> menus, Menu recommendMenu) {
        return !menus.contains(recommendMenu);
    }

    public String getRecommendMenusOfCoach() {
        List<String> recommendMenuFormat =
                recommendMenus().stream().map(Menu::getName).collect(Collectors.toList());
        recommendMenuFormat.add(0, name);
        return String.join(" | ", recommendMenuFormat);
    }
}
