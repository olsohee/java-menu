package menu.controller;

import menu.service.Service;
import menu.utils.InputConvertor;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController {

    private final InputView inputView = InputView.getInstance();
    private final InputConvertor inputConvertor = InputConvertor.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final Service service = Service.getInstance();

    public void run() {
        outputView.printStartMessage();
        createCoach();
    }

    private void createCoach() {
        try {
            List<String> names = inputConvertor.convertStringToList(inputView.readCoach());
            service.createCoach(names);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            createCoach();
        }

    }
}
