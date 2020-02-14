package umd.mad.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_DICE = 2;
    private int btnMaterial;
    private int[] viewIDs = {
            R.id.die1,
            R.id.die2
    };

    private final DiceMaster DM = new DiceMaster(MAX_DICE);
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player turnPlayer = player1;
    private boolean p1Turn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void quit(View view) {
        finish();
        System.exit(0);
    }

    public void play(View view) {
        setContentView(R.layout.activity_game);
        // init();
    }

    public void roll(View view) {
        ImageView imageView;
        int resourceID;

        DM.rollDice();
        for (int i = 0; i < MAX_DICE; i++) {
            imageView = findViewById(viewIDs[i]);

            resourceID = DM.getDice()[i].getCurrentDieFaceResource();
            imageView.setImageResource(resourceID);
        }


        // apply rule effects
        setHoldActive(true); // initially set to true
        if (DM.hasAnyOnes()) {
            turnPlayer.turnScore = 0;
            if (DM.hasAllOnes()) {
                turnPlayer.totalScore = 0;
            }

            endTurn();
        }
        else {
            turnPlayer.turnScore += DM.getLastTotal();
            if (DM.hasAllSameNonOne()) {
                setHoldActive(false);
            }
        }

        updateScoreUI();
    }

    private void setHoldActive(boolean enabled) {

        Button holdButton = findViewById(R.id.holdButton);
        holdButton.setEnabled(enabled);

    }

    private void endTurn() {
        TextView tvPlayer = findViewById(R.id.currentPlayerTurn);

        if (p1Turn) {
            turnPlayer = player2;
            tvPlayer.setText(R.string.player2text);
            tvPlayer.setBackgroundResource(R.drawable.p2color);
        }
        else {
            turnPlayer = player1;
            tvPlayer.setText(R.string.player1text);
            tvPlayer.setBackgroundResource(R.drawable.p1color);
        }

        p1Turn = !p1Turn;
    }

    private void updateScoreUI() {
        TextView tvTotalScore;
        TextView tvTurnScore;

        tvTurnScore = findViewById(R.id.turnScore);
        if (p1Turn) {
            tvTotalScore = findViewById(R.id.player1Score);
        }
        else {
            tvTotalScore = findViewById(R.id.player2Score);
        }

        tvTurnScore.setText(String.format(Locale.US, "%d", turnPlayer.turnScore));
        tvTotalScore.setText(String.format(Locale.US, "%d", turnPlayer.totalScore));


    }

    public void hold(View view) {

        turnPlayer.totalScore += turnPlayer.turnScore;
        turnPlayer.turnScore = 0;

        updateScoreUI();
        endTurn();
    }
}
