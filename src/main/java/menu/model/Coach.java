package menu.model;

import static menu.exception.ErrorMessage.COACH_NAME_LENGTH_NOT_ALLOWED;
import static menu.exception.ErrorMessage.RESTRICTED_MENU_COUNT_NOT_ALLOWED;

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

    public String getRecommendMenus(List<MenuCategory> menuCategories) {
        List<Menu> recommendMenus = new ArrayList<>();
        menuCategories.forEach(menuCategory -> addValidRecommendMenu(recommendMenus, menuCategory));
        return getRecommendMenuContents(recommendMenus);
    }

    private void addValidRecommendMenu(List<Menu> menus, MenuCategory menuCategory) {
        int orderSize = menus.size();
        while (menus.size() == orderSize) {
            Menu recommendMenu = recommendMenuInCategory(menuCategory);
            if (isValidRecommendMenu(menus, recommendMenu)) {
                menus.add(recommendMenu);
            }
        }
    }

    private Menu recommendMenuInCategory(MenuCategory menuCategory) {
        return MenuCategory.getRandomMenuInCategory(menuCategory);
    }

    private Boolean isValidRecommendMenu(List<Menu> menus, Menu menu) {
        return notRestrictedMenu(menu) && notDuplicatedMenu(menus, menu);
    }

    private Boolean notRestrictedMenu(Menu menu) {
        return !restrictedMenus.contains(menu);
    }

    private Boolean notDuplicatedMenu(List<Menu> menus, Menu recommendMenu) {
        return !menus.contains(recommendMenu);
    }

    private String getRecommendMenuContents(List<Menu> recommendMenus) {
        List<String> recommendMenuFormat =
                recommendMenus.stream().map(Menu::getName).collect(Collectors.toList());
        recommendMenuFormat.add(0, name);
        return String.join(" | ", recommendMenuFormat);
    }
}
