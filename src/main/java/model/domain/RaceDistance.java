package model.domain;

import validation.RaceValidator;

public class RaceDistance {
    private int value;

    public RaceDistance(int value) {
        RaceValidator.validateRaceDistance(value);
        this.value = value;
    }

    public void plus() {
        this.value++;
    }

    public String getImageWithBars(){
        return "-".repeat(value);
    }

    public int getValue() {
        return value;
    }
}
