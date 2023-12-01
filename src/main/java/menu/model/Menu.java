package menu.model;

import static menu.exception.ErrorMessage.INPUT_MENU_NOT_EXIST;

import java.util.Arrays;
import menu.exception.ExceptionWithMessage;

public enum Menu {
    // 일식
    GYUDON("규동"),
    UDON("우동"),
    MISOSHIRU("미소시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HAYARICE("하이라이스"),
    RAMEN("라면"),
    OKONOMIYAKI("오코노미야끼"),

    // 한식
    GIMBAP("김밥"),
    KIMCHIJJIGAE("김치찌개"),
    SSAMBAB("쌈밥"),
    DOJANGJJIGAE("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JAEYUKBOKKEUM("제육볶음"),

    // 중식
    KANPOONGGI("깐풍기"),
    BOKKEUMMYEON("볶음면"),
    DONGPAYUK("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPADUBU("마파두부"),
    TANGSUYUK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    GOCHUJAPCHAE("고추잡채"),

    // 아시안
    PADTHAI("팟타이"),
    KHAOPAT("카오 팟"),
    NASIGORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    SPRINGROLL("쌀국수"),
    TOMYUMKOONG("똠얌꿍"),
    BANHMI("반미"),
    GOICUON("월남쌈"),
    BUNCHA("분짜"),

    // 양식
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    NYOKKI("뇨끼"),
    QUICHE("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public static Menu findMenu(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menus -> menus.isSameName(menuName))
                .findAny()
                .orElseThrow(() -> new ExceptionWithMessage(INPUT_MENU_NOT_EXIST.toString()));
    }
}



