package validation;

import static validation.ErrorMessage.*;

public class RaceValidator {
    private static final String COMMA = ",";
    private static final String DOUBLE_COMMA =",,";

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

    public static void validateRaceCount(String inputRaceCount){
        try{
            Integer.parseInt(inputRaceCount.trim());
        }catch (Exception e){
            throw new IllegalArgumentException(INPUT_RACE_COUNT_INPUT_NUMBER.getMessage());
        }
    }

}
