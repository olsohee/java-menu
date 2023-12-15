package menu.view;

import menu.dto.CategoryNamesDto;
import menu.dto.DayNamesDto;
import menu.dto.RecommendedMenusDto;
import menu.message.OutputMessage;

import java.util.List;

public class OutputView {

    private static OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printStartMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
        System.out.println();
    }

    public void printResultStartMessage() {
        System.out.println();
        System.out.println(OutputMessage.RESULT_START_MESSAGE.getMessage());
    }

    public void printResult(DayNamesDto dayDtos, CategoryNamesDto categoryNamesDto, List<RecommendedMenusDto> recommendedMenusDtos) {
        printDays(dayDtos);
        printCategories(categoryNamesDto);
        printRecommendedMenus(recommendedMenusDtos);
    }

    private void printDays(DayNamesDto dayDtos) {
        dayDtos.getDayNames().add(0, OutputMessage.DIVISION.getMessage());
        System.out.println(String.format(OutputMessage.RESULT_FORM.getMessage(),
                String.join(OutputMessage.DELIMITER.getMessage(), dayDtos.getDayNames())));
    }

    private void printCategories(CategoryNamesDto categoryNamesDto) {
        categoryNamesDto.getCategoryNames().add(0, OutputMessage.CATEGORY.getMessage());
        System.out.println(String.format(OutputMessage.RESULT_FORM.getMessage(),
                String.join(OutputMessage.DELIMITER.getMessage(), categoryNamesDto.getCategoryNames())));
    }

    private void printRecommendedMenus(List<RecommendedMenusDto> recommendedMenusDtos) {
        recommendedMenusDtos.stream()
                .forEach(dto -> {
                    dto.getRecommendedMenus().add(0, dto.getCoachName());
                    System.out.println(String.format(OutputMessage.RESULT_FORM.getMessage(),
                            String.join(OutputMessage.DELIMITER.getMessage(), dto.getRecommendedMenus())));
                });
    }

    public void printEndMessage() {
        System.out.println();
        System.out.println(OutputMessage.END_MESSAGE.getMessage());
    }
}
