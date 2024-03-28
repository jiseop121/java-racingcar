package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validation.ErrorMessage.INPUT_RACE_COUNT_INPUT_NUMBER;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import model.Cars;
import model.RaceCount;
import org.junit.jupiter.api.Test;
import validation.ErrorMessage;


class InputViewTest {

    private InputView inputView;

    InputViewTest() {
        inputView = null;
    }

    @Test
    void Cars_정상입력(){
        String stringInput = "123,as12,가나다";
        List<String> carNames = List.of("123","as12","가나다");
        
        inputView = setInputScanner(stringInput);
        Cars cars = inputView.inputCars();
        assertThat(getCarNameValue(cars,0)).isEqualTo(carNames.get(0));
        assertThat(getCarNameValue(cars,1)).isEqualTo(carNames.get(1));
        assertThat(getCarNameValue(cars,2)).isEqualTo(carNames.get(2));
    }

    private static String getCarNameValue(Cars cars,int index) {
        return cars.playCars().get(index).carName().value();
    }

    @Test
    void Cars_비정상입력_중복콤마_예외출력(){
        String stringInput = "123,,as12,가나다";

        inputView = setInputScanner(stringInput);
        testInputCarsCommaFormatError();
    }

    private void testInputCarsCommaFormatError() {
        assertThatThrownBy(()-> inputView.inputCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_CARS_COMMA_FORMAT.getMessage());
    }

    @Test
    void Cars_비정상입력_컴마로_시작이거나_끝_예외출력(){
        String stringInput1 = ",123,as12,가나다";

        inputView = setInputScanner(stringInput1);

        testInputCarsCommaFormatError();

        String stringInput2 = "123,as12,가나다,";

        inputView = setInputScanner(stringInput2);

        testInputCarsCommaFormatError();
    }

    @Test
    void RaceCount_정상입력(){
        String normalCount = "10";
        int normalCountInt = 10;

        inputView = setInputScanner(normalCount);
        RaceCount raceCount = inputView.inputRaceCount();
        assertThat(raceCount.value()).isEqualTo(normalCountInt);
    }

    @Test
    void RaceCount_정상입력_양끝_공백_삭제(){
        String normalCountWithSpace1 = "10 ";
        String normalCountWithSpace2 = " 10";
        int normalCountInt = 10;

        inputView = setInputScanner(normalCountWithSpace1);
        RaceCount raceCount1 = inputView.inputRaceCount();

        inputView = setInputScanner(normalCountWithSpace2);
        RaceCount raceCount2 = inputView.inputRaceCount();

        assertThat(raceCount1.value()).isEqualTo(normalCountInt);
        assertThat(raceCount2.value()).isEqualTo(normalCountInt);
    }

    @Test
    void RaceCount_비정상입력_숫자가아니면_예외출력(){
        String stringInput = "12a";

        inputView = setInputScanner(stringInput);
        assertThatThrownBy(() -> inputView.inputRaceCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_RACE_COUNT_INPUT_NUMBER.getMessage());
    }

    private static InputView setInputScanner(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        return new InputView(new InputParser(),scanner);
    }
}