import java.util.Scanner;
import manager.GameFlowManager;

public class RacingMain {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        GameFlowManager gameFlowManager = new GameFlowManager(SCANNER);
        gameFlowManager.doGame();
    }
}
