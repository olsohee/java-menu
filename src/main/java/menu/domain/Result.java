package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
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

        // log
        System.out.println(coach.getName());
        for (Day day1 : recommendedMenu.keySet()) {
            System.out.println(day1 + recommendedMenu.get(day1));
        }
        System.out.println();
    }

    private void validateDuplicated(Day day, Category category, String menu) {
        boolean isDuplicated = recommendedMenu.keySet().stream()
                .anyMatch(dayOfWeek -> recommendedMenu.get(dayOfWeek).equals(menu));
        if (isDuplicated) {
            System.out.println("중복! 다시 셔플");
            recommend(day, category);
        }
    }
}
