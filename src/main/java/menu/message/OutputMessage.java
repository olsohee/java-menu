package menu.message;

public enum OutputMessage {

    START_MESSAGE("점심 메뉴 추천을 시작합니다."),
    RESULT_START_MESSAGE("메뉴 추천 결과입니다."),
    DELIMITER(" | "),
    RESULT_FORM("[ %s ]"),
    DIVISION("구분"),
    CATEGORY("카테고리"),
    END_MESSAGE("추천을 완료했습니다."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
