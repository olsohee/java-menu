package menu.repository;

import menu.domain.Categories;

public class CategoryRepository {

    private static final CategoryRepository categoryRepository = new CategoryRepository();
    private Categories categories = new Categories();

    private CategoryRepository() {
    }

    public static CategoryRepository getInstance() {
        return categoryRepository;
    }

    public void save(Categories categories) {
        this.categories = categories;
    }

    public Categories find() {
        return categories;
    }
}
