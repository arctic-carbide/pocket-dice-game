package umd.mad.dicegame;

import java.util.Random;

public class GameDie {
    private final int STARTING_INDEX = 1; // an added offset to determine where an index starts
    private final int MAX_DICE_VALUE = 6;

    private Random r = new Random();
    private int lastRollResult; // the recorded result since the last roll

    public Integer roll() {
        lastRollResult = r.nextInt(MAX_DICE_VALUE) + STARTING_INDEX; // generate a number between 1 and 6 inclusive
        return lastRollResult;
    }

    public int getLastRollResult() {
        return lastRollResult;
    }
}
