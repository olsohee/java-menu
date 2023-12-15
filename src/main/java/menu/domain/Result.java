package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private Coach coach;
    private Map<Day, String> recommendedMenu = new HashMap<>();

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
        validateDuplicated(day, category, menu);
        recommendedMenu.put(day, menu);
    }

    private void validateDuplicated(Day day, Category category, String menu) {
        boolean isDuplicated = recommendedMenu.keySet().stream()
                .anyMatch(dayOfWeek -> recommendedMenu.get(dayOfWeek).equals(menu));
        if (isDuplicated) {
            recommend(day, category);
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
