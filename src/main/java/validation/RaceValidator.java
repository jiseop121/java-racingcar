package validation;

import static validation.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Car;

public class RaceValidator {
    private static final String COMMA = ",";
    private static final String DOUBLE_COMMA =",,";

    private static final int MAX_RACE_COUNT = 1000;
    private static final int ZERO = 0;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateInputCars(String inputCars){
        checkDoubleComma(inputCars);
        checkStartOrEndWithComma(inputCars);

    }

    private static void checkStartOrEndWithComma(String inputCars) {
        if (inputCars.startsWith(COMMA) || inputCars.endsWith(COMMA)){
            throw new IllegalArgumentException(INPUT_CARS_COMMA_FORMAT.getMessage());
        }
    }

    private static void checkDoubleComma(String inputCars) {
        if (inputCars.contains(DOUBLE_COMMA)) {
            throw new IllegalArgumentException(INPUT_CARS_COMMA_FORMAT.getMessage());
        }
    }

    public static void validateInputRaceCount(String inputRaceCount){
        try{
            Integer.parseInt(inputRaceCount.trim());
        }catch (Exception e){
            throw new IllegalArgumentException(INPUT_RACE_COUNT_INPUT_NUMBER.getMessage());
        }
    }

    public static void validateRaceCount(int value){
        checkIsMinus(value);
        checkIsOverMaxRaceCount(value);
    }

    private static void checkIsOverMaxRaceCount(int value) {
        if(value >MAX_RACE_COUNT){
            throw new IllegalArgumentException(ErrorMessage.RACE_COUNT_NO_OVER_1000.getMessage());
        }
    }

    private static void checkIsMinus(int value) {
        if(value <ZERO){
            throw new IllegalArgumentException(ErrorMessage.COUNT_NOT_MINUS.getMessage());
        }
    }


    public static void validateCarName(String  value){
        checkIsBlank(value);
        checkIsOverMaxNameLength(value);
    }

    private static void checkIsOverMaxNameLength(String value) {
        if (value.length()>MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException(CAR_NAME_NO_OVER_MAX_LENGTH.getMessage());
        }
    }

    private static void checkIsBlank(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException(CAR_NAME_NO_BLANK.getMessage());
        }
    }

    public static void validateRaceDistance(int value){
        checkIsMinus(value);
    }

    public static void validateCars(List<Car> playCars) {
        Set<String> carNames = new HashSet<>();
        playCars.forEach(
                car -> {
                    checkIsDuplicatedCarName(car, carNames);
                }
        );
    }

    private static void checkIsDuplicatedCarName(Car car, Set<String> carNames) {
        String carName = car.getCarName().value();
        if (!carNames.add(carName)) {
            throw new IllegalArgumentException(CARS_HAS_DUPLICATED_NAMES.getMessage());
        }
    }

}
