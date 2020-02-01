package umd.mad.dicegame;

import java.util.Random;

public class GameDie {
    private Random r = new Random();
    private int lastResult;
    private final int OFFSET = 1;
    private final int MAX_DICE_VALUE = 6;

    public Integer roll() {
        lastResult = r.nextInt(MAX_DICE_VALUE) + OFFSET; // generate a number between 1 and 6 inclusive
        return lastResult;
    }

    public int getLastResult() {
        return lastResult;
    }
}
