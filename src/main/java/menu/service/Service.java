package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.dto.CategoryNamesDto;
import menu.dto.CoachNameDto;
import menu.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private static Service service = new Service();
    private Coachs coachs;
    private Results results;
    private Categories categories = new Categories();

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
            selectCategory(day);
        }
    }

    private void selectCategory(Day day) {
        Category category = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
        try {
            categories.addCategory(category);
            results.recommend(day, category);
        } catch (IllegalArgumentException e) {
            selectCategory(day);
        }
    }

    public CategoryNamesDto getCategoryNamesDto() {
        List<String> categoryNames = categories.getCategories().stream()
                .map(category -> category.getCategory())
                .collect(Collectors.toList());
        return new CategoryNamesDto(categoryNames);
    }

    public List<ResultDto> getResultDtos() {
        return results.getResults().stream()
                .map(result -> new ResultDto(result.getCoach().getName(), result.getRecommendedMenus()))
                .collect(Collectors.toList());
    }
}
