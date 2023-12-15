package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.message.ErrorMessage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Coach {

    private String name;
    private List<String> excludedMenus = new ArrayList<>();
    private Map<Day, String> recommendedMenus = new LinkedHashMap<>();

    public Coach(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_LENGTH.getErrorMessage());
        }
    }

    public void createExcludedMenu(List<String> excludedMenus) {
        validateCount(excludedMenus);
        validateIsExistMenu(excludedMenus);
        this.excludedMenus = excludedMenus;
    }

    private void validateCount(List<String> excludedMenus) {
        if (excludedMenus.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EXCLUDED_MENU_COUNT.getErrorMessage());
        }
    }

    private void validateIsExistMenu(List<String> excludedMenus) {
        excludedMenus.stream()
                .forEach(menuName -> Category.validateIsExistMenu(menuName));
    }

    public boolean isExcludedMenu(String menu) {
        return excludedMenus.contains(menu);
    }

    public void recommend(Day day, Category category) {
        String menu = Randoms.shuffle(category.getMenus()).get(0);
        try {
            validateExcludedMenu(menu);
            validateDuplicated(menu);
        } catch (IllegalArgumentException e) {
            recommend(day, category);
            return;
        }
        recommendedMenus.put(day, menu);
    }

    private void validateExcludedMenu(String menu) {
        if (excludedMenus.contains(menu)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(String menu) {
        boolean isDuplicatedMenu = recommendedMenus.keySet().stream()
                .anyMatch(day -> recommendedMenus.get(day).equals(menu));
        if (isDuplicatedMenu) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_RECOMMENDED_MENU.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    public Map<Day, String> getRecommendedMenus() {
        return recommendedMenus;
    }
}
