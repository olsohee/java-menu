package menu.dto;

import java.util.List;

public class RecommendedMenusDto {

    private final String coachName;
    private final List<String> recommendedMenus;

    public RecommendedMenusDto(String coachName, List<String> recommendedMenus) {
        this.coachName = coachName;
        this.recommendedMenus = recommendedMenus;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }
}
