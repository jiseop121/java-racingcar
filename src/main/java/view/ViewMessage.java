package view;

public enum ViewMessage {
    INPUT_CARS_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_RACE_COUNT_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_START_MESSAGE("실행결과"),
    FINALLY_WIN("가 최종 우승했습니다.");

    private final String message;
    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
