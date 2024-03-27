package validation;

public enum ErrorMessage {
    INPUT_RACE_COUNT_INPUT_NUMBER("숫자를 입력하세요"),
    INPUT_CARS_COMMA_FORMAT("쉼표 작성 형식을 맞춰서 입력해주세요.");



    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
