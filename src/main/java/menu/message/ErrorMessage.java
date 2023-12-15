package menu.message;

public enum ErrorMessage {

    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_COACH_NAME_LENGTH("이름은 최소 2글자에서 최대 4글자여야 합니다."),
    DUPLICATED_COACH_NAME("이름은 중복될 수 없습니다."),
    INVALID_COACH_COUNT("코치는 최소 2명에서 최대 5명이어야 합니다.")
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
