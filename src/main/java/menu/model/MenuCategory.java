package menu.model;

import static menu.model.Menu.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum MenuCategory {

    JAPANESE(1,
            List.of(GYUDON, UDON, MISOSHIRU,
                    SUSHI, KATSUDON, ONIGIRI,
                    HAYARICE, RAMEN, OKONOMIYAKI)),
    KOREAN(2,
            List.of(GIMBAP, KIMCHIJJIGAE, SSAMBAB,
                    DOJANGJJIGAE, BIBIMBAP, KALGUKSU,
                    BULGOGI, TTEOKBOKKI, JAEYUKBOKKEUM)),
    CHINESE(3,
            List.of(KANPOONGGI, BOKKEUMMYEON, DONGPAYUK,
                    JAJANGMYEON, JJAMPPONG, MAPADUBU, TANGSUYUK,
                    TOMATO_EGG_STIR_FRY, GOCHUJAPCHAE)),
    ASIAN(4,
            List.of(PADTHAI, KHAOPAT, NASIGORENG,
                    PINEAPPLE_FRIED_RICE, SPRINGROLL, TOMYUMKOONG,
                    BANHMI, GOICUON, BUNCHA)),
    WESTERN(5,
            List.of(LASAGNA, GRATIN, NYOKKI,
                    QUICHE, FRENCH_TOAST, BAGUETTE,
                    SPAGHETTI, PIZZA, PANINI)),
    NONE(0,
            List.of());

    MenuCategory(int categoryNumber, List<Menu> menus) {
        this.categoryNumber = categoryNumber;
        this.menus = menus;
    }

    private final int categoryNumber;
    private final List<Menu> menus;

    public static Menu getRandomMenuInCategory(int number) {
        MenuCategory menuCategory = Arrays.stream(MenuCategory.values())
                .filter(category -> category.categoryNumber == number)
                .findAny()
                .orElse(NONE);
        return menuCategory.menus.get(Randoms.pickNumberInRange(0, 8));
    }

    public static MenuCategory findMenuCategory(Menu menu) {
        return Arrays.stream(MenuCategory.values())
                .filter(menus -> menus.hasMenuCategory(menu))
                .findAny()
                .orElse(NONE);
    }

    public boolean hasMenuCategory(Menu menuType) {
        return menus.stream()
                .anyMatch(menu -> menu == menuType);
    }

}
