package menu.domain;

import menu.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coachs {

    private List<Coach> coaches = new ArrayList<>();

    public Coachs(List<String> names) {
        validate(names);
        coaches = names.stream()
                .map(name -> new Coach(name))
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        validateDuplicated(names);
        validateCount(names);
    }

    private void validateDuplicated(List<String> names) {
        int nonDuplicatedCount = (int) names.stream()
                .distinct()
                .count();
        if (nonDuplicatedCount != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_COACH_NAME.getErrorMessage());
        }
    }

    private void validateCount(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_COUNT.getErrorMessage());
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void createExcludedMenu(String coachName, List<String> excludedMenus) {
        Coach findCoach = coaches.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .findAny().get();
        findCoach.createExcludedMenu(excludedMenus);
    }
}
