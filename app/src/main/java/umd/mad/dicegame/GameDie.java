package umd.mad.dicegame;

import java.util.Random;

public class GameDie {
    private final int MIN_DICE_VALUE = 1; // an added offset to determine where an index starts
    private final int MAX_DICE_VALUE = 6;
    private static int instances = 0;

    private final int ID_NUMBER;

    private static final int[] FACES = {
            R.drawable.die_face_1,
            R.drawable.die_face_2,
            R.drawable.die_face_3,
            R.drawable.die_face_4,
            R.drawable.die_face_5,
            R.drawable.die_face_6
    };

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

    public int getCurrentDieFaceResource() { return FACES[lastRollResult - MIN_DICE_VALUE]; }

}
