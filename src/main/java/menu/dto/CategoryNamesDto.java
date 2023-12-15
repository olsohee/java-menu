package menu.dto;

import java.util.List;

public class CategoryNamesDto {

    private final List<String> categoryNames;

    public CategoryNamesDto(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }
}
