package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.dto.CoachNameDto;
import menu.repository.CategoryRepository;
import menu.repository.CoachRepository;

import java.util.Arrays;
import java.util.List;

public class RecommendService {

    private static RecommendService recommendService = new RecommendService();
    private static CoachRepository coachRepository = CoachRepository.getInstance();
    private static CategoryRepository categoryRepository = CategoryRepository.getInstance();

    private RecommendService() {
    }

    public static RecommendService getInstance() {
        return recommendService;
    }

    public void createCoach(List<String> names) {
        coachRepository.save(new Coaches(names));
    }

    public void createExcludedMenus(CoachNameDto coachNameDto, List<String> excludedMenus) {
        Coaches coaches = coachRepository.findCoaches();
        coaches.createExcludedMenus(coachNameDto.getName(), excludedMenus);
    }

    public void recommend() {
        Arrays.stream(Day.values())
                .forEach(day -> selectCategory(day));
    }

    private void selectCategory(Day day) {
        Category category = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
        try {
            Categories categories = categoryRepository.find();
            categories.addCategory(day, category);
        } catch (IllegalArgumentException e) {
            selectCategory(day);
        }
        Coaches coaches = coachRepository.findCoaches();
        coaches.recommend(day, category);
    }
}
