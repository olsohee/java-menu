package menu.view;

import menu.dto.CategoryNamesDto;
import menu.dto.ResultDto;
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

    public void printResult(CategoryNamesDto categoryNamesDto, List<ResultDto> resultDtos) {
        System.out.println(OutputMessage.DAY_OF_WEEK.getMessage());
        categoryNamesDto.getCategoryNames().add(0, "카테고리");
        System.out.println(String.format(OutputMessage.RESULT_FORM.getMessage(),
                String.join(OutputMessage.DELIMITER.getMessage(), categoryNamesDto.getCategoryNames())));
        resultDtos.stream()
                .forEach(dto -> {
                    dto.getMenus().add(0, dto.getCoachName());
                    System.out.println(String.format(OutputMessage.RESULT_FORM.getMessage(),
                            String.join(OutputMessage.DELIMITER.getMessage(), dto.getMenus())));
                });

        System.out.println();
        System.out.println(OutputMessage.END_MESSAGE.getMessage());
    }
}
