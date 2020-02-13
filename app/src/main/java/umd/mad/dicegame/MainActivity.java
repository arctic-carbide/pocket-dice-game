package umd.mad.dicegame;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_DICE = 2;
    private GameDie[] dice = new GameDie[MAX_DICE];
    private int[] viewIDs = {
            R.id.die1,
            R.id.die2
    };

    private boolean turn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init() {
        for (int i = 0; i < MAX_DICE; i++) {
            dice[i] = new GameDie();
        }
    }

    public void quit(View view) {
        finish();
        System.exit(0);
    }

    public void play(View view) {
        setContentView(R.layout.activity_main2);
        init();
    }

    public void roll(View view) {
        roll();
    }

    private void roll() {
        ImageView imageView;
        int resourceID;

        for (int i = 0; i < MAX_DICE; i++) {
            imageView = findViewById(viewIDs[i]);

            dice[i].roll();
            resourceID = dice[i].getCurrentDieFaceResource();
            imageView.setImageResource(resourceID);
        }

        endTurn();
    }

    private void endTurn() {
        TextView textView = findViewById(R.id.textView);

        if (turn) {
            textView.setText(R.string.player2text);
            textView.setBackgroundResource(R.drawable.p2color);
        }
        else {
            textView.setText(R.string.player1text);
            textView.setBackgroundResource(R.drawable.p1color);
        }

        turn = !turn;
    }

    public void hold(View view) {
        //
    }
}
