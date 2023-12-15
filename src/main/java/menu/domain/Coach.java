package menu.domain;

import menu.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<Menu> exceptMenus = new ArrayList<>();

    public Coach(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_LENGTH.getErrorMessage());
        }
    }
}
