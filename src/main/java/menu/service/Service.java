package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.dto.CoachNameDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private static Service service = new Service();
    private Coachs coachs;
    private Results results;

    private Service() {
    }

    public static Service getInstance() {
        return service;
    }

    public void createCoach(List<String> names) {
        coachs = new Coachs(names);
        results = new Results(coachs.getCoaches());
    }

    public List<CoachNameDto> getCoachNameDtos() {
        return coachs.getCoaches().stream()
                .map(coach -> new CoachNameDto(coach.getName()))
                .collect(Collectors.toList());
    }

    public void createExcludedMenu(String coachName, List<String> excludedMenus) {
        coachs.createExcludedMenu(coachName, excludedMenus);
    }

    public void recommend() {
        for (Day day : Day.values()) {
            Category category = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
            validate(category);

            // log
            System.out.println("category = " + category);
            results.recommend(day, category);
        }
    }

    private void validate(Category category) {
        // todo
    }
}
