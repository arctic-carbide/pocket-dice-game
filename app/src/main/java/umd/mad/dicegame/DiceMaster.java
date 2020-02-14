package umd.mad.dicegame;

import java.util.Dictionary;
import java.util.concurrent.LinkedBlockingQueue;

public class DiceMaster {


    private GameDie[] dice;
    private int[] lastRollResults;
    private int lastTotal = 0;


    public DiceMaster(int numberOfDice) {
        dice = new GameDie[numberOfDice];
        lastRollResults = new int[numberOfDice];

        for (int i = 0; i < dice.length; i++) {
            dice[i] = new GameDie();
        }
    }

    public int[] rollDice() {
        int sum = 0;

        for (int i = 0; i < dice.length; i++) {
            lastRollResults[i] = dice[i].roll();
            sum += lastRollResults[i];
        }

        lastTotal = sum;
        return lastRollResults;
    }

    public void checkDice() {
        try {

        }
        catch (Exception e) {

        }
    }

    public boolean hasAnyOnes() {
        for (GameDie die : dice) {
            if (die.getLastRollResult() == 1) {
                return true;
            }
        }

        return false;
    }

    public boolean hasAllOnes() {

        for (GameDie die : dice) {
            if (die.getLastRollResult() != 1) {
                return false;
            }
        }

        return true;
    }

    public boolean hasAllSameNonOne() {

        for (int i = 0; i < dice.length - 1; i++) {
            if (dice[i].getLastRollResult() != dice[i+1].getLastRollResult()) {
                return false;
            }
        }

        return true;
    }

    public int getLastTotal() {
        return lastTotal;
    }

    public int[] getLastRollResults() {
        return lastRollResults;
    }

    public GameDie[] getDice() {
        return dice;
    }

}
