package menu.message;

public enum OutputMessage {

    START_MESSAGE("점심 메뉴 추천을 시작합니다."),
    DELIMITER(" | "),
    RESULT_FORM("[ %s ]"),
    DAY_OF_WEEK("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    RESULT_START_MESSAGE("메뉴 추천 결과입니다."),
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
