package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private final List<Category> categories = new ArrayList<>();

    public void addCategory(Category category) {
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }
}
