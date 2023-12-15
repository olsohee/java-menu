package menu.domain;

import menu.message.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CategoriesTest {

    @Test
    @DisplayName("중복되는 카테고리가 2개 이하이면 성공")
    void addCategory_success() {
        // given
        Categories categories = new Categories();

        // when
        categories.addCategory(Day.MON, Category.KOREAN);
        categories.addCategory(Day.THU, Category.WESTERN);

        // then
        categories.addCategory(Day.WEN, Category.KOREAN);
        assertThat(categories.getCategories().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("중복되는 카테고리가 2개 초과이면 예외 발생")
    void addCategory_fail() {
        // given
        Categories categories = new Categories();

        // when
        categories.addCategory(Day.MON, Category.KOREAN);
        categories.addCategory(Day.THU, Category.KOREAN);

        // then
        assertThatThrownBy(() -> categories.addCategory(Day.WEN, Category.KOREAN))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_CATEGORY.getErrorMessage());
    }
}
