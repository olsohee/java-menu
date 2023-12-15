package menu.controller;

import menu.dto.CategoryNamesDto;
import menu.dto.CoachNameDto;
import menu.dto.DayNamesDto;
import menu.dto.RecommendedMenusDto;
import menu.service.ReadService;
import menu.service.RecommendService;
import menu.utils.InputConvertor;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController {

    private final InputView inputView = InputView.getInstance();
    private final InputConvertor inputConvertor = InputConvertor.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final RecommendService recommendService = RecommendService.getInstance();
    private final ReadService readService = ReadService.getInstance();

    public void run() {
        outputView.printStartMessage();
        createCoach();
        createExcludedMenu();
        recommend();
        printResult();
    }

    private void createCoach() {
        try {
            List<String> names = inputConvertor.convertStringToList(inputView.readCoach());
            recommendService.createCoach(names);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            createCoach();
        }
    }

    private void createExcludedMenu() {
        readService.getCoachNameDtos().stream()
                .forEach(coachNameDto ->  readExcludedMenu(coachNameDto));
    }

    private void readExcludedMenu(CoachNameDto coachNameDto) {
        try {
            List<String> excludedMenus = inputConvertor.convertStringToList(inputView.readExcludedMenu(coachNameDto));
            recommendService.createExcludedMenus(coachNameDto, excludedMenus);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            readExcludedMenu(coachNameDto);
        }
    }

    private void recommend() {
        recommendService.recommend();
    }

    private void printResult() {
        outputView.printResultStartMessage();

        DayNamesDto dayDtos = readService.getDayDtos();
        CategoryNamesDto categoryNamesDto = readService.getCategoryNamesDto();
        List<RecommendedMenusDto> recommendedMenusDtos = readService.getResultDtos();
        outputView.printResult(dayDtos, categoryNamesDto, recommendedMenusDtos);

        outputView.printEndMessage();
    }
}
