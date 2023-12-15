package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.dto.CategoryNamesDto;
import menu.dto.CoachNameDto;
import menu.dto.DayNamesDto;
import menu.dto.RecommendedMenusDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendService {

    private static RecommendService recommendService = new RecommendService();
    private Coaches coaches;
    private Categories categories = new Categories();

    private RecommendService() {
    }

    public static RecommendService getInstance() {
        return recommendService;
    }

    public void createCoach(List<String> names) {
        coaches = new Coaches(names);
    }

    public void createExcludedMenus(CoachNameDto coachNameDto, List<String> excludedMenus) {
        coaches.createExcludedMenus(coachNameDto.getName(), excludedMenus);
    }

    public void recommend() {
        Arrays.stream(Day.values())
                .forEach(day -> selectCategory(day));
    }

    private void selectCategory(Day day) {
        Category category = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
        try {
            categories.addCategory(day, category);
        } catch (IllegalArgumentException e) {
            selectCategory(day);
        }
        coaches.recommend(day, category);
    }

    public List<CoachNameDto> getCoachNameDtos() {
        return coaches.getCoaches().stream()
                .map(coach -> new CoachNameDto(coach.getName()))
                .collect(Collectors.toList());
    }

    public DayNamesDto getDayDtos() {
        List<String> dayNames = categories.getCategories().keySet().stream()
                .map(day -> day.getName())
                .collect(Collectors.toList());
        return new DayNamesDto(dayNames);
    }

    public CategoryNamesDto getCategoryNamesDto() {
        List<String> categoryNames = categories.getCategories().keySet().stream()
                .map(category -> categories.getCategories().get(category).getName())
                .collect(Collectors.toList());
        return new CategoryNamesDto(categoryNames);
    }

    public List<RecommendedMenusDto> getResultDtos() {
        List<RecommendedMenusDto> recommendedMenusDtos = new ArrayList<>();
        for (Coach coach : coaches.getCoaches()) {
            List<String> recommendedMenuNames = coach.getRecommendedMenus().keySet().stream()
                    .map(day -> coach.getRecommendedMenus().get(day))
                    .collect(Collectors.toList());
            recommendedMenusDtos.add(new RecommendedMenusDto(coach.getName(), recommendedMenuNames));
        }
        return recommendedMenusDtos;
    }
}
