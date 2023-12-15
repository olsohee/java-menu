package menu.domain;

import menu.message.ErrorMessage;

import java.util.LinkedHashMap;
import java.util.Map;

public class Categories {

    private final Map<Day, Category> categories = new LinkedHashMap<>();

    public void addCategory(Day day, Category category) {
        validateDuplicated(category);
        categories.put(day, category);
    }

    private void validateDuplicated(Category newCategory) {
        int alreadyExistCount = (int) categories.keySet().stream()
                .filter(day -> categories.get(day).equals(newCategory))
                .count();
        if (alreadyExistCount == 2) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CATEGORY.getErrorMessage());
        }
    }

    public Map<Day, Category> getCategories() {
        return categories;
    }
}
