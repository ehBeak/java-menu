package menu.model;

import static menu.exception.ErrorMessage.COACH_NAME_LENGTH_NOT_ALLOWED;
import static menu.exception.ErrorMessage.RESTRICTED_MENU_COUNT_NOT_ALLOWED;

import java.util.List;
import menu.exception.ExceptionWithMessage;

public class Coach {

    private static final int NAME_MAX_LENGTH = 2;
    private static final int NAME_MIN_LENGTH = 4;

    private String name;
    private List<Menu> restrictedMenus;

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
}
