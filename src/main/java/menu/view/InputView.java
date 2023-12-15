package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.CoachNameDto;

public class InputView {

    private static InputView inputView = new InputView();
    private static final String READ_COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_EXCLUDED_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String readCoach() {
        System.out.println(READ_COACH);
        return Console.readLine();
    }

    public String readExcludedMenu(CoachNameDto dto) {
        System.out.println(String.format(READ_EXCLUDED_MENU, dto.getName()));
        return Console.readLine();
    }
}
