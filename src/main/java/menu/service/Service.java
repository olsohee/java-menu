package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.dto.CategoryNamesDto;
import menu.dto.CoachNameDto;
import menu.dto.DayOfWeekDto;
import menu.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private static Service service = new Service();
    private Coaches coaches;
    private Categories categories = new Categories();

    private Service() {
    }

    public static Service getInstance() {
        return service;
    }

    public void createCoach(List<String> names) {
        coaches = new Coaches(names);
    }

    public void createExcludedMenu(String coachName, List<String> excludedMenus) {
        coaches.createExcludedMenu(coachName, excludedMenus);
    }

    public void recommend() {
        for (Day day : Day.values()) {
            selectCategory(day);
        }
    }

    private void selectCategory(Day day) {
        Category category = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
        try {
            categories.addCategory(day, category);
            coaches.recommend(day, category);
        } catch (IllegalArgumentException e) {
            selectCategory(day);
        }
    }

    public List<CoachNameDto> getCoachNameDtos() {
        return coaches.getCoaches().stream()
                .map(coach -> new CoachNameDto(coach.getName()))
                .collect(Collectors.toList());
    }

    public DayOfWeekDto getDayDtos() {
        List<String> dayNames = categories.getCategories().keySet().stream()
                .map(day -> day.getName())
                .collect(Collectors.toList());
        return new DayOfWeekDto(dayNames);
    }

    public CategoryNamesDto getCategoryNamesDto() {
        List<String> categoryNames = categories.getCategories().keySet().stream()
                .map(category -> categories.getCategories().get(category).getName())
                .collect(Collectors.toList());
        return new CategoryNamesDto(categoryNames);
    }

    public List<ResultDto> getResultDtos() {
        List<ResultDto> resultDtos = new ArrayList<>();
        for (Coach coach : coaches.getCoaches()) {
            List<String> recommendedMenuNames = coach.getRecommendedMenus().keySet().stream()
                    .map(day -> coach.getRecommendedMenus().get(day))
                    .collect(Collectors.toList());
            resultDtos.add(new ResultDto(coach.getName(), recommendedMenuNames));
        }
        return resultDtos;
    }
}
