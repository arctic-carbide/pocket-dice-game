package umd.mad.dicegame;

import java.util.Random;

public class GameDie {
    private static final int MIN_DICE_VALUE = 1; // an added offset to determine where an index starts
    private static final int MAX_DICE_VALUE = 6;

    private static final int[] FACES = {
            R.drawable.die_face_1,
            R.drawable.die_face_2,
            R.drawable.die_face_3,
            R.drawable.die_face_4,
            R.drawable.die_face_5,
            R.drawable.die_face_6
    };

    private Random roller = new Random();
    private Integer lastRollResult; // the recorded result since the last rollDice

    public int roll() {
        lastRollResult = roller.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE; // generate a number between 1 and 6 inclusive
        return lastRollResult;
    }

    public int getLastRollResult() {
        return lastRollResult;
    }

    public int getCurrentDieFaceResource() { return FACES[lastRollResult - MIN_DICE_VALUE]; }

    public static int getDieFace(int faceNumber) {
        return FACES[faceNumber - MIN_DICE_VALUE];
    }

}
