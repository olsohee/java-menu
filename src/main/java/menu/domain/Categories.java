package menu.domain;

import menu.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private final List<Category> categories = new ArrayList<>();

    public void addCategory(Category category) {
        validateDuplicated(category);
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }

    private void validateDuplicated(Category newCategory) {
        int alreadyExistCount = (int) categories.stream()
                .filter(category -> category.equals(newCategory))
                .count();
        if (alreadyExistCount == 2) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_COACH_NAME.getErrorMessage());
        }
    }
}
