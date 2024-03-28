package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import validation.ErrorMessage;

class CarNameTest {

    @Test
    void CarName_정상(){
        String normalName = "car1";
        CarName car1 = new CarName(normalName);
        assertThat(car1.value()).isEqualTo(normalName);
    }

    @Test
    void CarName_공백_예외출력(){
        assertThatThrownBy(() -> new CarName(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_NO_BLANK.getMessage());
    }

    @Test
    void CarName_5글자_초과_예외출력(){
        assertThatNoException().isThrownBy(() -> new CarName("12345"));

        assertThatThrownBy(() -> new CarName("123123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_NO_OVER_MAX_LENGTH.getMessage());
    }
}