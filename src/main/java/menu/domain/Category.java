package menu.domain;

import menu.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public enum Category {

    JAPANESE(1,
            "일식",
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2,
            "한식",
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),

    CHINESE(3,
            "중식",
            List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),

    ASIAN(4,
            "아시안",
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),

    WESTERN(5,
            "양식",
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"))
    ;

    private final int number;
    private final String name;
    private final List<String> menus;

    Category(int number, String name, List<String> menus) {
        this.number = number;
        this.name = name;
        this.menus = menus;
    }

    public static Category getCategoryByNumber(int number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getNumber() == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static void validateIsExistMenu(String menuName) {
        boolean isExist = Arrays.stream(Category.values())
                .anyMatch(category -> category.getMenus().stream()
                        .anyMatch(menu -> menu.contains(menuName))
                );
        if (!isExist) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_MENU.getErrorMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    public List<String> getMenus() {
        return menus;
    }

    public String getName() {
        return name;
    }
}
