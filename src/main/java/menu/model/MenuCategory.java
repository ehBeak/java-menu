package menu.model;

import static menu.model.Menu.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum MenuCategory {

    JAPANESE("일식", 1,
            List.of(GYUDON, UDON, MISOSHIRU,
                    SUSHI, KATSUDON, ONIGIRI,
                    HAYARICE, RAMEN, OKONOMIYAKI)),
    KOREAN("한식", 2,
            List.of(GIMBAP, KIMCHIJJIGAE, SSAMBAB,
                    DOJANGJJIGAE, BIBIMBAP, KALGUKSU,
                    BULGOGI, TTEOKBOKKI, JAEYUKBOKKEUM)),
    CHINESE("중식", 3,
            List.of(KANPOONGGI, BOKKEUMMYEON, DONGPAYUK,
                    JAJANGMYEON, JJAMPPONG, MAPADUBU, TANGSUYUK,
                    TOMATO_EGG_STIR_FRY, GOCHUJAPCHAE)),
    ASIAN("아시안", 4,
            List.of(PADTHAI, KHAOPAT, NASIGORENG,
                    PINEAPPLE_FRIED_RICE, SPRINGROLL, TOMYUMKOONG,
                    BANHMI, GOICUON, BUNCHA)),
    WESTERN("양식", 5,
            List.of(LASAGNA, GRATIN, NYOKKI,
                    QUICHE, FRENCH_TOAST, BAGUETTE,
                    SPAGHETTI, PIZZA, PANINI)),
    NONE("없음", 0,
            List.of());

    MenuCategory(String name, int categoryNumber, List<Menu> menus) {
        this.categoryNumber = categoryNumber;
        this.menus = menus;
        this.name = name;
    }

    private final int categoryNumber;
    private final List<Menu> menus;
    private final String name;

    public static Menu getRandomMenuInCategory(MenuCategory menuCategory) {
        return menuCategory.menus.get(Randoms.pickNumberInRange(0, 8));
    }


    public static MenuCategory findMenuCategory(int randomNumber) {
        return Arrays.stream(MenuCategory.values())
                .filter(menus -> menus.categoryNumber == randomNumber)
                .findAny()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
