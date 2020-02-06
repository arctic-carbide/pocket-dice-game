package umd.mad.dicegame;

import java.util.Random;

public class GameDie {
    private final int STARTING_INDEX = 1; // an added offset to determine where an index starts
    private final int MAX_DICE_VALUE = 6;

    private Random r = new Random();
    private int lastResult;

    public Integer roll() {
        lastResult = r.nextInt(MAX_DICE_VALUE) + STARTING_INDEX; // generate a number between 1 and 6 inclusive
        return lastResult;
    }

    public int getLastResult() {
        return lastResult;
    }
}
