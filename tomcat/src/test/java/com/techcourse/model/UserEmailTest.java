package com.techcourse.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class UserEmailTest {

    @DisplayName("유저 이메일이 비어있으면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "      "})
    void validateUserEmail(String email) {
        //when //then
        assertThatThrownBy(() -> new UserEmail(email))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이메일은 공백일 수 없습니다.");
    }
}
