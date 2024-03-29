package manager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameFlowManagerTest {

    @Test
    void doGame_정상작동(){
        Scanner scanner1 = setInputScanner("asdf,123,qwe\n5");

        // Redirect System.out to ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldOut = System.out;
        System.setOut(printStream);

        GameFlowManager gameFlowManager = new GameFlowManager(scanner1);
        gameFlowManager.doGame();

        // Restore System.out
        System.out.flush();
        System.setOut(oldOut);

        // Check output using assertions
        String output = outputStream.toString();
        Assertions.assertThat(output).containsIgnoringWhitespaces(
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                "시도할 회수는 몇회인가요?",
                "실행 결과",
                "가 최종 우승했습니다."
        );
    }

    private static Scanner setInputScanner(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        return new Scanner(in);
    }
}