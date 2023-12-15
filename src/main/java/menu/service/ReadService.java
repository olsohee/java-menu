package menu.service;

import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.dto.CategoryNamesDto;
import menu.dto.CoachNameDto;
import menu.dto.DayNamesDto;
import menu.dto.RecommendedMenusDto;
import menu.repository.CategoryRepository;
import menu.repository.CoachRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadService {

    private static ReadService readService = new ReadService();
    private static CoachRepository coachRepository = CoachRepository.getInstance();
    private static CategoryRepository categoryRepository = CategoryRepository.getInstance();

    private ReadService() {
    }

    public static ReadService getInstance() {
        return readService;
    }

    public List<CoachNameDto> getCoachNameDtos() {
        Coaches coaches = coachRepository.findCoaches();
        return coaches.getCoaches().stream()
                .map(coach -> new CoachNameDto(coach.getName()))
                .collect(Collectors.toList());
    }

    public DayNamesDto getDayNamesDto() {
        Categories categories = categoryRepository.find();
        List<String> dayNames = categories.getCategories().keySet().stream()
                .map(day -> day.getName())
                .collect(Collectors.toList());
        return new DayNamesDto(dayNames);
    }

    public CategoryNamesDto getCategoryNamesDto() {
        Categories categories = categoryRepository.find();
        List<String> categoryNames = categories.getCategories().keySet().stream()
                .map(category -> categories.getCategories().get(category).getName())
                .collect(Collectors.toList());
        return new CategoryNamesDto(categoryNames);
    }

    public List<RecommendedMenusDto> getRecommendedMenusDtos() {
        Coaches coaches = coachRepository.findCoaches();
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
