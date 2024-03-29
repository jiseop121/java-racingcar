package model.domain;

import validation.RaceValidator;

public record CarName(String value) {
    public CarName {
        RaceValidator.validateCarName(value);
    }
}
