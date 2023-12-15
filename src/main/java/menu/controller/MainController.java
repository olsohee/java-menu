package menu.controller;

import menu.dto.CoachNameDto;
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
        createExcludedMenu();
        recommend();
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

    private void createExcludedMenu() {
        service.getCoachNameDtos().stream()
                .forEach(dto ->  readExcludedMenu(dto));
    }

    private void readExcludedMenu(CoachNameDto dto) {
        try {
            List<String> excludedMenus = inputConvertor.convertStringToList(inputView.readExcludedMenu(dto));
            service.createExcludedMenu(dto.getName(), excludedMenus);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            readExcludedMenu(dto);
        }
    }

    private void recommend() {
        service.recommend();
    }
}
