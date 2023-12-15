package menu.message;

public enum OutputMessage {

    START_MESSAGE("점심 메뉴 추천을 시작합니다.")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
