package menu.dto;

import java.util.List;

public class ResultDto {

    private final String coachName;
    private final List<String> menus;

    public ResultDto(String coachName, List<String> menus) {
        this.coachName = coachName;
        this.menus = menus;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenus() {
        return menus;
    }
}
