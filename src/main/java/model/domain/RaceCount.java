package model.domain;

import validation.RaceValidator;

public record RaceCount(int value) {
    public RaceCount {
        RaceValidator.validateRaceCount(value);
    }
}
