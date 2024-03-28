package model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MAX_NUMBER = 10;

    private final Random random = new Random();

    @Override
    public int getRandomNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
