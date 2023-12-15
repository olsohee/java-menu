package menu.service;

import menu.domain.Coachs;
import menu.dto.CoachNameDto;

import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private static Service service = new Service();
    private Coachs coachs;

    private Service() {
    }

    public static Service getInstance() {
        return service;
    }

    public void createCoach(List<String> names) {
        coachs = new Coachs(names);
    }

    public List<CoachNameDto> getCoachNameDtos() {
        return coachs.getCoaches().stream()
                .map(coach -> new CoachNameDto(coach.getName()))
                .collect(Collectors.toList());
    }

    public void createExcludedMenu(String coachName, List<String> excludedMenus) {
        coachs.createExcludedMenu(coachName, excludedMenus);
    }
}
