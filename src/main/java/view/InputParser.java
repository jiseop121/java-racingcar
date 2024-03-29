package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.domain.Car;
import model.domain.Cars;
import model.domain.RaceDistance;
import model.domain.CarName;
import model.domain.RaceCount;

public class InputParser {

    public Cars initCarsFromCarNames(String inputCars){
        List<String> carNames = readCarNamesFromInput(inputCars);
        List<Car> initCars = new ArrayList<>();
        carNames.forEach(
                carName ->{
                    initCars.add(initCar(carName));
                }
        );
        return new Cars(initCars);
    }

    public RaceCount initRaceCount(String inputRaceCount){
        return new RaceCount(parseInt(inputRaceCount.trim()));
    }

    private int parseInt(String inputRaceCount){
        return Integer.parseInt(inputRaceCount);
    }

    private List<String> readCarNamesFromInput(String inputCars) {

        return Arrays.stream(inputCars.split(","))
                .collect(Collectors.toList());
    }

    private Car initCar(String carName){
        return new Car(
                new CarName(carName),
                new RaceDistance(0)
        );
    }
}
