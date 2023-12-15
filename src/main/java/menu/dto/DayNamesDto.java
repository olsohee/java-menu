package menu.dto;

import java.util.List;

public class DayNamesDto {

    private final List<String> dayNames;

    public DayNamesDto(List<String> dayNames) {
        this.dayNames = dayNames;
    }

    public List<String> getDayNames() {
        return dayNames;
    }
}
