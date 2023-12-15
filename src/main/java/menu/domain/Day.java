package menu.domain;

public enum Day {

    MON("월요일"),
    TUE("화요일"),
    WEN("수요일"),
    THU("목요일"),
    FRI("금요일")
    ;

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
