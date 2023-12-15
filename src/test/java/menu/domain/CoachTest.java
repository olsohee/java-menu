package menu.domain;

import menu.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoachTest {

    @DisplayName("코치 이름이 두 글자 미만 또는 네 글자 초과이면 예외 발생")
    @CsvSource(value = {"가", "가나다라마"})
    @ParameterizedTest
    void createCoach_fail(String coachName) {
        assertThatThrownBy(() -> new Coach(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_COACH_NAME_LENGTH.getErrorMessage());
    }

    @DisplayName("못 먹는 메뉴가 2개 초과이거나 없는 메뉴이면 예외 발생")
    @Test
    void createExcludedMenus_fail() {
        // given
        List<String> excludedMenusThree = List.of("라자냐", "파인애플 볶음밥", "비빔밥");
        List<String> excludedMenusNotExist = List.of("없는 메뉴", "파인애플 볶음밥");
        Coach coach = new Coach("제임스");

        // then
        assertThatThrownBy(() -> coach.createExcludedMenus(excludedMenusThree))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_EXCLUDED_MENU_COUNT.getErrorMessage());

        assertThatThrownBy(() -> coach.createExcludedMenus(excludedMenusNotExist))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_FOUND_MENU.getErrorMessage());
    }

}
