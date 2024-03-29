package manager;

import controller.RacingController;
import java.util.Scanner;
import model.RaceAllOperator;
import model.RaceOnceOperator;
import model.RandomNumberGenerator;
import model.WinningCarChecker;
import model.domain.Cars;
import model.domain.RaceCount;
import model.domain.WinningCarNames;
import view.InputParser;
import view.InputView;
import view.OutputView;

public class GameFlowManager {

    private final Scanner scanner;
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingController racingController;

    public GameFlowManager(Scanner scanner) {
        this.scanner = scanner;
        inputView = initInputView();
        outputView = new OutputView();
        racingController = initRacingController();
    }

    public void doGame(){
        Cars cars = inputCarsWithMessage();
        RaceCount raceCount = inputRaceCountWithMessage();

        String allRaceResult = racingController.runAllRace(cars, raceCount);

        WinningCarNames winningCarNames = racingController.pickWinningCarNames(cars,raceCount);

        outputView.displayResultAll(allRaceResult,winningCarNames);
    }

    private RaceCount inputRaceCountWithMessage() {
        outputView.displayInputRaceCountMessage();
        return inputView.inputRaceCount();
    }

    private Cars inputCarsWithMessage() {
        outputView.displayInputCarsMessage();
        return inputView.inputCars();
    }


    private static RacingController initRacingController() {
        return new RacingController(
                initRaceAllOperator(),
                new WinningCarChecker()
        );
    }

    private static RaceAllOperator initRaceAllOperator() {
        return new RaceAllOperator(initRaceOnceOperator());
    }

    private static RaceOnceOperator initRaceOnceOperator() {
        return new RaceOnceOperator(new RandomNumberGenerator());
    }

    private InputView initInputView() {
        return new InputView(new InputParser(),scanner);
    }

}
