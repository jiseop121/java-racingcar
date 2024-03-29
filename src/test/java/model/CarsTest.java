package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.domain.Cars;
import org.junit.jupiter.api.Test;
import validation.ErrorMessage;
import view.InputParser;

class CarsTest {
    private final InputParser inputParser = new InputParser();

    @Test
    void Cars_생성_정상(){
        String inputNormalCars = "123,ab12,가나다";
        Cars cars = inputParser.initCarsFromCarNames(inputNormalCars);
        assertThat(getCarNameValue(cars,0)).isEqualTo("123");
        assertThat(getCarNameValue(cars,1)).isEqualTo("ab12");
        assertThat(getCarNameValue(cars,2)).isEqualTo("가나다");
    }

    private static String getCarNameValue(Cars cars,int index) {
        return cars.playCars().get(index).carName().value();
    }

    @Test
    void Cars_생성_비정상_중복이름_예외출력() {
        String inputDupliNames = "123,123,가나다";
        assertThatThrownBy(() -> inputParser.initCarsFromCarNames(inputDupliNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CARS_HAS_DUPLICATED_NAMES.getMessage());

    }
}