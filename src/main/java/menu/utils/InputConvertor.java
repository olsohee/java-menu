package menu.utils;

import menu.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConvertor {

    private static InputConvertor inputConvertor = new InputConvertor();

    private InputConvertor() {
    }

    public static InputConvertor getInstance() {
        return inputConvertor;
    }

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    public List<String> convertStringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(name -> name.trim())
                .collect(Collectors.toList());
    }
}
