package validation;

public enum ErrorMessage {
    INPUT_RACE_COUNT_INPUT_NUMBER("숫자를 입력하세요"),
    INPUT_CARS_COMMA_FORMAT("쉼표 작성 형식을 맞춰서 입력해주세요."),

    COUNT_NOT_MINUS("음수를 입력할 수 없습니다."),
    RACE_COUNT_NO_OVER_1000("경주 횟수는 1000회를 넘을 수 없습니다."),

    CAR_NAME_NO_OVER_MAX_LENGTH("자동차 이름은 5글자 이하로 작성해야 합니다."),
    CAR_NAME_NO_BLANK("자동차 이름은 공백일 수 없습니다."),
    CARS_HAS_DUPLICATED_NAMES("중복된 자동차 이름이 존재합니다.");


    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
