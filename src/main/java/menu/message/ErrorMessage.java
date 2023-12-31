package menu.message;

public enum ErrorMessage {

    INVALID_COACH_NAME_LENGTH("이름은 최소 2글자에서 최대 4글자여야 합니다."),
    DUPLICATED_COACH_NAME("이름은 중복될 수 없습니다."),
    INVALID_COACH_COUNT("코치는 최소 2명에서 최대 5명이어야 합니다."),
    INVALID_EXCLUDED_MENU_COUNT("못 먹는 메뉴는 최대 2개까지 가능합니다."),
    NOT_FOUND_MENU("존재하지 않는 메뉴입니다."),
    DUPLICATED_CATEGORY("한 주에 카테고리는 2번까지만 중복 가능합니다."),
    EXCLUDED_MENU_CANNOT_RECOMMENDED("못 먹는 메뉴는 추천할 수 없습니다."),
    DUPLICATED_RECOMMENDED_MENU("한 코치에게 중복된 메뉴를 추천할 수 없습니다.")
    ;

    private static final String ERROR_HEADER = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return String.format("%s %s", ERROR_HEADER, errorMessage);
    }
}
