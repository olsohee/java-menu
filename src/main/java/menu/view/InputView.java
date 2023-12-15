package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView inputView = new InputView();
    private static final String READ_COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String readCoach() {
        System.out.println(READ_COACH);
        return Console.readLine();
    }
}
