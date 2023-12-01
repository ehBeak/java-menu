package menu.factroy;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.Menu;

public class CoachFactory {

    public Coach createCoach(String coachName, List<String> menuNames) {
        List<Menu> restrictedMenus = mapToMenus(menuNames);
        return new Coach(coachName, restrictedMenus);
    }

    private List<Menu> mapToMenus(List<String> menuNames) {
        return menuNames.stream()
                .map(Menu::findMenu)
                .collect(Collectors.toList());
    }
}
