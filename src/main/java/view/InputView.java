package view;

import java.util.Scanner;
import model.Cars;
import model.RaceCount;
import validation.RaceValidator;

public class InputView {
    private final InputParser inputParser;
    private final Scanner scanner;

    public InputView(InputParser inputParser, Scanner scanner) {
        this.inputParser = inputParser;
        this.scanner = scanner;
    }

    public Cars inputCars(){
        String inputCars = scanner.nextLine();
        RaceValidator.validateInputCars(inputCars);
        return inputParser.initCarsFromCarNames(inputCars);
    }

    public RaceCount inputRaceCount(){
        String inputRaceCount = scanner.nextLine();
        RaceValidator.validateRaceCount(inputRaceCount);
        return inputParser.initRaceCount(inputRaceCount);
    }

}
