package view;

import static view.ViewMessage.FINALLY_WIN;
import static view.ViewMessage.INPUT_CARS_MESSAGE;
import static view.ViewMessage.INPUT_RACE_COUNT_MESSAGE;
import static view.ViewMessage.RESULT_START_MESSAGE;

import model.domain.CarName;
import model.domain.WinningCarNames;

public class OutputView {
    public void displayInputCarsMessage(){
        System.out.println(INPUT_CARS_MESSAGE.getMessage());
    }

    public void displayInputRaceCountMessage(){
        System.out.println(INPUT_RACE_COUNT_MESSAGE.getMessage());
    }


    private void displayResultRaceOnce(String allRaceResult){
        System.out.println(RESULT_START_MESSAGE.getMessage());
        System.out.println(allRaceResult);
    }

    public void displayResultAll(String allRaceResult,WinningCarNames winningCarNames){
        displayResultRaceOnce(allRaceResult);
        displayWinningCars(winningCarNames);
    }

    private void displayWinningCars(WinningCarNames winningCarNames){
        StringBuilder sb = generateWinningCarNamesMessage(winningCarNames);

        System.out.println(sb);
    }

    private static StringBuilder generateWinningCarNamesMessage(WinningCarNames winningCarNames) {
        StringBuilder sb = new StringBuilder();
        for(CarName carName : winningCarNames.carNames()){
            sb.append(carName.value());
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(FINALLY_WIN.getMessage());
        return sb;
    }
}
