package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Result {

    private Coach coach;
    private Map<Day, String> recommendedMenu = new LinkedHashMap<>();

    public Result(Coach coach) {
        initDay();
        this.coach = coach;
    }

    private void initDay() {
        for (Day day :  Day.values()) {
            recommendedMenu.put(day, "");
        }
    }

    public void recommend(Day day, Category category) {
        String menu = Randoms.shuffle(category.getMenus()).get(0);
        try {
            validateExcludedMenu(menu);
            validateDuplicated(day, category, menu);
        } catch (IllegalArgumentException e) {
            recommend(day, category);
            return;
        }
        recommendedMenu.put(day, menu);
    }

    private void validateExcludedMenu(String menu) {
        if (coach.isExcludedMenu(menu)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(Day day, Category category, String menu) {
        boolean isDuplicated = recommendedMenu.keySet().stream()
                .anyMatch(dayOfWeek -> recommendedMenu.get(dayOfWeek).equals(menu));
        if (isDuplicated) {
            throw new IllegalArgumentException();
        }
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getRecommendedMenus() {
        List<String> menus = new ArrayList<>();
        for (Day day : recommendedMenu.keySet()) {
            menus.add(recommendedMenu.get(day));
        }
        return menus;
    }
}
