package menu.utils;

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

    public List<String> convertStringToList(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(input -> input.trim())
                .collect(Collectors.toList());
    }
}
