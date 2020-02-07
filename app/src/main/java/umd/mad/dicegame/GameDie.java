package umd.mad.dicegame;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class GameDie {
    private final int MIN_DICE_VALUE = 1; // an added offset to determine where an index starts
    private final int MAX_DICE_VALUE = 6;
    private static int instances = 0;

    private final int ID_NUMBER;

    private Random roller = new Random();
    private Integer lastRollResult; // the recorded result since the last roll

    public GameDie() {
        instances++;
        ID_NUMBER = instances;
    }

    public Integer roll() {
        lastRollResult = roller.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE; // generate a number between 1 and 6 inclusive
        return lastRollResult;
    }

    public Integer getLastRollResult() {
        return lastRollResult;
    }

    public Integer getID_NUMBER() {
        return ID_NUMBER;
    }
}
