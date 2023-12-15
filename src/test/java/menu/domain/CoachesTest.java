package menu.domain;

import menu.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoachesTest {

    @DisplayName("코치 이름이 중복되거나 2명 미만 또는 5명 초과이면 예외 발생")
    @Test
    void createCoaches_fail() {
        // given
        List<String> duplicatedNames = List.of("제임스", "제임스");
        List<String> nameOne = List.of("제임스");
        List<String> namesSix = List.of("제임스1", "제임스2", "제임스3", "제임스4", "제임스5", "제임스6");

        // then
        assertThatThrownBy(() -> new Coaches(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_COACH_NAME.getErrorMessage());

        assertThatThrownBy(() -> new Coaches(nameOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_COACH_COUNT.getErrorMessage());

        assertThatThrownBy(() -> new Coaches(namesSix))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_COACH_COUNT.getErrorMessage());
    }
}
