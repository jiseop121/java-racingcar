package model.domain;

import java.util.List;
import validation.RaceValidator;

public record Cars(List<Car> playCars) {
    public Cars {
        RaceValidator.validateCars(playCars);
    }
}
