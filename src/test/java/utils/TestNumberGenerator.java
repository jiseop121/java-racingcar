package utils;

import java.util.List;
import model.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    private final List<Integer> numberList;

    public TestNumberGenerator(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @Override
    public int getRandomNumber() {
        return numberList.remove(0);
    }
}
