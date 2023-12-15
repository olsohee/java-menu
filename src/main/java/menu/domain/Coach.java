package menu.domain;

import menu.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<String> excludedMenus = new ArrayList<>();

    public Coach(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_LENGTH.getErrorMessage());
        }
    }

    public String getName() {
        return name;
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
}
